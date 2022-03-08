package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import ar.com.educacionit.dao.ArticuloDao;
import ar.com.educacionit.domain.Articulos;

public class ArticulosDaoImpl extends JdbcDaoBase<Articulos> implements ArticuloDao {

	public ArticulosDaoImpl() {
		super("articulos");
	}

	
	@Override
	public String getSaveSQL() {
//		lo particular del sql
		return ("(titulo, codigo, fecha_creacion, precio, stock, marcas_id, categorias_id)"
		        + " VALUES (?, ?, ?, ?, ?, ?, ?)");
	}

	@Override
	protected void save(PreparedStatement preparedStatement, Articulos entity) throws SQLException {
		// resivo esl preparedStatement con el sql seteado (insert into categorias (
		// atributo1) values ()
		preparedStatement.setString(1, entity.getTitulo());
		preparedStatement.setString(2, entity.getCodigo());
		preparedStatement.setDate(3, new java.sql.Date(entity.getFechaCreacion().getTime()));
		preparedStatement.setDouble(4, entity.getPrecio());
		preparedStatement.setLong(5, entity.getStock());
		preparedStatement.setLong(6, entity.getMarcaId());
		preparedStatement.setLong(7, entity.getCategoriaId());
	}

	@Override
	public String getUpdateSQL() {
		return "titulo = ?, precio = ?, stock = ?, marcas_id = ?, categorias_id = ?";
		
	}

	@Override
	protected void update(PreparedStatement preparedStatement, Articulos entity) throws SQLException {
		preparedStatement.setString(1, entity.getTitulo());
		preparedStatement.setDouble(2, entity.getPrecio());
		preparedStatement.setLong(3, entity.getStock());
		preparedStatement.setLong(4, entity.getMarcaId());
		preparedStatement.setLong(5, entity.getCategoriaId());
		
	}

	

}
