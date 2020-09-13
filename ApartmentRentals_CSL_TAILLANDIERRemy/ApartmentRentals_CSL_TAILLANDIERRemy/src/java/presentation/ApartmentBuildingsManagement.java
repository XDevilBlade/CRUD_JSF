package presentation;



import java.util.List;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import persistence.ApartmentBuildings;
import service.ManageApartmentBuildingsInterface;

@ManagedBean(name = "apartmentBuildingsManagement")
public class ApartmentBuildingsManagement {

    @javax.ejb.EJB(mappedName = "My_ManageApartmentBuildings")
    private ManageApartmentBuildingsInterface manager = null;

    private ApartmentBuildings apartmentBuildings;

    public ApartmentBuildingsManagement() {
        apartmentBuildings = new ApartmentBuildings();
    }

    public ApartmentBuildings getApartmentBuildings() {
        return apartmentBuildings;
    }

    public void setApartmentBuildings(ApartmentBuildings newApartmentBuildings) {
        apartmentBuildings = newApartmentBuildings;
    }    
    
    public List<ApartmentBuildings> getAllApartmentBuildings(){
        assert (manager != null);
        return  manager.getAllApartmentBuildings();
    }
    
    public String remove(ApartmentBuildings apartmentBuildings){
        assert (manager != null);
        if (manager.removeApartmentBuildings(apartmentBuildings)!= null) {
            return "/apartmentBuildings/List";
        } 
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentBuildingsErrorAlreadyDeleted"));
        return null;
    }
    
    public String create(){
        assert (manager != null);
        try {
            long checkContentVariable = Long.parseLong(apartmentBuildings.getBuildingPhone());
            if (manager.createApartmentBuildings(apartmentBuildings)!= null) {
               return "/apartmentBuildings/List"; 
            }
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentBuildingsErrorDoublonPrimaryKey"));
            return null;
            
        } catch (NumberFormatException e) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentBuildingsPhone"));
            return null;
        } 
    } 
    
    public String update(ApartmentBuildings newApartmentBuildings){
        assert (manager != null);
        try {
            long checkContentVariable = Long.parseLong(newApartmentBuildings.getBuildingPhone());
            if (manager.updateApartmentBuildings(newApartmentBuildings) != null) {
                return "/apartmentBuildings/List";
            }
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentBuildingsErrorAlreadyDeleted"));
            return null;
            
        } catch (NumberFormatException e) {
             JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentBuildingsPhone"));
             return null;
        } 
    }
}
