package test.files;

import java.util.Collection;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;
import files.IParser;
import files.ParseException;
import files.XLSXFileParser;

public class TestFieles2 {

    public static void main(String[] args) throws ParseException {
        
        IParser<Collection<Articulos>> xlsxfile = new XLSXFileParser("./src/main/java/test/files/FileArticulos.xlsx");
        
        Collection<Articulos> articulos =  xlsxfile.parse();
       
//        1. creo el service de articulos
        ArticulosServices articulosServicios = new ArticulosServicesImpl();
        
        
        for(Articulos a: articulos) {
            try {
                articulosServicios.save(a);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
//        2. ejecuto el metodo save
        
    }
    
}
