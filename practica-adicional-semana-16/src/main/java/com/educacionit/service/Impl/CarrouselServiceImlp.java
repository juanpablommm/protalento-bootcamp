package com.educacionit.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.educacionit.dao.ICarrouselDao;
import com.educacionit.dao.Impl.CarrouselDaoImplPostgret;
import com.educacionit.domain.Carrousel;
import com.educacionit.exception.GenericException;
import com.educacionit.exception.ServicesException;
import com.educacionit.service.ICarrouselService;

public class CarrouselServiceImlp implements ICarrouselService{

    private ICarrouselDao dao;
    
    public CarrouselServiceImlp() {
        this.dao = new CarrouselDaoImplPostgret();
    }
    @Override
    public void insert(Carrousel carrousel) throws ServicesException {
        try {
            this.dao.insert(carrousel);
        } catch (GenericException e) {
           throw new ServicesException("Error!! no es posible resgistrar a " + carrousel);
        }
    }

    @Override
    public List<Carrousel> selectFindAll() throws ServicesException {
        List<Carrousel> lCarrousels = new ArrayList<>();
        try {
            lCarrousels = this.dao.selectFindAll();
        } catch (GenericException e) {
           throw new ServicesException("Error!! no es posible consultar los registros ");
        }return lCarrousels;
    }

    @Override
    public Carrousel selectByID(Long id) throws ServicesException {
        Carrousel carrousel = null;
        try {
            carrousel = this.dao.selectByID(id);
        } catch (GenericException e) {
           throw new ServicesException("Error!! no es posible consultar el registro ");
        }
        return carrousel;
    }

    @Override
    public void deletet(Long id) throws ServicesException {
        try {
            this.dao.deletet(id);
        } catch (GenericException e) {
           throw new ServicesException("Error!! no es posible borrar el registro");
        }
    }

    @Override
    public void update(Long id, Carrousel carrousel) throws ServicesException {
        try {
            this.dao.update(id, carrousel);
        } catch (GenericException e) {
            throw new ServicesException("Error!! no es psible actualizar el registro ");
        }
    }

}
