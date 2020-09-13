package presentation;


import java.util.List;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import persistence.RefApartmentTypes;
import service.ManageRefApartmentTypesInterface;

@ManagedBean(name = "refApartmentTypesManagement")
public class RefApartmentTypesManagement {
    
    @javax.ejb.EJB(mappedName = "My_ManageRefApartmentTypes") 
    private ManageRefApartmentTypesInterface manager = null;
    
    private RefApartmentTypes refApartmentTypes;

    public RefApartmentTypesManagement() {
        refApartmentTypes = new RefApartmentTypes();
    }

    public RefApartmentTypes getRefApartmentTypes() {
        return refApartmentTypes;
    }

    public void setRefApartmentTypes(RefApartmentTypes newRefApartmentTypes) {
        refApartmentTypes = newRefApartmentTypes;
    }

    public List<RefApartmentTypes> getAllRefApartmentTypes(){
        assert (manager != null);
        return  manager.getAllRefApartmentTypes();
    }
    
    public String remove(RefApartmentTypes refApartmentTypes){
        assert (manager != null);
        if (manager.removeRefApartmentTypes(refApartmentTypes)!= null) {
            return "/refApartmentTypes/List";
        } 
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("RefApartmentTypesErrorAlreadyDeleted"));
        return null;
    }
    
    public String create(){
        assert (manager != null);
        if (manager.createRefApartmentTypes(refApartmentTypes)!= null) {
            return "/refApartmentTypes/List";
        }
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("RefApartmentTypesErrorDoublonPrimaryKey"));
        return null;
        
    } 
    
    public String update(RefApartmentTypes newRefApartmentTypes){
        assert (manager != null);
        if (manager.updateRefApartmentTypes(newRefApartmentTypes)!= null) {
            return "/refApartmentTypes/List";
        } 
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("RefApartmentTypesErrorAlreadyDeleted"));
        return null;        
    }
}
