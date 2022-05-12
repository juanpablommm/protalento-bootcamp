package ar.com.educacionit.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.List;

import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.exceptions.GenericException;

public class CSVImpl implements IGenerarArchicoErrores {

    @Override
    public File makeFile(String path, List<? extends Entity> registros) throws GenericException {
        File file = new File(path + ".csv");
        if (!file.exists() && (registros != null && !registros.isEmpty())) {
            try {
                Files.createFile(file.toPath());
                FileWriter fileWriter = new FileWriter(file);
                for (int i = 0; i < registros.size(); i++) {
                    String lineWrite = "";
                    Field[] fields = registros.get(i).getClass().getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if(i == 0) {
                            fileWriter.write(field.getName() + ";");
                        }
                        lineWrite += field.get(registros.get(i)) + ";";
                    }fileWriter.write("\n"+ lineWrite);
                }
                return file;
            } catch (IOException | IllegalArgumentException | IllegalAccessException e) {
                throw new GenericException("Error!! no se ha podido crear el archivo \"" + path + "\"");
            }
        } else {
            return null;
        }
    }
}
