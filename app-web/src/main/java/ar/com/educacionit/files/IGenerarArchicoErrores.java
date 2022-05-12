package ar.com.educacionit.files;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.exceptions.GenericException;

public interface IGenerarArchicoErrores {

    public abstract File makeFile(String path, List<? extends Entity> registros) throws GenericException;
}
