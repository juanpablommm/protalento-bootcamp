package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.dao.MarcasDao;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Marcas;
import ar.com.educacionit.domain.Socios;

public class MarcasDaoImpl extends JdbcDaoBase<Marcas> implements MarcasDao {

	public MarcasDaoImpl() {
		super("marcas");
	}

	@Override
	public String getSaveSQL() {

//		lo particular del sql
		return ("(descripcion, codigo, habilitada) VALUES (?, ?, ?)");
	}

	@Override
	protected void save(PreparedStatement preparedStatement, Marcas entity) throws SQLException {
		// resivo esl preparedStatement con el sql seteado (insert into categorias (
		// atributo1) values ()
		preparedStatement.setString(1, entity.getDescripcion());
		preparedStatement.setString(2, entity.getCodigo());
		preparedStatement.setLong(3, entity.getHabilitada());
	}

	@Override
	public String getUpdateSQL() {
		return "descripcion = ?, habilitada = ?";
		
	}

	@Override
	protected void update(PreparedStatement preparedStatement, Marcas entity) throws SQLException {
		preparedStatement.setString(1, entity.getDescripcion());
		preparedStatement.setLong(2, entity.getHabilitada());
		
	}

	

}
