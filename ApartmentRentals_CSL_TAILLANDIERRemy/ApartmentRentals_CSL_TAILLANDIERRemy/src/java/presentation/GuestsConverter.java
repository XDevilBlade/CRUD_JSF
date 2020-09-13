/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import persistence.Guests;

/**
 *
 * @author Remy
 */
@FacesConverter(value = "guestsConverter")
public class GuestsConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String guest) {
        if (!guest.equals("-1")) {
            return new Guests(new Integer(guest));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object guest) {
        return ((Guests)guest).toString();
    }
 
}
