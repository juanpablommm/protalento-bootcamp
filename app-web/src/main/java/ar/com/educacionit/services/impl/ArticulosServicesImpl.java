package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.dao.MarcasDao;
import ar.com.educacionit.dao.impl.ArticulosDaoImpl;
import ar.com.educacionit.dao.impl.CategoriaDaoImpl;
import ar.com.educacionit.dao.impl.MarcasDaoImpl;
import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;

public class ArticulosServicesImpl extends AbstractBaseService<Articulos> implements ArticulosServices {

    
    //usar otros daos
    private MarcasDao marcas;
    private CategoriaDao categoria;
    public ArticulosServicesImpl() {
        super(new ArticulosDaoImpl());
        this.categoria = new CategoriaDaoImpl();
        this.marcas = new MarcasDaoImpl();
    }
    
    @Override
    public Articulos getOne(Long id) throws ServiceException {
        try {
            Articulos articulo = super.genericDao.getOne(id);
            articulo.setMarcas(this.marcas.getOne(articulo.getMarcasId()));
            articulo.setCategoria(this.categoria.getOne(articulo.getCategoriasId()));
            return articulo;
        } catch (GenericException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
