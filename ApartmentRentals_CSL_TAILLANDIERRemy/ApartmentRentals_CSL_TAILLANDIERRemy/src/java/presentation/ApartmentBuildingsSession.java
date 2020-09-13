/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import persistence.ApartmentBuildings;


/**
 *
 * @author Remy
 */
@javax.faces.bean.ManagedBean(name = "apartmentBuildingsSession")
@javax.faces.bean.SessionScoped
public class ApartmentBuildingsSession {
    
    private ApartmentBuildings current;

    public ApartmentBuildingsSession() {
        current = new ApartmentBuildings();
    }

    public ApartmentBuildings getCurrent() {
        return current;
    }

    public void setCurrent(ApartmentBuildings newCurrent) {
        current = newCurrent;
    }
    
    public String view(ApartmentBuildings newCurrent){
        setCurrent(newCurrent);
        return "/apartmentBuildings/View";
    }
    
    public String edit(ApartmentBuildings newCurrent){
        setCurrent(newCurrent);
        return "/apartmentBuildings/Edit";
    }
    
}
