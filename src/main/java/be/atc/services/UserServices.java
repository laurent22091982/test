package be.atc.services;

import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;

import be.atc.entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServices {

    public static User findUserByMail(String mail) {
        List<User> userList;
        Map<String, Object> map = new HashMap<>();
        map.put("userMail", mail);
        EntityFinder<User> ef = new EntityFinderImpl<>();
        userList = ef.findByNamedQuery("User.findByMail", new User(), map);
        if (!userList.isEmpty() && userList.get(0).getMail().equals(mail)) {
            return userList.get(0);
        }
        return null;
    }
}
