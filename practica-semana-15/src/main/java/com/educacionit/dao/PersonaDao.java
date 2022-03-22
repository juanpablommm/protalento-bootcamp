package com.educacionit.dao;

import java.util.List;

import com.educacionit.domain.Persona;
import com.educacionit.exceptions.GenericExceptions;

public interface PersonaDao {

    public void insert(Persona persona) throws GenericExceptions;
    
    public List<Persona> selectFrom() throws GenericExceptions;
    
    public Persona slect(Long id) throws GenericExceptions;
    
    public Persona delect(Long id) throws GenericExceptions;
}
