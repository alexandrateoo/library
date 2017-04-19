package com.asign.web.jaxb;


import com.asign.web.models.User;
import com.asign.web.models.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/11/2017.
 */
@Repository("userjaxb")
public class UserJaxb implements UserJaxbInterface {

    private UserList userList;

    public void marshallList(List<User> userList) {
        try {
            UserList listUser = new UserList();
            listUser.setUserList(userList);
            JAXBContext jc = JAXBContext.newInstance(UserList.class);
            Marshaller ms = jc.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ms.marshal(listUser, System.out);
            ms.marshal(listUser, new File("C:\\Users\\Alex\\IdeaProjects\\projectV3\\src\\main\\java\\com\\asign\\data\\userDB.xml"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> unmarshallList() {
//        UserList listUser = new UserList();

        try {
            JAXBContext jc = JAXBContext.newInstance(UserList.class);
            Unmarshaller ums = jc.createUnmarshaller();
            File f = new File("C:\\Users\\Alex\\IdeaProjects\\projectV3\\src\\main\\java\\com\\asign\\data\\userDB.xml");
            userList = (UserList) ums.unmarshal(f);
            return userList.getUserList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userList.getUserList();
    }
}
