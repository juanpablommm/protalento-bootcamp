package ar.com.educacionit.files;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.exceptions.GenericException;

public class XLSXImpl implements IGenerarArchicoErrores {

    @Override
    public void downloadFile(HttpServletResponse response, List<? extends Entity> registros) throws GenericException {
        if (registros == null || registros.isEmpty()) {
            throw new GenericException("Error no se pude generar el archivo, no ahy datos...");
        } else {
            IGenerarArchicoErrores.setHeaderForDownload(response, "application/vnd.ms-excel", "xlsx");
            Workbook workbook = new XSSFWorkbook();/* Crear el libro */
            // creamos la hoja y la nombreamos
            Sheet pagina = workbook.createSheet("Archivos no guardados");
            Row row = pagina.createRow(0);
            int cell = 0;
            // primero lleno los cabeceros
            for (Field field : registros.get(0).getClass().getDeclaredFields()) {
                row.createCell(cell++).setCellValue(field.getName());
            }
            // recorremos la lista para comenzar a llenar
            for (int i = 0; i < registros.size(); i++) {
                row = pagina.createRow(i + 1);
                cell = 0;
                for (Field field : registros.get(i).getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    try {
                        row.createCell(cell++).setCellValue((field.get(registros.get(i)) == null) ? "null" : field.get(registros.get(i)).toString());
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                OutputStream fileOutputStream = response.getOutputStream();
                workbook.write(fileOutputStream);
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
