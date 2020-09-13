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
import persistence.RefApartmentFacilities;

/**
 *
 * @author Remy
 */
@FacesConverter(value = "refApartmentFacilitiesConverter")
public class RefApartmentFacilitiesConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String refApartmentFacilities) {
        if (!refApartmentFacilities.equals("-1")) {
            return new RefApartmentFacilities(refApartmentFacilities);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object refApartmentFacilities) {
        return ((RefApartmentFacilities)refApartmentFacilities).toString();
    }

}
