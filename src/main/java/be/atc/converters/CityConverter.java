package be.atc.converters;

import be.atc.entities.City;
import be.atc.utils.CityUtils;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Gautier Olivier
 *
 */

@SuppressWarnings("rawtypes")
@Named("CityConverter")
@RequestScoped
@FacesConverter("CityConverter")
public class CityConverter implements Converter, Serializable {
    private static final long serialVersionUID = 1L;

    City city = new City();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty() ) {
            return null;
        }
        try {
            city = CityUtils.findOneCity(Integer.parseInt(value));
            return city;
        }

        catch (Exception e) {
            e.printStackTrace();
            throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to City", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof City) {
            return String.valueOf(((City) value).getId());
        } else {
            return null;
        }
    }
}