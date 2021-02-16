package be.atc.beans;

import be.atc.entities.Address;
import be.atc.entities.City;
import be.atc.entities.Role;
import be.atc.entities.User;

import static be.atc.services.CityServices.*;
import static be.atc.services.RoleServices.*;
import static be.atc.utils.UserUtils.*;
import be.atc.utils.SecurePassword;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gautier Olivier
 *
 */

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

    @PostConstruct
    public void init() {
        availableRole.add(0, findOneRole(2));
        availableRole.add(1, findOneRole(3));
        user.setRole(availableRole.get(0));
    }

    public String createUser() {
        boolean isCreated;
        hashPassword();
        user.setActive(true);
        isCreated = saveUser(user, address);

        return isCreated ? "success" : "failed";
    }

    public void updateCity() {
        cityList = findCitiesByZipCode(zipTemp);
    }

    public void hashPassword() {
        List<Object> pwdhash = SecurePassword.hashPassword(user.getPassword());
        user.setPassword(pwdhash.get(0).toString());
        user.setSalt((byte[])pwdhash.get(1));
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    public String getPasswordConfirm() { return passwordConfirm; }

    public void setPasswordConfirm(String passwordConfirm) { this.passwordConfirm = passwordConfirm; }

    public Boolean getAgreed() { return agreed; }

    public void setAgreed(Boolean agreed) { this.agreed = agreed; }

    public ArrayList<Role> getAvailableRole() { return availableRole; }

    public void setAvailableRole(ArrayList<Role> availableRole) { this.availableRole = availableRole; }

    public String getZipTemp() { return zipTemp; }

    public void setZipTemp(String zipTemp) { this.zipTemp = zipTemp; }

    public ArrayList<City> getCityList() { return cityList; }

    public void setCityList(ArrayList<City> cityList) { this.cityList = cityList; }

}