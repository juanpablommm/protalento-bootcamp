package com.educacionit.dao;

import java.util.List;

import com.educacionit.domain.Carrousel;
import com.educacionit.exception.GenericException;

public interface ICarrouselDao {

    public abstract void insert(Carrousel carrousel) throws GenericException;
    
    public abstract List<Carrousel> selectFindAll() throws GenericException;
    
    public abstract Carrousel selectByID(Long id) throws GenericException;
    
    public abstract void deletet(Long id) throws GenericException;
    
    public abstract void update(Long id, Carrousel carrousel) throws GenericException;
    
//    public abstract List<String> selectWhereImages() throws GenericException;
}
