package ar.com.educacionit.services.impl;



import java.util.List;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.exceptions.DuplicatedException;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.services.GenericService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class AbstractBaseService<T> implements GenericService<T>{

	protected GenericDao<T> genericDao;
	
	public AbstractBaseService(GenericDao<T> dao) {
	    if(dao == null) {
            throw new IllegalArgumentException("El dao no puede ser NULL");
        }
        this.genericDao = dao;
	}

	public T getOne(Long id) throws ServiceException{
		T entity;
		try {
			entity = genericDao.getOne(id);
		} catch (GenericException e) {
			throw new ServiceException("Error de DB al intentar obtener entity id=" + id, e);
		}return entity;
	}

	public void delete(Long id) throws ServiceException{
		try {
			genericDao.delete(id);
		} catch (GenericException e) {
			throw new ServiceException("Error eliminando entity id: " + id, e);
		}
		
	}

	public T save(T entity) throws ServiceException{
		try {
			return genericDao.save(entity);
		} catch (DuplicatedException | GenericException de) {
//			relanzo la excpetion como una serviceException
//			que contine la exeption original
			throw new ServiceException("C101", de);
		}
	}

	public void update(T entity) throws ServiceException {
		try {
			genericDao.update(entity);
		} catch (GenericException | DuplicatedException e) {
			throw new ServiceException("Error actualizando " + entity, e);
		}
		
	}

	public List<T> findAll() throws ServiceException {
		try {
			return genericDao.findAll();
		} catch (GenericException e) {
			throw new ServiceException("Error consultando listado ", e);
		}
	}
}
