package ar.com.educacionit.dao.impl;

import ar.com.educacionit.dao.CategoriaDao;

import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Socios;

public class CategoriaDaoImpl extends JdbcDaoBase<Categorias> implements CategoriaDao {

	public CategoriaDaoImpl() {
		super("categorias");
	}

	@Override
	public String getSaveSQL(Categorias entity) {
		
		
//		lo particular del sql
		return ("(descripcion, codigo) VALUES (" + entity.getDescripcion() + "," + entity.getCodigo() + "," +  ")");
	}

	@Override
	public String getUpdateSQL(Categorias entity) {
		String sql = "descripcion= '" + entity.getDescripcion() + "',";
		sql = sql + "codigo= '" + entity.getCodigo() + "',";
		return sql;
	}

		
	/*
	 * public Categorias getOne(Long id) { String sql =
	 * "SELECT *FROM CATEGORIA  WHERE ID = " + id; System.out.println("ejecutando "
	 * + sql); return new Categorias(id, "categoria 1", "abc000"); }
	 * 
	 * public void delete(Long id) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * public Categorias save(Categorias entity) { String sql =
	 * "INSERT INTO CATEGORIA(descripcion, codigo) VALUES ('" +
	 * entity.getDescripcion() + "', '" + entity.getCodigo() + "')";
	 * System.out.println("Ejecutando sql:" + sql);
	 * 
	 * entity.setId(1l); return entity; }
	 * 
	 * public void update(Categorias entity) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * public Categorias[] findAll() { // TODO Auto-generated method stub return
	 * null; }
	 */

}
