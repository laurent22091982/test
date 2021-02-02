package be.atc.utils;

import be.atc.entities.User;

import be.atc.connection.EMF;
import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@RequestScoped
public class FindUser implements Serializable {
    private static final long serialVersionUID = 1L;

    User user = new User();
    List<User> userList = new ArrayList<User>();

    public User findUserByMail (String email) {
        Map<String,Object> map = new HashMap<>();
        map.put("userMail", email);
        EntityFinder<User> ef = new EntityFinderImpl<User>();
        userList = ef.findByNamedQuery("User.findByMail", new User(), map);
        if (!userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
