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
import persistence.ApartmentBookings;

/**
 *
 * @author rtaillandier
 */
@FacesConverter(value = "apartmentBookingsConverter")
public class ApartmentBookingsConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String apartmentBookings) {
        if (!apartmentBookings.equals("-1")) {
            return new ApartmentBookings(new Integer(apartmentBookings));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object apartmentBookings) {
        return ((ApartmentBookings)apartmentBookings).toString();
    }
    
}
