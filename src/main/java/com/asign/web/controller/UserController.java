package com.asign.web.controller;

import com.asign.web.models.Book;
import com.asign.web.service.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/11/2017.
 */
@Controller
public class UserController {

    @Autowired
    private BookServices bookServices;

    @RequestMapping(value = "/users")
    public String welcomeUser(Model model) {
        model.addAttribute("books",bookServices.getAllBooks());
        return "user/employeePage";
    }

    //de facut o metoda ca asta de mai jos da fara criteria sa imi returneze pur si simplu toate cartile

    @RequestMapping(value = "/users/search/{criteria}")
    public String searchPage( @PathVariable("criteria") String search, Model model) {

        List<Book> allBooks = new ArrayList<Book>();

        if (!bookServices.getAllBooksAuthor(search).isEmpty())
            allBooks.addAll(bookServices.getAllBooksAuthor(search));

        if (!bookServices.getAllBooksGenre(search).isEmpty())
            allBooks.addAll(bookServices.getAllBooksGenre(search));

        if (!bookServices.getAllBooksTitle(search).isEmpty())
            allBooks.addAll(bookServices.getAllBooksTitle(search));

        model.addAttribute("bookSearchCriteria", allBooks);

        return "/user/searchBook";
    }


    @RequestMapping(value = "/users/searchbygenre", method = RequestMethod.GET)
    public String searchGenre(@RequestParam("genre") String genre, Model model) {
        List<Book> allBooks = bookServices.getAllBooksGenre(genre);
        model.addAttribute("genreSearch", allBooks);
        return "/user/searchBook";
    }

    @RequestMapping(value = "/users/searchbyauthor", method = RequestMethod.GET)
    public String searchAuthor(@RequestParam("genre") String author, Model model) {
        List<Book> allBooks = bookServices.getAllBooksAuthor(author);
        model.addAttribute("authorSearch", allBooks);
        return "/user/searchBook";
    }

    @RequestMapping(value = "/users/searchbytitle", method = RequestMethod.GET)
    public String searchTitle(@RequestParam("title") String title, Model model) {
        List<Book> allBooks = bookServices.getAllBooksTitle(title);
        model.addAttribute("titleSearch", allBooks);
        return "/user/searchBook";
    }


    @RequestMapping(value = "/users/buybook", method = RequestMethod.POST)
    public String buyBook(@ModelAttribute("buybook") @Validated Book book, BindingResult result, Model model,
                          final RedirectAttributes redirectAttributes) {
        if (book.getQuantity() > 1) {
            book.setQuantity(book.getQuantity() - 1);
            bookServices.addBook(book);
            redirectAttributes.addFlashAttribute("msg", "Book added to order");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Not enough books in stock!");
        }
        return "redirect:user/searchBook";

    }


}
