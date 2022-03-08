package com.educacionit.main;

import java.util.Collection;

import com.educacionit.exeptions.ParseException;
import com.educacionit.files.IParser;
import com.educacionit.files.PDFWrite;
import com.educacionit.files.XLSXFileParser;

import ar.com.educacionit.domain.Articulos;

public class Main {

    public static void main(String[] args) throws ParseException {

        
        IParser<Collection<Articulos>> xlsxfile = new XLSXFileParser("./src/main/java/com/educacionit/files/FileArticulos.xlsx");
        try {
            Collection<Articulos> articulos = xlsxfile.parse();

            // create object of type pdfWrite and execute method for write pdf with
            // the Articulos of the Collection
            PDFWrite pdfWrite = new PDFWrite("./src/main/java/com/educacionit/files/FileArticulos.pdf");//url de done se guardara
//            el pdf y el nombre que tendra
            pdfWrite.writePDF(articulos);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
