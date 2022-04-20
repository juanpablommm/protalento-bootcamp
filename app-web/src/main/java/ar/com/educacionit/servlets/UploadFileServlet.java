package ar.com.educacionit.servlets;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.files.parser.CSVFileParser;
import ar.com.educacionit.files.parser.IParser;
import ar.com.educacionit.files.parser.ParseException;
import ar.com.educacionit.files.parser.XLSXFileParser;
import ar.com.educacionit.web.enums.ViewJSPEnums;
import ar.com.educacionit.web.enums.ViewsKeysEnum;

@SuppressWarnings("serial")
@WebServlet("/controllers/UploadFileServlet")
@MultipartConfig // cuando tabajamos con carga de archivos binarios dese el ftron
//debemos implemntar esta anotacion para poder procesarlo
public class UploadFileServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        esta interfaces no permitia capturar una rchivo que venga cargado
        Part part = req.getPart(ViewsKeysEnum.UPLOAD_FILE.getName());

        ViewJSPEnums target = ViewJSPEnums.UPLOAD_PREVIEW;
//        comparmos que el archivo que cargen tenga una longitud mayor a cero
        if (part.getSize() > 0) {
            // de esta manera reperamos de manera segura el nombre del archivo que cargen
            String file = Paths.get(part.getSubmittedFileName()).getFileName().toString();

            String extension = this.getExtension(file);

            IParser<Collection<Articulos>> parse;

            switch (extension) {
            case "csv":
                parse = new CSVFileParser(part);
                break;

            case "xlsx":
                parse = new XLSXFileParser(extension);
                break;
            default:
                parse = null;
                break;
            }
            if (parse != null) {
                try {
                    Collection<Articulos> articulos = parse.parse();
                    super.addAtribute(req, ViewsKeysEnum.UPLOAD_PREVIEW_KEY, articulos);
                } catch (ParseException e) {
//                    req.setAttribute(ViewsKeysEnum.ERROR_GENERAL.getName(), e.getMessage());
                    super.addAtribute(req, ViewsKeysEnum.ERROR_GENERAL, e.getMessage());
                    target = ViewJSPEnums.UPLOAD;
                }
            } else {
                super.addAtribute(req, ViewsKeysEnum.ERROR_GENERAL, "Error de formato");
                target = ViewJSPEnums.UPLOAD;
            }
            // todos los servlet podran usar el metodo del parde redirect
            super.redirect(target, req, resp);
        }

    }

    private String getExtension(String fileName) {
        String extension = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
        return extension;
    }
}
