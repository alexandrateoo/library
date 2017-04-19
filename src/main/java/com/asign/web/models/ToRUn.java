package com.asign.web.models;

import com.asign.web.jaxb.UserJaxb;
import com.asign.web.service.UserServiceImpl;
import com.asign.web.service.UserServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/17/2017.
 */
public class ToRUn {
    public static void main(String[] args) {
//        List<User> list = new ArrayList<User>();
//        UserJaxb userJaxb = new UserJaxb();
//        list.addAll(userJaxb.unmarshallList());
//        list.add(new User(5,"myname","myposition","username","password"));
//        userJaxb.marshallList(list);

        UserServices us = new UserServiceImpl();
                us.addUser(new User(5,"myname","myposition","username","password"));
    }
}
