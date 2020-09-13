/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import persistence.RefApartmentFacilities;


/**
 *
 * @author Remy
 */
@javax.faces.bean.ManagedBean(name = "refApartmentFacilitiesSession")
@javax.faces.bean.SessionScoped
public class RefApartmentFacilitiesSession {
    
    private RefApartmentFacilities current;

    public RefApartmentFacilitiesSession() {
        current = new RefApartmentFacilities();
    }

    public RefApartmentFacilities getCurrent() {
        return current;
    }

    public void setCurrent(RefApartmentFacilities newCurrent) {
        current = newCurrent;
    }
    
    public String view(RefApartmentFacilities newCurrent){
        setCurrent(newCurrent);
        return "/refApartmentFacilities/View";
    }
    
    public String edit(RefApartmentFacilities newCurrent){
        setCurrent(newCurrent);
        return "/refApartmentFacilities/Edit";
    }
    
}
