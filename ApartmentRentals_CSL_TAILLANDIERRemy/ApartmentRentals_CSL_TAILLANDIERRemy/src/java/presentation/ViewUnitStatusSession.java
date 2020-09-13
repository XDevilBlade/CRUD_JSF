/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import persistence.ViewUnitStatus;


/**
 *
 * @author Remy
 */
@javax.faces.bean.ManagedBean(name = "viewUnitStatusSession")
@javax.faces.bean.SessionScoped
public class ViewUnitStatusSession {
    
    private ViewUnitStatus current;

    public ViewUnitStatusSession() {
        current = new ViewUnitStatus();
    }

    public ViewUnitStatus getCurrent() {
        return current;
    }

    public void setCurrent(ViewUnitStatus newCurrent) {
        current = newCurrent;
    }
    
    public String view(ViewUnitStatus newCurrent){
        setCurrent(newCurrent);
        return "/viewUnitStatus/View";
    }
    
    public String edit(ViewUnitStatus newCurrent){
        setCurrent(newCurrent);
        return "/viewUnitStatus/Edit";
    }
    
    
}
