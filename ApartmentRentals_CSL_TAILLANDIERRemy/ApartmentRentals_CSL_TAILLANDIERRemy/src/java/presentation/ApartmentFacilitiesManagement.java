/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.List;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import persistence.ApartmentFacilities;
import service.ManageApartmentFacilitiesInterface;

/**
 *
 * @author Remy
 */
@ManagedBean(name = "apartmentFacilitiesManagement")
public class ApartmentFacilitiesManagement {
    
    @javax.ejb.EJB(mappedName = "My_ManageApartmentFacilities")
    private ManageApartmentFacilitiesInterface manager = null;

    private String aptId;
    
    private String facilityCode;

    public ApartmentFacilitiesManagement() {
        aptId = "";
        facilityCode = "";
    }

    public String getAptId() {
        return aptId;
    }

    public void setAptId(String newAptId) {
        aptId = newAptId;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String newFacilityCode) {
        facilityCode = newFacilityCode;
    }
    
    public List<ApartmentFacilities> getAllApartmentFacilities(){
        assert (manager != null);
        return  manager.getAllApartmentFacilities();
    }
    
    public String remove(String aptId, String facilityCode){
        assert (manager != null);
        if (manager.removeApartmentFacilities(new ApartmentFacilities(new Integer(aptId), facilityCode))!= null) {
            return "/apartmentFacilities/List";
        } 
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentFacilitiesErrorAlreadyDeleted"));
        return null;
    }
    
    public String create(){
        assert (manager != null);
        if (manager.createApartmentFacilities(new ApartmentFacilities(new Integer(aptId), facilityCode))!= null) {
            return "/apartmentFacilities/List";
        }
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentFacilitiesErrorDoublonPrimaryKey"));
        return null;
    } 
    
    public String update(String oldAptId, String oldFacilityCode, String newAptId, String newFacilityCode){
        assert (manager != null);
        switch (manager.updateApartmentFacilities(new Integer(oldAptId), oldFacilityCode, new Integer(newAptId), newFacilityCode)){
            case "updated":
                return "/apartmentFacilities/List";
                
            case "doublonPrimaryKey":
                JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentFacilitiesErrorDoublonPrimaryKey"));
                return null;
                
            case "notExist":
                JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentFacilitiesErrorAlreadyDeleted"));
                return null;
                
            default:
                return null;  
        }
    }
    
}
