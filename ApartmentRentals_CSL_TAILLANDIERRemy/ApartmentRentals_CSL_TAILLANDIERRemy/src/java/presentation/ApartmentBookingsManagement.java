package presentation;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import persistence.ApartmentBookings;
import service.ManageApartmentBookingsInterface;

@ManagedBean(name = "apartmentBookingsManagement")
public class ApartmentBookingsManagement {

    @javax.ejb.EJB(mappedName = "My_ManageApartmentBookings")
    private ManageApartmentBookingsInterface manager = null;

    private ApartmentBookings apartmentBookings;

    public ApartmentBookingsManagement() {
        apartmentBookings = new ApartmentBookings();
    }

    public ApartmentBookings getApartmentBookings() {
        return apartmentBookings;
    }

    public void setApartmentBookings(ApartmentBookings newApartmentBookings) {
        apartmentBookings = newApartmentBookings;
    }
    
    public List<ApartmentBookings> getAllApartmentBookings(){
        assert (manager != null);
        return  manager.getAllApartmentBookings();
    }
    
    public String remove(ApartmentBookings apartmentBookings){
        assert (manager != null);
        if (manager.removeApartmentBookings(apartmentBookings)!= null) {
            return "/apartmentBookings/List";
        }
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentBookingsErrorAlreadyDeleted"));
        return null;
    }
    
    public String create(){
        try {
            assert (manager != null);
            //String -> Date
            Date bookingStartDate = new SimpleDateFormat("dd/MM/yyyy").parse(apartmentBookings.getBookingStartDate())  ;
            Date bookingEndDate =  new SimpleDateFormat("dd/MM/yyyy").parse(apartmentBookings.getBookingEndDate());
            
            //Si la date d'arrivee est inferieure ou egale a la date de depart alors
            if (bookingStartDate.equals(bookingEndDate) || bookingStartDate.before(bookingEndDate)) {
                if (manager.createApartmentBookings(apartmentBookings)!= null) {
                    return "/apartmentBookings/List";
                }
                JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentBookingsErrorDoublonPrimaryKey"));
                return null;
            } else {
                JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentBookingsErrorDateBooking"));
                return null;
            }
        } catch (ParseException ex) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentBookingsErrorParseDate"));
            return null;
        }
    } 

    public String update(ApartmentBookings newApartmentBookings){      
        try {
            assert (manager != null);
            Date bookingStartDate = new SimpleDateFormat("dd/MM/yyyy").parse(newApartmentBookings.getBookingStartDate())  ;
            Date bookingEndDate =  new SimpleDateFormat("dd/MM/yyyy").parse(newApartmentBookings.getBookingEndDate());
            
            if (bookingStartDate.equals(bookingEndDate) || bookingStartDate.before(bookingEndDate)) {
                if (manager.updateApartmentBookings(newApartmentBookings)!= null) {
                    return "/apartmentBookings/List";
                }
                JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentBookingsErrorAlreadyDeleted"));
                return null;   
            } else {
                JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentBookingsErrorDateBooking"));
                return null;
            }
        } catch (ParseException ex) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/presentation/Bundle").getString("ApartmentBookingsErrorParseDate"));
            return null;
        }
    }
}
