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
import persistence.RefBookingStatus;

/**
 *
 * @author Remy
 */
@FacesConverter(value = "refBookingStatusConverter")
public class RefBookingStatusConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String refBookingStatus) {
        if (!refBookingStatus.equals("-1")) {
            return new RefBookingStatus(refBookingStatus);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object refBookingStatus) {
        return ((RefBookingStatus)refBookingStatus).toString();
    }
    
}
