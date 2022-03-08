package com.educacionit.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Iterator;

import com.educacionit.exeptions.ParseException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ar.com.educacionit.domain.Articulos;

public class PDFWrite extends BaseFile {

    public PDFWrite(String path) {
        super(path);
    }

    public void writePDF(Collection<Articulos> collection) throws ParseException {

        if (new File(super.filePath).isFile()) {
            throw new ParseException("Error!! ya exite un archivo " + super.filePath);
        } else {

            Document document = new Document();// create document
            try {
                PdfWriter.getInstance(document, new FileOutputStream(super.filePath));// make PDFWrite for write
                document.open();// open the document

                Paragraph tittle = new Paragraph("Articulos Registrados en el Sistemas", FontFactory.getFont("arial", // fuente
                        14, // tamaño
                        Font.UNDEFINED, // estilo
                        BaseColor.RED)); // color));
                tittle.setAlignment(Element.ALIGN_CENTER);// position of title
                document.add(tittle);

                PdfPTable table = new PdfPTable(7);// create table, i send by parameter the amount
                table.setWidthPercentage(110);// width of table

//             create cells
                table.addCell(this.makeCell("TITULO", 10F, 6.5F));
                table.addCell(this.makeCell("CODIGO", 10F, 6.5F));
                table.addCell(this.makeCell("FECHA", 10F, 6.5F));
                table.addCell(this.makeCell("PRECIO", 10F, 6.5F));
                table.addCell(this.makeCell("STOCK", 10F, 6.5F));
                table.addCell(this.makeCell("MARCAS_ID", 10F, 6.5F));
                table.addCell(this.makeCell("CATEGORIAS_ID", 10F, 6.5F));

                Iterator<Articulos> iterator = collection.iterator();// create iterator
                while (iterator.hasNext()) {
                    Articulos articulos = iterator.next();
                    table.addCell(this.makeCell(articulos.getTitulo(), 10F, 6.5F));
                    table.addCell(this.makeCell(articulos.getCodigo(), 10F, 6.5F));
                    table.addCell(this.makeCell(articulos.getFechaCreacion().toString(), 10F, 6.5F));
                    table.addCell(this.makeCell(articulos.getPrecio().toString(), 10F, 6.5F));
                    table.addCell(this.makeCell(articulos.getStock().toString(), 10F, 6.5F));
                    table.addCell(this.makeCell(articulos.getMarcaId().toString(), 10F, 6.5F));
                    table.addCell(this.makeCell(articulos.getCategoriaId().toString(), 10F, 6.5F));
                }
                document.add(table);// send the table a document
                System.out.println("Se ha creado el registro");
            } catch (FileNotFoundException | DocumentException e) {
                throw new ParseException("Error, no se pude crear el pdf, revise nombre del archivo y extension .pdf");
            } finally {
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
