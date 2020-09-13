package presentation;


import java.util.List;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import persistence.RefApartmentFacilities;
import service.ManageRefApartmentFacilitiesInterface;

@ManagedBean(name = "refApartmentFacilitiesManagement")
public class RefApartmentFacilitiesManagement {

    @javax.ejb.EJB(mappedName = "My_ManageRefApartmentFacilities")    
    private ManageRefApartmentFacilitiesInterface manager = null;
  
    private RefApartmentFacilities refApartmentFacilities;

    public RefApartmentFacilitiesManagement() {
        refApartmentFacilities = new RefApartmentFacilities();
    }

    public RefApartmentFacilities getRefApartmentFacilities() {
        return refApartmentFacilities;
    }

    public void setRefApartmentFacilities(RefApartmentFacilities newRefApartmentFacilities) {
        refApartmentFacilities = newRefApartmentFacilities;
    }

    public List<RefApartmentFacilities> getAllRefApartmentFacilities(){
        assert (manager != null);
        return  manager.getAllRefApartmentFacilities();
    }
  
    public String remove(RefApartmentFacilities refApartmentFacilities){
        assert (manager != null);
        if (manager.removeRefApartmentFacilities(refApartmentFacilities)!= null) {
            return "/refApartmentFacilities/List";
        } 
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("RefApartmentFacilitiesErrorAlreadyDeleted"));
        return null;
    }
    
    public String create(){
        assert (manager != null);
        if (manager.createRefApartmentFacilities(refApartmentFacilities)!= null) {
            return "/refApartmentFacilities/List";
        }
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("RefApartmentFacilitiesErrorDoublonPrimaryKey"));
        return null;
    } 
    
    public String update(RefApartmentFacilities newRefApartmentFacilities){
        assert (manager != null);
        if (manager.updateRefApartmentFacilities(newRefApartmentFacilities)!= null) {
            return "/refApartmentFacilities/List";
        } 
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("RefApartmentFacilitiesErrorAlreadyDeleted"));
        return null;
        
    }
}
