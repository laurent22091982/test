package be.atc.utils;

import be.atc.entities.User;

import be.atc.connection.EMF;
import be.atc.connection.EntityFinder;
import be.atc.connection.EntityFinderImpl;

import java.util.ArrayList;
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

/*    public static boolean validate (String mail, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("userMail", email);
        EntityFinder<User> ef = new EntityFinderImpl<User>();
        userList = ef.findByNamedQuery("User.findByMail", new User(), map);
        if (!userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }

    public static boolean validate2(String mail, String password) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select uname, password from Users where uname = ? and password = ?");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //result found, means valid inputs
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
        }
        return false;
    }
}
*/