package ar.com.educacionit.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator;

import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.exceptions.GenericException;

public class PDFImpl implements IGenerarArchicoErrores{

    @Override
    public void downloadFile(HttpServletResponse response, List<? extends Entity> registros) throws GenericException {
        if(registros == null || registros.isEmpty()) {
            throw new GenericException("Error no se pude generar el archivo, no ahy datos...");
        }else {
            IGenerarArchicoErrores.setHeaderForDownload(response, "application/pdf", "pdf");
            Document document = new Document();
            OutputStream outputStream = null;
            try {
                outputStream = response.getOutputStream();
                PdfWriter.getInstance(document, outputStream);
                document.open();
                PdfPTable pdfPTable = new PdfPTable(registros.get(0).getClass().getDeclaredFields().length);
//                agrego los cabeceros del documento
                for(Field field: registros.get(0).getClass().getDeclaredFields()) {
                    pdfPTable.addCell(this.makeCell(field.getName(), 10f, 6.5f));
                }
                //lleno los registros
                for(Entity entity: registros) {
                    for(Field field: entity.getClass().getDeclaredFields()) {
                        field.setAccessible(true);
                        pdfPTable.addCell(this.makeCell((field.get(entity) == null)? "null": field.get(entity).toString(), 10f, 6.5f));
                    }
                }
                document.add(pdfPTable);
            } catch (IOException | DocumentException | IllegalArgumentException | IllegalAccessException  e1) {
                e1.printStackTrace();
            }finally {
                document.close();
            }
        }
    }
    
    // Method for make personalized cell
    private PdfPCell makeCell(String titulo, Float tamanoCell, Float tamanoLetra) {
        Paragraph paragraph = new Paragraph(titulo);
        paragraph.getFont().setSize(tamanoLetra);
        PdfPCell cell = new PdfPCell(paragraph);
        cell.setMinimumHeight(tamanoCell);
        return cell;
    }
}
