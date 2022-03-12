package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.educacionit.domain.Articulos;

public class XLSXFileParser extends BaseFile implements IParser<Collection<Articulos>> {

    public XLSXFileParser(String path) {
        super(path);
    }

    
 // libreria poi de apache
    
    // implementar el metodo generico, PERO, dandole un tipo concreto
    public Collection<Articulos> parse() throws ParseException {
        
        Collection<Articulos> collectionArticulos = new ArrayList<Articulos>(); 

        File file = new File(super.getFilePath());//creamos el puntero asi el documento
        try (
                InputStream inputStream = new FileInputStream(file);
                Workbook workbook = new XSSFWorkbook(inputStream); //El Workbook representa el dpcumento entero
             ) {

            Sheet sheet = workbook.getSheetAt(0);//representa una hoja
            Iterator<Row> filas = sheet.iterator();//colletion para guardad cada fila 
            boolean primerFila = true; // TITULO CODIFO PRECIO STOK MARCASID CATEGORIASID
                       
            while (filas.hasNext()) {
                Row row = filas.next();
                if (primerFila) {
                    primerFila = false;
                    continue;
                }
                Iterator<Cell> celdas = row.cellIterator();// MONITOR MONI000 24500 2 1 1

                Articulos articulos = new Articulos();
                while (celdas.hasNext()) {
                    Cell celda = celdas.next();
                    this.fromcellArticulo(articulos, celda);

                }
                collectionArticulos.add(articulos);
            }

        } catch (IOException e) {
            throw new ParseException("No se ha podido parsear el archivo: " + getFilePath(), e);
        }
        return collectionArticulos;
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
