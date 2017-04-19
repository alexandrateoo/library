package com.asign.web.controller;

import com.asign.web.models.User;
import com.asign.web.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Alex on 4/11/2017.
 */

@Controller
public class AppController {

    private final String ADMIN = "admin";
    private final String USER = "employee";

    @Autowired
    private UserServices userServices;// = new UserServiceImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome() {
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        String message;
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        if (userServices.existsUser(user)) {
            userServices.setUserDetails(user);
            if (user.getType().equals(ADMIN)) {
                return new ModelAndView("admin/adminPage");
            } else {
                if (user.getType().equals(USER))
                    return new ModelAndView("user/employeePage");
            }
        } else {
            message = "Wrong username or password.";
            return new ModelAndView("login", "message", message);
        }

        return new ModelAndView("login");
    }

}
