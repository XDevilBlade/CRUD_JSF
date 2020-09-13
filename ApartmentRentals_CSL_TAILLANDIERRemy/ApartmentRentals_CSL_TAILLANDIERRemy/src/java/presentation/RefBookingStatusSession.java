/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import persistence.RefBookingStatus;


/**
 *
 * @author Remy
 */
@javax.faces.bean.ManagedBean(name = "refBookingStatusSession")
@javax.faces.bean.SessionScoped
public class RefBookingStatusSession {
    
    private RefBookingStatus current;

    public RefBookingStatusSession() {
        current = new RefBookingStatus();
    }

    public RefBookingStatus getCurrent() {
        return current;
    }

    public void setCurrent(RefBookingStatus newCurrent) {
        current = newCurrent;
    }
    
    public String view(RefBookingStatus newCurrent){
        setCurrent(newCurrent);
        return "/refBookingStatus/View";
    }
    
    public String edit(RefBookingStatus newCurrent){
        setCurrent(newCurrent);
        return "/refBookingStatus/Edit";
    }
}
