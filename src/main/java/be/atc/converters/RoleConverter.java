package be.atc.converters;

import be.atc.entities.Role;
import static be.atc.services.RoleServices.*;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 * @author Gautier Olivier
 *
 */

@SuppressWarnings("rawtypes")
@Named("RoleConverter")
@RequestScoped
@FacesConverter("RoleConverter")
public class RoleConverter implements Converter, Serializable {
    private static final long serialVersionUID = 1L;

    Role role = new Role();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty() ) {
            return null;
        }
        try {
            role = findOneRole(Integer.parseInt(value));
            return role;
        }

        catch (Exception e) {
            e.printStackTrace();
            throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to Role", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof Role) {
            return String.valueOf(((Role) value).getId());
        } else {
            return null;
        }
    }
}