package ar.com.educacionit.dao.impl;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.exceptions.DuplicatedException;
import ar.com.educacionit.exceptions.GenericException;

/*
 * las t son entidades que representan tablas
 * por ende van a heredar de entity*/

public abstract class JdbcDaoBase<T extends Entity> implements GenericDao<T>{

	protected String tabla;
	protected Class<T> clazz;
	//getName
	//fields< nombre, apellido o lo que sea
	
	public JdbcDaoBase(String tablaDelHijo) {
		this.tabla = tablaDelHijo;
		//api reflection de java
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T getOne(Long id) throws GenericException{
		
		if(id == null) {
			throw new GenericException("Id no informado");
		}
		
		String sql = "SELECT *FROM " + tabla + " WHERE ID = " + id;
		System.out.println("Ejecutando " + sql);
		T entity;
		try {
			//entity = this.clazz.newInstance();
			entity = clazz.getDeclaredConstructor().newInstance();
			entity.setId(id);

//			cuando viene desde la db
//			paises_id > Socios.paisesID(objeto)
			
//			tomar los metodos de this.clazz 
//			para cadada method > method.invoke(entity)
			
//			clase utilitaria que va a saber como tomar 
//			la instancia y como armar los seteos de 
//			los atributos
		} catch (Exception e) {
			entity = null;
		}
		return entity;
	}

	public void delete(Long id) throws GenericException{
		String sql = "DELETE FROM " + this.tabla + "WHERE ID = " + id;
		System.out.println(sql);
//		execute
//		error de  conexion!!!
		
	}

	
//	public T save(T entity) throws DuplicatedException{
//		StringBuffer sql =  new StringBuffer("INSERT INTO ").append(this.tabla).append("(");
//		StringBuffer valuesSql = new StringBuffer(") VALUES (");
//		try {
//			T inctance = this.clazz.getConstructor().newInstance();
//			
////			le pido los fields
//			Field fields[] = inctance.getClass().getDeclaredFields();
//			for(Field field:  fields) {
//				field.setAccessible(true);
//				
//				if(field.get(entity) != null) {
//					sql.append(field.getName()).append(",");
//					valuesSql.append("'").append(field.get(entity)).append("'").append(",");
//					
//				}
//				
//			}
////			insert into entity(nombre, apellido) values (valor, valor3 valor2,)
//			sql = new StringBuffer(sql.substring(0, sql.length() - 1));
//			valuesSql =  new StringBuffer(valuesSql.substring(0, valuesSql.length() - 1));
//			valuesSql.append(")");
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//		String sqlFinal = sql.toString() + valuesSql.toString();
//		
//		
//		System.out.println(sqlFinal);
//		return null;
//	}
	
	public T save(T entity) throws DuplicatedException{
		String sql = "INSERT INTO " + this.tabla + this.getSaveSQL(entity);
		System.out.println(sql);
		entity.setId(12l);
		return entity;
	}
	
//	los hijos estan obligados a implementarlos
	public abstract String getSaveSQL(T entity);

	public void update(T entity) {
		String sql = "UPDATE " + this.tabla + " SET " + this.getUpdateSQL(entity) + " WHERE ID = " + entity.getId();
		System.out.println(sql);
	}
	
	public abstract String getUpdateSQL(T entity);

	public List<T> findAll() {
		String sql = "SELECT *FROM " + this.tabla;
		System.out.println(sql);
//		la informacion debe venir desde la base de datos
		
//		supongo que hay dos registros
		List<T> instances = new ArrayList<T>();
		T insctance;
		try {
			insctance = this.clazz.getDeclaredConstructor().newInstance();
			insctance.setId(1l);
			instances.add(insctance);
			instances.add(insctance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instances;
	}

}
