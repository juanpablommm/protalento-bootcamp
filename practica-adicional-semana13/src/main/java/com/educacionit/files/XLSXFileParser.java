package com.educacionit.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.educacionit.exeptions.ParseException;

import ar.com.educacionit.domain.Articulos;

public class XLSXFileParser extends BaseFile implements IParser<Collection<Articulos>> {

    public XLSXFileParser(String path) {
        super(path);
    }

    
    // implementar el metodo generico, PERO, dandole un tipo concreto
    public Collection<Articulos> parse() throws ParseException {
        
        Collection<Articulos> collectionArticulos = new ArrayList<Articulos>(); 
        File file = new File(super.getFilePath());//creamos el puntero asi el documento
        try (
                InputStream inputStream = new FileInputStream(file);
                Workbook workbook = new XSSFWorkbook(inputStream); //El Workbook representa el dpcumento entero
             ) {

            for(int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                
                Iterator<Row> iteratorRow = sheet.iterator();//obtengo las filas de la hoja actual
                
                boolean primerFila = true;
                while (iteratorRow.hasNext()) {
                    Row row = iteratorRow.next();
                    if (primerFila) {
                        primerFila = false;
                        continue;
                    }
                    Articulos articulos = new Articulos();
                    
                    Iterator<Cell> iteratorCell = row.cellIterator();// obtengo mis celdas por cada row
                    
                    while (iteratorCell.hasNext()) {
                        fromcellArticulo(articulos, iteratorCell.next());
                    }
                    collectionArticulos.add(articulos);
                }
            }
        }catch (IOException e) {
            throw new ParseException("No se ha podido parsear el archivo: " + getFilePath(), e);
        }return collectionArticulos;
    }

    
    //recorrer las celdad de una fila y por cada celda mira que atributo corresponde
//    al articulo
    private void fromcellArticulo(Articulos articulos, Cell celda) {
        switch (celda.getColumnIndex()) {
        case 0:
            articulos.setTitulo(celda.getStringCellValue());
            break;
        case 1:
            articulos.setCodigo(celda.getStringCellValue());
            break;
        case 2:
            articulos.setPrecio(celda.getNumericCellValue());
            break;
        case 3:
            articulos.setStock((long) celda.getNumericCellValue());;
            break;
        case 4:
            articulos.setMarcasId((long) celda.getNumericCellValue());
            break;
        case 5:
            articulos.setCategoriasId((long) celda.getNumericCellValue());
            break;
        default:
            break;
        }
        articulos.setFechaCreacion(new Date());
    }
}
