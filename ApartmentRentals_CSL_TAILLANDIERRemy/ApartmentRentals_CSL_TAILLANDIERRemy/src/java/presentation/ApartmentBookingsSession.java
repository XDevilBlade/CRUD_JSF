/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import persistence.ApartmentBookings;


/**
 *
 * @author Remy
 */
@javax.faces.bean.ManagedBean(name = "apartmentBookingsSession")
@javax.faces.bean.SessionScoped
public class ApartmentBookingsSession {
    
    private ApartmentBookings current;

    public ApartmentBookingsSession() {
        
        current = new ApartmentBookings();
        
    }

    public ApartmentBookings getCurrent() {
        return current;
    }

    public void setCurrent(ApartmentBookings newCurrent) {
        current = newCurrent;
    }
    
    public String view(ApartmentBookings newCurrent){
        setCurrent(newCurrent);
        return "/apartmentBookings/View";
    }
    
    public String edit(ApartmentBookings newCurrent){
        setCurrent(newCurrent);
        return "/apartmentBookings/Edit";
    }
    
    
    
}
