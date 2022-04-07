package ar.com.educacionit.servlets;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.files.parser.CSVFileParser;
import ar.com.educacionit.files.parser.IParser;
import ar.com.educacionit.files.parser.XLSXFileParser;
import ar.com.educacionit.web.enums.ViewsKeysEnum;

@SuppressWarnings("serial")
@WebServlet("/UploadFileServlet")
public class UploadFileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        esta interfaces no permitia capturar una rchivo que venga cargado
        Part part = req.getPart(ViewsKeysEnum.UPLOAD_FILE.getName());

//        comparmos que el archivo que cargen tenga una longitud mayor a cero
        if (part.getSize() > 0) {
            // de esta manera reperamos de manera segura el nombre del archivo que cargen
            String file = Paths.get(part.getSubmittedFileName()).getFileName().toString();

            String extension = this.getExtension(file);

            IParser<Articulos> parse = null;

            switch (extension) {
            case "csv":
                parse = new CSVFileParser((File) part);
                break;

            case "xlsx":
                parse = new XLSXFileParser(extension);
                break;
            default:
                parse = null;
                break;
            }
            if(parse == null) {
                req.setAttribute(ViewsKeysEnum.ERROR_GENERAL.getName(), "Error de formato");
            }
        }

    }

    private String getExtension(String fileName) {
        String extension = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
        return extension;
    }
}
