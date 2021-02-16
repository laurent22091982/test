package be.atc.utils;

import be.atc.connection.EMF;

import be.atc.entities.Address;
import be.atc.entities.User;
import be.atc.entities.UserAddress;

import static be.atc.services.UserServices.*;

import javax.persistence.EntityManager;

/**
 * @author Gautier Olivier
 *
 */

public class UserUtils {

    public static User validateLogin(String mail, String password) {
        User user = findUserByMail(mail);
        if ( !(user == null)
                && user.getPassword().equals(SecurePassword.getSecurePassword(password, user.getSalt()))) {
            return user;
        }
        return null;
    }

    public static Boolean saveUser(User user, Address address) {
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