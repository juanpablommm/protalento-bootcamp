package ar.com.educacionit.dao.impl;

import java.lang.reflect.ParameterizedType;



import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.domain.Entity;

/*
 * las t son entidades que representan tablas
 * por ende van a heredar de entity*/

public class JdbcDaoBase<T extends Entity> implements GenericDao<T>{

	protected String tabla;
	protected Class<T> clazz;
	//getName
	//fields< nombre, apellido o lo que sea
	
	public JdbcDaoBase(String tablaDelHijo) {
		this.tabla = tablaDelHijo;
		//api reflection de java
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T getOne(Long id) {
		String sql = "SELECT *FROM " + tabla + " WHERE ID = " + id;
		System.out.println("Ejecutando " + sql);
		T entity;
		try {
			//entity = this.clazz.newInstance();
			entity = clazz.getDeclaredConstructor().newInstance();
			entity.setId(id);
//			clase utilitaria que va a saber como tomar 
//			la instancia y como armar los seteos de 
//			los atributos
		} catch (Exception e) {
			entity = null;
		}
		return entity;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public T save(T entity) {
		
		return null;
	}

	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	public T[] findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
