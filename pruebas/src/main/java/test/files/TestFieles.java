package test.files;

import java.util.Collection;

import ar.com.educacionit.domain.Articulos;
import files.IParser;
import files.ParseException;
import files.XLSXFileParser;

public class TestFieles {

    public static void main(String[] args) {
        
        IParser<Collection<Articulos>> xlsxfile = new XLSXFileParser("./src/main/java/com/educacionit/files/FileArticulos.xlsx");
        try {
             Collection<Articulos> articulos =  xlsxfile.parse();
            System.out.println(articulos);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
}
