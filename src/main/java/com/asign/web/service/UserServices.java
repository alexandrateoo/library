package com.asign.web.service;

import com.asign.web.models.User;

import java.util.List;

/**
 * Created by Alex on 4/17/2017.
 */

public interface UserServices {

    boolean existsUser(User user);

    User findById(Integer id);

    void addUser(User user);

    void deleteUser(User user);

    List<User> getAllUsers();

    User setUserDetails(User user);

}
