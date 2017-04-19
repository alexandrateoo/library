package com.asign.web.controller;

import com.asign.fileOp.CreateCSV;
import com.asign.fileOp.CreatePDF;
import com.asign.web.jaxb.BookJaxb;
import com.asign.web.models.Book;
import com.asign.web.models.User;
import com.asign.web.service.BookServices;
import com.asign.web.service.UserServices;
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
//@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserServices userServices;
    @Autowired
    BookServices bookServices;


    @RequestMapping("/admin")
    public String greetingSubmit(@RequestParam(value = "title", defaultValue = "") String title, Model model) {
        BookJaxb bj = new BookJaxb();
        List<Book> resultList = new ArrayList<Book>();
        List<Book> list = bj.unmarshallList();
        for (Book b : list) {
            if (b.getTitle().matches("(.*)" + title + "(.*)+")) {
                resultList.add(b);
            }
        }

        model.addAttribute("books", resultList);
        return "admin/adminPage";
    }

    @RequestMapping(value = "/admin/CRUDBooks", method = RequestMethod.GET)
    public String crudBookPage(Model model){
        model.addAttribute("books",bookServices.getAllBooks());
        return "admin/CRUDBooks";
    }

    @RequestMapping(value = "/admin/CRUDUsers", method = RequestMethod.GET)
    public String crudUsersPage(Model model){
        model.addAttribute("users",userServices.getAllUsers());
        return "admin/CRUDUsers";
    }

    @RequestMapping(value = "/admin/generateReport")
    public String generateReportPage(){
        new CreateCSV();
        new CreatePDF();
        return "admin/adminPage";
    }

    // save or update user
    @RequestMapping(value = "/admin/users", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user,
                                   BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "admin/userform";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(!userServices.existsUser(user)){
                redirectAttributes.addFlashAttribute("msg", "User added successfully!");
            }else{
                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
            }

            userServices.addUser(user);


            // POST/REDIRECT/GET
            return "redirect:/admin/CRUDUsers";

        }

    }

    // show add user form
    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {

        User user = new User();

        // set default value
        user.setName("username123");
        user.setAddress("abc 88");

        model.addAttribute("userForm", user);

        return "admin/userform";

    }



    // show update form
    @RequestMapping(value = "/admin/users/{id}/update", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("id") int id, Model model) {

        User user = userServices.findById(id);
        model.addAttribute("userForm", user);

        return "admin/userform";

    }

    // delete user
    @RequestMapping(value = "/admin/users/{id}/delete", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        User user = userServices.findById(id);
        userServices.deleteUser(user);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "User is deleted!");

        return "redirect:/admin/CRUDUsers";

    }

    // show user
    @RequestMapping(value = "/admin/users/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") int id, Model model) {

        User user = userServices.findById(id);
        if (user == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("user", user);

        return "admin/show";

    }

    @RequestMapping(value = "/admin/books", method = RequestMethod.POST)
    public String saveOrUpdateBook(@ModelAttribute("bookForm") @Validated Book book,
                                   BindingResult result,Model model, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            generateValues(model);
            return "admin/bookform";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(!bookServices.existsBook(book)){
                redirectAttributes.addFlashAttribute("msg", "Book added successfully!");
            }else{
                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
            }

            bookServices.addBook(book);
            // POST/REDIRECT/GET
            return "redirect:/admin/CRUDBooks";

        }

    }

    // show add book form
    @RequestMapping(value = "/admin/books/add", method = RequestMethod.GET)
    public String showAddBookForm(Model model) {

        Book book = new Book();
        // set default value
        book.setAuthor("Surname Name");
        book.setGenre("genre1-genre2-etc");
        book.setISBN("L3TT3RS");
        book.setPrice(0);
        book.setQuantity(0);
        book.setTitle("Title");

        model.addAttribute("userForm", book);
        generateValues(model);
        return "admin/bookform";

    }

    // show update form
    @RequestMapping(value = "/admin/books/{id}/update", method = RequestMethod.GET)
    public String showUpdateBookForm(@PathVariable("id") String id, Model model) {

        Book book = bookServices.getBookInfo(id);
        model.addAttribute("bookForm", book);
        generateValues(model);
        return "admin/bookform";

    }

    // delete book
    @RequestMapping(value = "/admin/books/{id}/delete", method = RequestMethod.POST)
    public String deleteBook(@PathVariable("id") String id, final RedirectAttributes redirectAttributes) {

        Book book = bookServices.getBookInfo(id);
        bookServices.deleteBook(book);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Book is deleted!");

        return "redirect:/admin/CRUDBooks";

    }

    // show book
    @RequestMapping(value = "/admin/books/{id}", method = RequestMethod.GET)
    public String showBook(@PathVariable("id") String id, Model model) {

        Book book = bookServices.getBookInfo(id);
        if (book == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Book not found");
        }
        model.addAttribute("book", book);

        return "admin/showbook";

    }

    private void generateValues(Model model){
        List<String> genreList = new ArrayList<String>();
        genreList.add("action");
        genreList.add("drama");
        genreList.add("SCI-FI");
        genreList.add("novel");
        genreList.add("children");
        model.addAttribute("genreList", genreList);
    }


}
