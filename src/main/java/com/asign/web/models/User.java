package com.asign.web.models;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Alex on 4/11/2017.
 */
@Component
@XmlRootElement(name="user")
public class User {

    private int id;
    private String Name;
    private String Type;
    private String username;
    private String password;
    private String address;

    public User(){

    }

    public User(int id, String name, String type, String username, String password) {
        this.id = id;
        Name = name;
        Type = type;
        this.username = username;
        this.password = password;
    }

    public boolean isNew() {
        return (this.id == 0);
    }

    @XmlElement(name="id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @XmlElement(name = "type")
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
    @XmlElement(name ="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @XmlElement(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!Name.equals(user.Name)) return false;
        if (!Type.equals(user.Type)) return false;
        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        return address.equals(user.address);
    }
}
