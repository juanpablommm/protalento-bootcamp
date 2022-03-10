package com.educacionit.main;

import java.util.ArrayList;
import java.util.Collection;

import com.educacionit.exeptions.ParseException;
import com.educacionit.files.IParser;
import com.educacionit.files.PDFWrite;
import com.educacionit.files.XLSXFileParser;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Marcas;
import ar.com.educacionit.domain.Socios;

public class Main {

    public static void main(String[] args) throws ParseException {

        
//        creatte a collections of Marcas for create pdf document of it
        Collection<Marcas> collectionMarcas = new ArrayList<Marcas>();
        collectionMarcas.add(new Marcas("LG", "MASW23", 1l));
        collectionMarcas.add(new Marcas("SAMSUNG", "MAMOA13", 1l));
        collectionMarcas.add(new Marcas("APPLE", "PAOS124", 1l));
        collectionMarcas.add(new Marcas("MOTOROLA", "MASW2QQ3", 2l));
        
        Collection<Socios> collectionSocios = new ArrayList<Socios>();
        collectionSocios.add(new Socios("Juan", "pablo", "juanpablo@gamil.com",
                "avenida simepre viva 34", 1l));
        collectionSocios.add(new Socios("Jhony", "el bravo", "jhonbravo@gamil.com",
                "avenida simepre viva 34", 2l));
        collectionSocios.add(new Socios("Juancho", "Roiz", "juanchoRoiz@gamil.com",
                "Calle 13", 3l));
        
        IParser<Collection<Articulos>> xlsxfile = new XLSXFileParser("./src/main/java/com/educacionit/files/FileArticulos.xlsx");
        try {
            Collection<Articulos> articulos = xlsxfile.parse();

            // create object of type pdfWrite and execute method for write pdf with
            // the Articulos of the Collection
            PDFWrite pdfWrite = new PDFWrite("./src/main/java/com/educacionit/files/FileArticulos.pdf");//url de done se guardara
//            el pdf y el nombre que tendra
            pdfWrite.writePDF(articulos);
            
            pdfWrite = new PDFWrite("./src/main/java/com/educacionit/files/FileMarcas.pdf");
            pdfWrite.writePDF(collectionMarcas);
            
            pdfWrite = new PDFWrite("./src/main/java/com/educacionit/files/FileSocios.pdf");
            pdfWrite.writePDF(collectionSocios);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
