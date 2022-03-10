package com.educacionit.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;

import com.educacionit.exeptions.ParseException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfWriter;

import ar.com.educacionit.domain.Entity;

public class PDFWrite extends BaseFile {

    public PDFWrite(String path) {
        super(path);
    }

    public void writePDF(Collection<? extends Entity> collection) throws ParseException {

        if (new File(super.filePath).isFile()) {
            throw new ParseException("Error, ya existe un PDF con el mismo nombre en la misma ruta");
        } else {
            Document document = new Document();// create document
            try {

                PdfWriter.getInstance(document, new FileOutputStream(super.filePath));
                document.open();
                String[] titles = this.getTitles(collection);
                Iterator<? extends Entity> iterator = collection.iterator();
                PdfPTable table = new PdfPTable(titles.length);
                for (String title : titles) {
                    table.addCell(this.makeCell(title, 10f, 6.5f));
                }
                while (iterator.hasNext()) {
                    Entity entity = iterator.next();
                    this.addRecord(entity, titles, table);

                }
                document.add(table);
                System.out.println("Docuemto Creado con Exito");
            } catch (FileNotFoundException | DocumentException e) {
                throw new ParseException("Error al create PDF " + e);
            } finally {
                document.close();
            }
        }
    }

    // Method for get titles
    private String[] getTitles(Collection<? extends Entity> collection) {
        String nombres = "";
        Iterator<? extends Entity> iterator = collection.iterator();
        if (iterator.hasNext()) {
            Field[] fields = iterator.next().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.getName().equals("id")) {
                    nombres += field.getName() + ",";
                }
            }
        }
        return nombres.split(",");
    }

    private void addRecord(Entity entity, String[] titles, PdfPTable table) {
        Field[] fields = entity.getClass().getDeclaredFields();// get Fields
        for (Field field : fields) {
            for (String title : titles) {
                if (field.getName().equals(title)) {
                    field.setAccessible(true);// provide access the fields
                    try {
                        // add each cell with the date of each field and it is null
//                        add a String
                        table.addCell(this.makeCell((field.get(entity) == null) ? "null" : field.get(entity).toString(), 10f, 6.5f));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
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
