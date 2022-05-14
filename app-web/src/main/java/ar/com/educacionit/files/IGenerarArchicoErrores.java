package ar.com.educacionit.files;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.exceptions.GenericException;

public interface IGenerarArchicoErrores {
    
    public abstract void downloadFile(HttpServletResponse response, List<? extends Entity> registros) throws GenericException;
    
    public static void setHeaderForDownload(HttpServletResponse response, String typeMime, String type) {
        response.setContentType(typeMime);//seteo el tipo mime
        response.setHeader("Content-Disposition", "attachment; filename=\"listadoErrores."+ type + "\"");
        //*estos headers nos permiten que no se guarde el archivo en el cache y espire de manera inmediata
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", -1);
    }
    
}
