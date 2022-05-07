package ar.com.educacionit.servlets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.web.enums.ViewsKeysEnum;

@WebServlet("/GenerarArchivoErrorServlet")
public class GenerarArchivoErrorServlet extends BaseServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // recupero la collection de articulos fails de las seecion
        Collection<Articulos> articulos = (Collection<Articulos>) req.getSession().getAttribute(ViewsKeysEnum.ARTICULOS_FAILS.getName());
        
        //validaciones
        
        String archivo = req.getParameter(ViewsKeysEnum.FORMATO.getName());
        String fileName = "listado-productos-error";
        
        //C://desarrollo/educacionit/bootcamp
        String path = File.separator + "desarrollo" + File.separator + archivo + "." + archivo;
        
        File outputFile = new File(path);
        
        if(!outputFile.exists()) {
            Files.createFile(outputFile.toPath());
        }
        
        FileWriter fileWriter = new FileWriter(outputFile);
        
        for(Articulos articulo: articulos) {
            String line = this.lineFormat(articulo);
            fileWriter.write(line);
        }
    }

    private String lineFormat(Articulos articulo) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(articulo.getTitulo()).append(";");
        buffer.append(articulo.getCodigo()).append(";");
        buffer.append(articulo.getPrecio()).append(";");
        buffer.append(articulo.getStock()).append(";");
        buffer.append(articulo.getCategoriasId()).append(";");
        buffer.append(articulo.getMarcasId());
        return buffer.toString();
    }
}
