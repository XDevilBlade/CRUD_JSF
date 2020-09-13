package presentation;


import java.util.List;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import persistence.Apartments;
import service.ManageApartmentsInterface;

@ManagedBean(name = "apartmentsManagement")
public class ApartmentsManagement {

    @javax.ejb.EJB(mappedName = "My_ManageApartments")   
    private ManageApartmentsInterface manager = null;

    private Apartments apartments;

    public ApartmentsManagement() {
        apartments = new Apartments();
    }

    public Apartments getApartments() {
        return apartments;
    }

    public void setApartments(Apartments newApartments) {
        apartments = newApartments;
    }
 
    public List<Apartments> getAllApartments(){
        assert (manager != null);
        return  manager.getAllApartments();
    }
 
    public String remove(Apartments apartments){
        assert (manager != null);
        if (manager.removeApartments(apartments)!= null) {
            return "/apartments/List";
        } 
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentsErrorAlreadyDeleted"));
        return null;
    }
    
    public String create(){
        try {
            assert (manager != null);
            long checkContentVariable = Long.parseLong(apartments.getRoomCount());
            if (manager.createApartments(apartments)!= null) {
                return "/apartments/List";
            }
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentsErrorDoublonPrimaryKey"));
            return null;
        } catch (NumberFormatException e) {
            //Si l'utilisateur a mis des caracteres dans le champ RoomCount
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentsRoomCount"));
            return null;
        }
    } 
    
    public String update(Apartments newApartments){
        try {
            assert (manager != null);
            long checkContentVariable = Long.parseLong(newApartments.getRoomCount());
            if (manager.updateApartments(newApartments) != null) {
                return "/apartments/List";
            } 
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentsErrorAlreadyDeleted"));
            return null;
            
        } catch (NumberFormatException e) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentsRoomCount"));
            return null;
        }
    }
}
