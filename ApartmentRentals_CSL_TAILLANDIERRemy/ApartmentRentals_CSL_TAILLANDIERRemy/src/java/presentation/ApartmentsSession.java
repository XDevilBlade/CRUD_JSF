/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import persistence.Apartments;


/**
 *
 * @author Remy
 */
@javax.faces.bean.ManagedBean(name = "apartmentsSession")
@javax.faces.bean.SessionScoped
public class ApartmentsSession {
    
    private Apartments current;

    public ApartmentsSession() {
        current = new Apartments();
    }

    public Apartments getCurrent() {
        return current;
    }

    public void setCurrent(Apartments newCurrent) {
        current = newCurrent;
    }
    
    public String view(Apartments newCurrent){
        setCurrent(newCurrent);
        return "/apartments/View";
    }
    
    public String edit(Apartments newCurrent){
        setCurrent(newCurrent);
        return "/apartments/Edit";
    }
    
}
