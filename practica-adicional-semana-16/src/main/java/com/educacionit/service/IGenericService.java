package com.educacionit.service;

import java.util.List;

import com.educacionit.domain.Carrousel;
import com.educacionit.exception.ServicesException;

public interface IGenericService {

    public abstract void insert(Carrousel carrousel) throws ServicesException;

    public abstract List<Carrousel> selectFindAll() throws ServicesException;

    public abstract Carrousel selectByID(Long id) throws ServicesException;

    public abstract void deletet(Long id) throws ServicesException;

    public abstract void update(Long id, Carrousel carrousel) throws ServicesException;
}
