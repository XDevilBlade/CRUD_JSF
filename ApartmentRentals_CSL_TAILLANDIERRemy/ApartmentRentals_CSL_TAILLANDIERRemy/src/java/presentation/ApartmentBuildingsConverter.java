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
import persistence.ApartmentBuildings;

/**
 *
 * @author rtaillandier
 */
@FacesConverter(value = "apartmentBuildingsConverter")
public class ApartmentBuildingsConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String apartmentBuildings) {
        if (!apartmentBuildings.equals("-1")) {
            return new ApartmentBuildings(new Integer(apartmentBuildings));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object apartmentBuildings) {
        return ((ApartmentBuildings)apartmentBuildings).toString();
    }
    
    
    
}
