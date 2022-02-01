package ar.com.educacionit.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.dao.util.DTOUtils;
import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.exceptions.DuplicatedException;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.jdb.AdministradorDeConexiones;

/*
 * las t son entidades que representan tablas
 * por ende van a heredar de entity*/

public abstract class JdbcDaoBase<T extends Entity> implements GenericDao<T> {

	protected String tabla;
	protected Class<T> clazz;
	// getName
	// fields< nombre, apellido o lo que sea

	public JdbcDaoBase(String tablaDelHijo) {
		this.tabla = tablaDelHijo;
		// api reflection de java
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T getOne(Long id) throws GenericException {

		if (id == null) {
			throw new GenericException("Id no informado");
		}

		String sql = "SELECT *FROM " + tabla + " WHERE ID = " + id;

		T entity = null;
		try (Connection connection = AdministradorDeConexiones.obtenerConexion();) {

			try (Statement statement = connection.createStatement()) {

				try (ResultSet resultSet = statement.executeQuery(sql)) {

					List<T> lista = DTOUtils.populateDTOs(this.clazz, resultSet);

					if (!lista.isEmpty()) {
						entity = lista.get(0);
					}
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql, e);
		}
		return entity;
	}

	public void delete(Long id) throws GenericException {
		if (id == null) {
			throw new GenericException("El id informado es NULL");
		}
		String sql = "DELETE FROM " + this.tabla + " WHERE ID =?";

		try (Connection connection = AdministradorDeConexiones.obtenerConexion();) {

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				preparedStatement.setLong(1, id);

				preparedStatement.executeUpdate();

			}
		} catch (Exception e) {
			throw new GenericException("No se pudo eliminar: " + sql, e);
		}
	}

	public T save(T entity) throws DuplicatedException, GenericException {

		String sql = "INSERT INTO " + this.tabla + this.getSaveSQL();
		try (Connection connection = AdministradorDeConexiones.obtenerConexion();) {

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS)) {

				this.save(preparedStatement, entity);//solo se encarga de setear los ?? el tipos y dato
				
				preparedStatement.execute();
				
				try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

					if(resultSet.next()) {
						
						Long lastGenerateId = resultSet.getLong(1);//aca esta el id que se inserto
						entity.setId(lastGenerateId);
						
					}
				}

			}
		}catch(Exception e){
			throw new GenericException("No se pudo insertar: " + sql, e);
		}return entity;
	}



	public void update(T entity) throws GenericException, DuplicatedException {
		String sql = "UPDATE " + this.tabla + " SET " + this.getUpdateSQL() + " WHERE ID = " + entity.getId();
		
		try (Connection connection = AdministradorDeConexiones.obtenerConexion();) {

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				this.update(preparedStatement, entity);//solo se encarga de setear los ?? el tipos y dato
				
				preparedStatement.execute();


			}
		}catch(SQLException e){
			//analizar si ahy duplicate
			if(e instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido actualizar " + sql, e);
			}
			
			//ojo ver mas tipos si es necesario
			throw new GenericException("No se pudo actualizar: " + sql, e);
		}
		
		
		
	}


	public List<T> findAll() throws GenericException {
		List<T> lista = new ArrayList<T>();
		String sql = "SELECT *FROM " + this.tabla;
//		necesito las interface
//		connection
//		steatement
//		resulset
		try (Connection connection = AdministradorDeConexiones.obtenerConexion();) {

			try (Statement statement = connection.createStatement()) {

				try (ResultSet resultSet = statement.executeQuery(sql)) {

					lista = DTOUtils.populateDTOs(this.clazz, resultSet);
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql, e);
		}
		return lista;
	}

	protected abstract void update(PreparedStatement preparedStatement, T entity) throws SQLException;
	public abstract String getUpdateSQL();
	
	protected abstract void save(PreparedStatement preparedStatement, T entity) throws SQLException;
//	los hijos estan obligados a implementarlos
	public abstract String getSaveSQL();
}
