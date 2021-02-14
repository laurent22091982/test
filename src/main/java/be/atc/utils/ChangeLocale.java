package be.atc.utils;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author Gautier Olivier
 *
 */

@Named
@SessionScoped
public class ChangeLocale implements Serializable {
    private static final long serialVersionUID = 1L;

    private String locale="fr";

    public String setFrenchLocale() {
        locale = "fr";
        return null;
    }

    public String setDutchLocale() {
        locale = "nl";
        return null;
    }

    public String setEnglishLocale() {
        locale = "en";
        return null;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

}