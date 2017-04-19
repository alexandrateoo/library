package com.asign.web.service;

import com.asign.web.jaxb.UserJaxb;
import com.asign.web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/17/2017.
 */

@Service("userservice")
@Transactional
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserJaxb userJaxb;// = new UserJaxb();
    private List<User> allUsers = getAllUsers();


    public boolean existsUser(User user) {

        for (User u : allUsers) {
            if (user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())) {
                return true;
            }
        }

        return false;
    }

    public User findById(Integer id) {

        for (User u : allUsers) {
         if(u.getId() == id )
             return u;
        }
        return null;
    }

    public User setUserDetails(User user){

        for (User u : allUsers) {
            if (user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())) {
                user.setType(u.getType());
                return user;
            }
        }
        return user;
    }

    public void addUser(User user) {

        if(findById(user.getId() )!= null)
            updateUser(user);
        if (!existsUser(user))
            if (user.getName() != null)
                if (user.getName() != null && user.getPassword() != null) {
                    user.setId(getAllUsers().size()+1);
                    allUsers.add(user);
                    userJaxb.marshallList(allUsers);
                }
           }

    private void updateUser(User user){
        User newUser = findById(user.getId());
        if(newUser!= null) {
            newUser.setAddress(user.getAddress());
            newUser.setName(user.getName());
            newUser.setPassword(user.getPassword());
            newUser.setUsername(user.getUsername());
            allUsers.remove(user);
            allUsers.add(newUser);
            userJaxb.marshallList(allUsers);
        }
    }

    public void deleteUser(User user) {

        allUsers.remove(user);
        userJaxb.marshallList(allUsers);
    }

    public List<User> getAllUsers() {
        userJaxb = new UserJaxb();
        return userJaxb.unmarshallList();
    }
}
