package com.educacionit.files;

import java.util.Collection;


import ar.com.educacionit.domain.Articulos;
import com.educacionit.exeptions.ParseException;
public class TestFieles {

    public static void main(String[] args) {
        
        IParser<Collection<Articulos>> xlsxfile = new XLSXFileParser("./src/main/java/com/educacionit/files/FileArticulos.xlsx");
        try {
             Collection<Articulos> articulos =  xlsxfile.parse();

             //create object of type pdfWrite and execute method for write pdf with
             //the Articulos of the Collection
             PDFWrite pdfWrite = new PDFWrite("./src/main/java/com/educacionit/files/FileArticulos.pdf");
             pdfWrite.writePDF(articulos);
             
           for(Articulos articulos2: articulos) {
               System.out.println(articulos2);
           }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
       
    }
    
}
