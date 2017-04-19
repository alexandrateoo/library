package com.asign.web.jaxb;


import com.asign.web.models.Book;
import com.asign.web.models.BookList;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Created by Alex on 4/11/2017.
 */
@Repository("bookjaxb")
public class BookJaxb {

    public void marshallList(List<Book> bookList) {
        try {
            BookList listBook = new BookList();
            listBook.setBookList(bookList);

            JAXBContext jc = JAXBContext.newInstance(BookList.class);
            Marshaller ms = jc.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ms.marshal(listBook, new File("C:\\Users\\Alex\\IdeaProjects\\projectV3\\src\\main\\java\\com\\asign\\data\\bookDB.xml"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Book> unmarshallList() {
        BookList bookList = new BookList();
        try {
            JAXBContext jc = JAXBContext.newInstance(BookList.class);
            Unmarshaller ums = jc.createUnmarshaller();
            bookList = (BookList) ums.unmarshal(new File("C:\\Users\\Alex\\IdeaProjects\\projectV3\\src\\main\\java\\com\\asign\\data\\bookDB.xml"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bookList.getBookList();
    }
}
