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

/**
 *
 * @author Remy
 */
@FacesConverter(value = "dateToStringConverter")
public class DateToStringConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String date) {
            return date;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object date) {
        return date.toString();
    }
}
