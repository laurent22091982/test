package be.atc.utils;

import be.atc.connection.EMF;
import be.atc.entities.Address;
import be.atc.entities.User;

import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;
import be.atc.entities.UserAddress;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserUtils {


    public static User validateLogin(String mail, String password) {
        List<User> userList;
        Map<String, Object> map = new HashMap<>();
        map.put("userMail", mail);
        EntityFinder<User> ef = new EntityFinderImpl<User>();
        userList = ef.findByNamedQuery("User.findByMail", new User(), map);
        if (!userList.isEmpty()
                && userList.get(0).getMail().equals(mail)
                && userList.get(0).getPassword().equals(SecurePassword.getSecurePassword(password, userList.get(0).getSalt()))) {
            return userList.get(0);
        }
        return null;
    }

    public static Boolean userSave(User user, Address address) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUser(user);
        userAddress.setAddress(address);
        EntityManager em = EMF.getEM();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.merge(address);
            em.merge(userAddress);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
        finally {
            em.close();
        }
        return true;
    }
}