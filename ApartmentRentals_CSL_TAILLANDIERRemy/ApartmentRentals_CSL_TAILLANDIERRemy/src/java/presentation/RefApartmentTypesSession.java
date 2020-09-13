/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import persistence.RefApartmentTypes;


/**
 *
 * @author Remy
 */
@javax.faces.bean.ManagedBean(name = "refApartmentTypesSession")
@javax.faces.bean.SessionScoped
public class RefApartmentTypesSession {
    
    private RefApartmentTypes current;

    public RefApartmentTypesSession() {
        current = new RefApartmentTypes();
    }

    public RefApartmentTypes getCurrent() {
        return current;
    }

    public void setCurrent(RefApartmentTypes newCurrent) {
        current = newCurrent;
    }
    
    public String view(RefApartmentTypes newCurrent){
        setCurrent(newCurrent);
        return "/refApartmentTypes/View";
    }
    
    public String edit(RefApartmentTypes newCurrent){
        setCurrent(newCurrent);
        return "/refApartmentTypes/Edit";
    }
}
