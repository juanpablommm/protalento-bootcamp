package ar.com.educacionit.Files;

import java.util.List;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.files.CSVImpl;
import ar.com.educacionit.files.IGenerarArchicoErrores;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;

public class PruebaCSV {

    public static void main(String[] args) throws ServiceException, GenericException {
        IGenerarArchicoErrores archivo = new CSVImpl();
        ArticulosServices services = new ArticulosServicesImpl();
        List<Articulos> articulos = services.findAll();
        archivo.makeFile("ultimoserrores", articulos);
    }
}
