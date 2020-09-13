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
import persistence.Apartments;

/**
 *
 * @author Remy
 */
@FacesConverter(value = "apartmentsConverter")
public class ApartmentsConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String apartments) {
        if (!apartments.equals("-1")) {
            return new Apartments(new Integer(apartments));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object apartments) {
        return ((Apartments)apartments).toString();
    }
    
    
    
}
