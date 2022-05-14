package ar.com.educacionit.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.exceptions.GenericException;

public class CSVImpl implements IGenerarArchicoErrores {

    @Override
    public void downloadFile(HttpServletResponse response,  List<? extends Entity> registros) throws GenericException {
        if(registros == null || registros.isEmpty()) {
            throw new GenericException("Error no se pude generar el archivo, no ahy datos...");
        }else {
            try {
               //llamo al metodo envedido en la interfaces para setear el mime e indicar la descarga
                IGenerarArchicoErrores.setHeaderForDownload(response, "text/csv", "csv");
                PrintWriter writer = response.getWriter();
                for (int i = 0; i < registros.size(); i++) {
                    String lineWrite = "";
                    Field[] fields = registros.get(i).getClass().getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if(i == 0) {
                            writer.write(field.getName() + ((field != fields[fields.length - 1])? ";": "\n"));
                        }
                        lineWrite += field.get(registros.get(i)) + ";";
                    }writer.println(lineWrite);
                }writer.close();
            } catch (IOException | IllegalArgumentException | IllegalAccessException e) {
                throw new GenericException("Error, al generar el archivo...");
            }
        }
    }
    
}
