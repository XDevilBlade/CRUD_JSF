package presentation;


import java.util.List;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import persistence.ViewUnitStatus;
import service.ManageViewUnitStatusInterface;

@ManagedBean(name = "viewUnitStatusManagement")
public class ViewUnitStatusManagement {

    @javax.ejb.EJB(mappedName = "My_ManageViewUnitStatus") 
    private ManageViewUnitStatusInterface manager = null;
    
    private ViewUnitStatus viewUnitStatus;

    public ViewUnitStatusManagement() {
        viewUnitStatus = new ViewUnitStatus();
    }

    public ViewUnitStatus getViewUnitStatus() {
        return viewUnitStatus;
    }

    public void setViewUnitStatus(ViewUnitStatus newViewUnitStatus) {
        viewUnitStatus = newViewUnitStatus;
    }

    public List<ViewUnitStatus> getAllViewUnitStatus(){
        assert (manager != null);
        return  manager.getAllViewUnitStatus();
    }
    
    public String remove(ViewUnitStatus viewUnitStatus){
        assert (manager != null);
        if (manager.removeViewUnitStatus(viewUnitStatus)!= null) {
            return "/viewUnitStatus/List";
        } 
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ViewUnitStatusErrorAlreadyDeleted"));
        return null;
    }
    
    public String create(){
        assert (manager != null);
        if (manager.createViewUnitStatus(viewUnitStatus)!= null) {
            return "/viewUnitStatus/List";
        }
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ViewUnitStatusErrorDoublonPrimaryKey"));
        return null;
        
    } 
    
    public String update(ViewUnitStatus newViewUnitStatus){
        assert (manager != null);
        if (manager.updateViewUnitStatus(newViewUnitStatus)!= null) {
            return "/viewUnitStatus/List";
        }  
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ViewUnitStatusErrorAlreadyDeleted"));
        return null;
    }
}
