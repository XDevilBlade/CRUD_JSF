package presentation;


import java.util.List;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import persistence.RefBookingStatus;
import service.ManageRefBookingStatusInterface;

@ManagedBean(name = "refBookingStatusManagement")
public class RefBookingStatusManagement {

    @javax.ejb.EJB(mappedName = "My_ManageRefBookingStatus") 
    private ManageRefBookingStatusInterface manager = null;
    
    private RefBookingStatus refBookingStatus;

    public RefBookingStatusManagement() {
        refBookingStatus = new RefBookingStatus();
    }

    public RefBookingStatus getRefBookingStatus() {
        return refBookingStatus;
    }

    public void setRefBookingStatus(RefBookingStatus newRefBookingStatus) {
        refBookingStatus = newRefBookingStatus;
    }
    
    public List<RefBookingStatus> getAllRefBookingStatus(){
        assert (manager != null);
        return  manager.getAllRefBookingStatus();
    }
    
    public String remove(RefBookingStatus refBookingStatus){
        assert (manager != null);
        if (manager.removeRefBookingStatus(refBookingStatus)!= null) {
           return "/refBookingStatus/List"; 
        }
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("RefBookingStatusErrorAlreadyDeleted"));
        return null;
    }
    
    public String create(){
        assert (manager != null);
        if (manager.createRefBookingStatus(refBookingStatus)!= null) {
            return "/refBookingStatus/List";
        }
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("RefBookingStatusErrorDoublonPrimaryKey"));
        return null;
       
    } 
    
    public String update(RefBookingStatus newRefBookingStatus){
        assert (manager != null);
        if (manager.updateRefBookingStatus(newRefBookingStatus)!= null) {
            return "/refBookingStatus/List";
        }
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("RefBookingStatusErrorAlreadyDeleted"));
        return null;
    }
}
