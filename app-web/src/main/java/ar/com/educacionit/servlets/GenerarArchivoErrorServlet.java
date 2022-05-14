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
import ar.com.educacionit.files.IGenerarArchicoErrores;
import ar.com.educacionit.files.PDFImpl;
import ar.com.educacionit.files.XLSXImpl;
import ar.com.educacionit.web.enums.ViewJSPEnums;
import ar.com.educacionit.web.enums.ViewsKeysEnum;

@SuppressWarnings("serial")
@WebServlet("/controllers/GenerarArchivoErrorServlet")
public class GenerarArchivoErrorServlet extends BaseServlet {

    @SuppressWarnings("null")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // recupero la collection de articulos fails de las seecion
        @SuppressWarnings("unchecked")
        Collection<Articulos> articulos = (Collection<Articulos>) req.getSession().getAttribute(ViewsKeysEnum.ARTICULOS_FAILS.getName());

        IGenerarArchicoErrores archicoErrores;
        switch (req.getParameter(ViewsKeysEnum.FORMATO.getName())) {
        case "csv":
            archicoErrores = new CSVImpl();
            break;
        case "xlsx":
            archicoErrores = new XLSXImpl();
            break;
        case "pdf":
            archicoErrores = new PDFImpl();
            break;
        default:
            archicoErrores = null;
            break;
        }
        
        if ((articulos != null && !articulos.isEmpty()) && archicoErrores != null) {
            try {
                archicoErrores.downloadFile(resp, (List<Articulos>) articulos);
            } catch (GenericException e) {
                super.addAtribute(req, ViewsKeysEnum.ERROR_GENERAL, e);
                super.redirect(ViewJSPEnums.RESULT_PREVIEW, req, resp);
            }
        } else {
            super.addAtribute(req, ViewsKeysEnum.ERROR_GENERAL, "Sin datos...");
            super.redirect(ViewJSPEnums.RESULT_PREVIEW, req, resp);
        }
    }
}
