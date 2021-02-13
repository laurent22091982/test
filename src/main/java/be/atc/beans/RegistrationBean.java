package be.atc.beans;

import be.atc.entities.Address;
import be.atc.entities.City;
import be.atc.entities.Role;
import be.atc.entities.User;

import static be.atc.utils.CityUtils.*;
import static be.atc.utils.RoleUtils.*;
import static be.atc.utils.SessionUtils.*;
import static be.atc.utils.UserUtils.*;
import be.atc.utils.SecurePassword;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class RegistrationBean implements Serializable {
    private static final long serialVersionUID = 1L;

    User user = new User();
    Address address = new Address();
    String passwordConfirm ="";
    Boolean agreed = false;
    ArrayList<Role> availableRole = new ArrayList<>();
    ArrayList<City> cityList = new ArrayList<>();
    String zipTemp;
//    List<Address>  userAddresses = new ArrayList<Address>();

    @PostConstruct
    public void init() {
        availableRole.add(0, findOneRole(2));
        availableRole.add(1, findOneRole(3));
        user.setRole(availableRole.get(0));
    }

    public String createUser() {
        boolean isCreated;
        hashPassword();
        isCreated = userSave(user, address);
        HttpSession session = getSession();
        session.setAttribute("connectedUser", user);

        return isCreated ? "success" : "failed";
    }

    public void updateCity() {
        cityList = findPostcodeCity(zipTemp);
    }

    public void hashPassword() {
        List<Object> pwdhash = SecurePassword.hashPassword(user.getPassword());
        user.setPassword(pwdhash.get(0).toString());
        user.setSalt((byte[])pwdhash.get(1));
    }

    public boolean checkEmail(String email) {


        return true;
    }

    // Test User addresses Find
/*    public String testAddresses() {
        for (UserAddress u : user.getUsersAddresses()) {
            userAddresses.add(u.getAddress());
        }
        return null;
    }
*/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
/*
    public List<Address> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<Address> userAddresses) {
        this.userAddresses = userAddresses;
    }
*/
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Boolean getAgreed() {
        return agreed;
    }

    public void setAgreed(Boolean agreed) {
        this.agreed = agreed;
    }

    public ArrayList<Role> getAvailableRole() {
        return availableRole;
    }

    public void setAvailableRole(ArrayList<Role> availableRole) {
        this.availableRole = availableRole;
    }

    public String getZipTemp() {
        return zipTemp;
    }

    public void setZipTemp(String zipTemp) {
        this.zipTemp = zipTemp;
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<City> cityList) {
        this.cityList = cityList;
    }


}
