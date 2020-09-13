package presentation;


import java.util.List;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import persistence.Guests;
import service.ManageGuestsInterface;

@ManagedBean(name = "guestsManagement")
public class GuestsManagement {

    @javax.ejb.EJB(mappedName = "My_ManageGuests")   
    private ManageGuestsInterface manager = null;
  
    private Guests guests;

    public GuestsManagement() {
        guests = new Guests();
    }

    public Guests getGuests() {
        return guests;
    }

    public void setGuests(Guests newGuests) {
        guests = newGuests;
    }

    public List<Guests> getAllGuests(){
        assert (manager != null);
        return  manager.getAllGuests();
    }
    
    public String remove(Guests guests){
        assert (manager != null);
        if (manager.removeGuests(guests)!= null) {
            return "/guests/List";
        } 
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("GuestsErrorAlreadyDeleted"));
        return null;
    }
    
    public String create(){
        assert (manager != null);
        if (manager.createGuests(guests)!= null) {
            return "/guests/List";
        }
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("GuestsErrorDoublonPrimaryKey"));
        return null;
    } 
    
    public String update(Guests newGuests){
        assert (manager != null);
        if (manager.updateGuests(newGuests) != null) {
            return "/guests/List";
        } 
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("GuestsErrorAlreadyDeleted"));
        return null;
    }
  
}
