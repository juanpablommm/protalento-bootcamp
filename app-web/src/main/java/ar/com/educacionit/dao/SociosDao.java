package ar.com.educacionit.dao;

import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.exceptions.GenericException;

public interface SociosDao extends GenericDao<Socios> {

    Socios getSociosByUserId(Long id) throws GenericException;

}
