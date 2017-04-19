package com.asign.web.jaxb;

import com.asign.web.models.User;

import java.util.List;

/**
 * Created by Alex on 4/17/2017.
 */
public interface UserJaxbInterface {

    public void marshallList(List<User> userList);
    public List<User> unmarshallList();
}
