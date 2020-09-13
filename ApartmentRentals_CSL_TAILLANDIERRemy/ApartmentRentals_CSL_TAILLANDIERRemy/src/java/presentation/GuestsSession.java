/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import persistence.Guests;


/**
 *
 * @author Remy
 */
@javax.faces.bean.ManagedBean(name = "guestsSession")
@javax.faces.bean.SessionScoped
public class GuestsSession {
    
    private Guests current;

    public GuestsSession() {
        current = new Guests();
    }

    public Guests getCurrent() {
        return current;
    }

    public void setCurrent(Guests newCurrent) {
        current = newCurrent;
    }
    
    public String view(Guests newCurrent){
        setCurrent(newCurrent);
        return "/guests/View";
    }
    
    public String edit(Guests newCurrent){
        setCurrent(newCurrent);
        return "/guests/Edit";
    }
}
