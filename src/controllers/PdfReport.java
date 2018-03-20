package controllers;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PdfReport {

    /**
     * Path to the resulting PDF file.
     */
    public static final String RESULT
            = "sueldos/hello.pdf";

    /**
     * Creates a PDF file: hello.pdf
     *
     * @param args no arguments needed
     */
    public static void main(String[] args)
            throws DocumentException, IOException, SQLException {
        ResultSet rs = null;
        new PdfReport().createPdf(RESULT, RESULT,RESULT, rs);
    }

    /**
     * Creates a PDF document.
     *
     * @param filename the path to the new PDF document
     * @throws DocumentException
     * @throws IOException
     */
    public void createPdf(String filename, String datos,String monto, ResultSet rs)
            throws DocumentException, IOException, SQLException {

        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream("sueldos/" + filename));

        document.open();

        Paragraph titulo = new Paragraph("Factura Sueldo - Mensajeria Rivera", FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.CENTER_BASELINE, BaseColor.BLACK));
        titulo.setAlignment(Element.ALIGN_CENTER);
        document.add(titulo);

        LineSeparator ls = new LineSeparator();
        document.add(new Chunk(ls));

        document.add(new Paragraph(datos, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.PLAIN, BaseColor.BLACK)));
        
        document.add(new Chunk(ls));
        
        document.add(new Paragraph("DETALLES SUELDO", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.PLAIN, BaseColor.BLACK)));
        
        document.add(Chunk.NEWLINE);
        
        PdfPTable table = new PdfPTable(4);
        
        table.addCell("CLIENTE");
        table.addCell("CANTIDAD");
        table.addCell("MONTO UNITARIO");
        table.addCell("SubTotal");
        
        while (rs.next()) {
            table.addCell(rs.getString("nom_cliente"));
            table.addCell(rs.getString("cantidad"));
            table.addCell(rs.getString("monto_unitario"));
            float cant = Float.parseFloat(rs.getString("cantidad"));
            float montoUnitario = Float.parseFloat(rs.getString("monto_unitario"));
            float subtotal = cant * montoUnitario;
            table.addCell(String.valueOf(subtotal));
        }
        
        document.add(table);
        document.add(Chunk.NEWLINE);
        
        PdfPTable table2 = new PdfPTable(2);
        table2.setWidths(new int []{3,1});
        table2.addCell("TOTAL");
        table2.addCell(monto);
        
        document.add(table2);
        document.close();
    }
}
