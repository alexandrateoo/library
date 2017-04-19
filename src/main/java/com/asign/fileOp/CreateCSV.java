package com.asign.fileOp;


import com.asign.web.jaxb.BookJaxb;
import com.asign.web.models.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alex on 4/11/2017.
 */
public class CreateCSV {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    //CSV file header
    private static String REPORT_INFO;
    private static final String FILE_HEADER = "title,author,isbn";
    private static FileWriter fileWriter;
    private final String NAME = "report";

    public CreateCSV() {
        BookJaxb bookJaxb = new BookJaxb();
        List<Book> books = new ArrayList<Book>();
        for (Book b : bookJaxb.unmarshallList()) {
            if (b.getQuantity() == 0)
                books.add(b);
        }
        if (!books.isEmpty())
            generateCSVReport(NAME, books);
    }

    public void generateCSVReport(String file, List<Book> booksOStock) {

        try {
            fileWriter = new FileWriter(file);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");

            REPORT_INFO = "Report created on " + simpleDateFormat.format(new Date());
            writeLine(file + simpleDateFormat.format(new Date()) + ".csv", booksOStock);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void writeLine(String fileName, List<Book> books) {

        try {

            fileWriter = new FileWriter(fileName);
            fileWriter.append(REPORT_INFO);
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Book book : books) {

                fileWriter.append(String.valueOf(book.getTitle()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(book.getAuthor());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(book.getISBN());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {

            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();

        } finally {
            try {

                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

}
