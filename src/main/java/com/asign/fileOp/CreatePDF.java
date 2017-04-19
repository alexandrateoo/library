package com.asign.fileOp;

import com.asign.web.jaxb.BookJaxb;
import com.asign.web.models.Book;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreatePDF {

    private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private final String NAME = "report";


    public CreatePDF() {
        BookJaxb bookJaxb = new BookJaxb();
        List<Book> books = new ArrayList<Book>();
        for (Book b : bookJaxb.unmarshallList()) {
            if (b.getQuantity() == 0)
                books.add(b);
        }
        if (!books.isEmpty())
            createPDFReport(NAME, books);

    }

    /**
     * @param books
     * @param file
     */
    public static Document createPDFReport(String file, List<Book> books) {

        Document document = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        file = file + simpleDateFormat.format(new Date()) + ".pdf";

        List<String> booksOStock = new ArrayList<String>();
        for (Book b : books) {
            booksOStock.add(b.getTitle() + " " + b.getAuthor());
        }

        try {
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            addMetaData(document);
            addTitlePage(document);
            createTable(document, booksOStock);

            document.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;

    }

    private static void addMetaData(Document document) {
        document.addTitle("Generate PDF report");
        document.addSubject("Generate PDF report");
        document.addAuthor("BookStore");
        document.addCreator("Bookstore");
    }

    private static void addTitlePage(Document document)
            throws DocumentException {

        Paragraph preface = new Paragraph();
        creteEmptyLine(preface, 1);
        preface.add(new Paragraph("PDF Report", TIME_ROMAN));

        creteEmptyLine(preface, 1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        preface.add(new Paragraph("Report created on "
                + simpleDateFormat.format(new Date()), TIME_ROMAN_SMALL));
        document.add(preface);

    }

    private static void creteEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private static void createTable(Document document, List<String> booksOStock) throws DocumentException {

        Paragraph paragraph = new Paragraph();
        creteEmptyLine(paragraph, 2);
        document.add(paragraph);
        PdfPTable table = new PdfPTable(2);

        PdfPCell c1 = new PdfPCell(new Phrase("Id"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Book"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        int i = 1;
        for (String book : booksOStock) {

            table.setWidthPercentage(100);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(Integer.toString(i));
            table.addCell(book.toString());
        }
        booksOStock.clear();
        document.add(table);

    }

}
