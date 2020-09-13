/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;


/**
 *
 * @author Remy
 */
@javax.faces.bean.ManagedBean(name = "apartmentFacilitiesSession")
@javax.faces.bean.SessionScoped
public class ApartmentFacilitiesSession {
    
    private String currentAptId;
    
    private String currentFacilityCode;
    
    private String currentAptIdAfterEdit;
    
    private String currentFacilityCodeAfterEdit;

    public ApartmentFacilitiesSession() {
        currentAptId = "";
        currentFacilityCode = "";
        currentAptIdAfterEdit = "";
        currentFacilityCodeAfterEdit = "";
    }

    public String getCurrentAptId() {
        return currentAptId;
    }

    public void setCurrentAptId(String newCurrentAptId) {
        currentAptId = newCurrentAptId;
    }

    public String getCurrentFacilityCode() {
        return currentFacilityCode;
    }

    public void setCurrentFacilityCode(String newCurrentFacilityCode) {
        currentFacilityCode = newCurrentFacilityCode;
    }

    public String getCurrentAptIdAfterEdit() {
        return currentAptIdAfterEdit;
    }

    public void setCurrentAptIdAfterEdit(String newCurrentAptIdAfterEdit) {
        currentAptIdAfterEdit = newCurrentAptIdAfterEdit;
    }

    public String getCurrentFacilityCodeAfterEdit() {
        return currentFacilityCodeAfterEdit;
    }

    public void setCurrentFacilityCodeAfterEdit(String newCurrentFacilityCodeAfterEdit) {
        currentFacilityCodeAfterEdit = newCurrentFacilityCodeAfterEdit;
    }
    
    public String view(String newCurrentAptId, String newCurrentFacilityCode){
        setCurrentAptId(newCurrentAptId);
        setCurrentFacilityCode(newCurrentFacilityCode);
        return "/apartmentFacilities/View";
    }
    
    public String edit(String newCurrentAptId, String newCurrentFacilityCode, String newCurrentAptIdAfterEdit, String newCurrentFacilityCodeAfterEdit){
        setCurrentAptId(newCurrentAptId);
        setCurrentFacilityCode(newCurrentFacilityCode);
        setCurrentAptIdAfterEdit(newCurrentAptIdAfterEdit);
        setCurrentFacilityCodeAfterEdit(newCurrentFacilityCodeAfterEdit);
        return "/apartmentFacilities/Edit";
    }
    
}
