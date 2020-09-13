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
import persistence.RefApartmentTypes;

/**
 *
 * @author rtaillandier
 */
@FacesConverter(value = "refApartmentTypesConverter")
public class RefApartmentTypesConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String refApartmentTypes) {
        if (!refApartmentTypes.equals("-1")) {
            return new RefApartmentTypes(refApartmentTypes);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object refApartmentTypes) {
        return ((RefApartmentTypes)refApartmentTypes).toString();
    }
  
}
