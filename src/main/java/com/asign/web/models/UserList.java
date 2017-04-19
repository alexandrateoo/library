package com.asign.web.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/11/2017.
 */
@XmlRootElement(name = "users")
public class UserList {
    private List userList;

    @XmlElement(name = "user")
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {

        return userList;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "userList=" + userList +
                '}';
    }
}
