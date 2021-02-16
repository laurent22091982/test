package be.atc.validators;

import static be.atc.services.UserServices.*;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author Gautier Olivier
 *
 */

@FacesValidator("UserEmailValidator")
public class UserEmailValidator implements Validator {


    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        // Retrieve the value passed to this method
        String email = (String) o;

        // Check email already exist
        if ( !(findUserByMail(email) == null)) {
            String message = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{msg['registration.mail.exist']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }

    }
}