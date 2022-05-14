package ar.com.educacionit.Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;

public class Generadorxlsx {

    public static void main(String[] args) throws ServiceException {
        ArticulosServices articulosServices = new ArticulosServicesImpl();
        List<Articulos> registros = articulosServices.findAll();

        File file = new File("prueba.xlsx");
        Workbook workbook = new XSSFWorkbook();/* Crear el libro */
        // creamos la hoja y la nombreamos
        Sheet pagina = workbook.createSheet("Archivos no guardados");
        
        Row row = pagina.createRow(0);
        int cell = 0;
        //primero lleno los cabeceros
        for(Field field: registros.get(0).getClass().getDeclaredFields()) {
            row.createCell(cell++).setCellValue(field.getName());
        }

        // recorremos la lista para comenzar a llenar
        for (int i = 0; i < registros.size(); i++) {
            row = pagina.createRow(i + 1);
            cell = 0;
            for (Field field: registros.get(i).getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    row.createCell(cell++).setCellValue((field.get(registros.get(i)) == null) ? "null" : field.get(registros.get(i)).toString());
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
