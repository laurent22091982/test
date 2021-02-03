package be.atc.utils;

import be.atc.entities.User;

import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginUtils {


    public static User validate(String mail, String password) {
        List<User> userList;
        Map<String, Object> map = new HashMap<>();
        map.put("userMail", mail);
        EntityFinder<User> ef = new EntityFinderImpl<User>();
        userList = ef.findByNamedQuery("User.findByMail", new User(), map);
        if (!userList.isEmpty()
                && userList.get(0).getMail().equals(mail)
                && userList.get(0).getPassword().equals(password)) {
            return userList.get(0);
        }
        return null;
    }
}