package be.atc.beans;

import be.atc.entities.User;
import be.atc.utils.UserUtils;
import be.atc.utils.SessionUtils;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

import static be.atc.utils.SessionUtils.*;
import static be.atc.utils.UserUtils.validateLogin;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String mail;
    private String password;
    User user = new User();

    //validate login
    public String validateMailPassword() {
        user = validateLogin(mail, password);
        if ( user != null) {
            HttpSession session = getSession();
            session.setAttribute("connectedUser", user);
            return "success";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Password",
                            "Please enter correct username and Password"));
            return "login";
        }
    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = getSession();
        session.invalidate();
        return "login";
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
