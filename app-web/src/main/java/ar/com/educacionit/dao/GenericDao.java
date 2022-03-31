package ar.com.educacionit.dao;



import java.util.List;

import ar.com.educacionit.exceptions.DuplicatedException;
import ar.com.educacionit.exceptions.GenericException;

public interface GenericDao<T> {

	public T getOne(Long id) throws GenericException;

	public void delete(Long id) throws GenericException;

	public T save(T entity) throws DuplicatedException, GenericException;

	public void update(T entity) throws GenericException, DuplicatedException;

	public List<T> findAll() throws GenericException;
	
	public List<T> findBySQL(String sql) throws GenericException;
}
