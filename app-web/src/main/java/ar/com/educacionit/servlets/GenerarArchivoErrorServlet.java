package ar.com.educacionit.servlets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.functors.ForClosure;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.files.CSVImpl;
import ar.com.educacionit.web.enums.ViewJSPEnums;
import ar.com.educacionit.web.enums.ViewsKeysEnum;

@SuppressWarnings("serial")
@WebServlet("/controllers/GenerarArchivoErrorServlet")
public class GenerarArchivoErrorServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // recupero la collection de articulos fails de las seecion
        @SuppressWarnings("unchecked")
        Collection<Articulos> articulos = (Collection<Articulos>) req.getSession().getAttribute(ViewsKeysEnum.ARTICULOS_FAILS.getName());

        if (articulos != null || !articulos.isEmpty()) {

            // validaciones
            String format = req.getParameter(ViewsKeysEnum.FORMATO.getName());
            String fileName = "C:\\Users\\Protalento\\Bootcamp\\Listado-Errores";

            List<Articulos> list = new ArrayList<Articulos>();
            Iterator<Articulos> i = articulos.iterator();
            while (i.hasNext()) {
                list.add(i.next());
            }
            /*
             * lo siguiente seria la logica para que el navegador sepa que tipo de mime es y poder descargarlo
             */
            try {
                this.descargar(fileName, format, new CSVImpl().makeFile(fileName, list), resp);
            } catch (IOException | GenericException e) {
                e.printStackTrace();
            }
        }

        super.addAtribute(req, ViewsKeysEnum.ERROR_GENERAL, "Sin datos...");
        super.redirect(ViewJSPEnums.RESULT_PREVIEW, req, resp);
    }

    private void descargar(String fileName, String format, File outputFile, HttpServletResponse resp) throws IOException {
        // especificamos el tipo mime al navegador
        resp.setContentType("text/csv");
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + outputFile + "\"");

        /*
         * estos headers nos permiten que no se guarde el archivo en el cache y espire de manera inmediata
         */
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-store");
        resp.setHeader("Cache-Control", "no-store");
        resp.setDateHeader("Expires", -1);
        OutputStream outputStream = resp.getOutputStream();
        byte[] bytes = Files.readAllBytes(outputFile.toPath());
        outputStream.flush();
        outputStream.close();
    }
}
