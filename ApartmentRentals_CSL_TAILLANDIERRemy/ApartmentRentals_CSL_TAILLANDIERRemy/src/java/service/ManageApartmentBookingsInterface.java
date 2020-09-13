/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import persistence.ApartmentBookings;

/**
 *
 * @author Remy
 */
@javax.ejb.Local
public interface ManageApartmentBookingsInterface {
    public List<ApartmentBookings> getAllApartmentBookings();
    public ApartmentBookings removeApartmentBookings(ApartmentBookings apartmentBookings);
    public ApartmentBookings createApartmentBookings(ApartmentBookings newApartmentBookings);
    public ApartmentBookings updateApartmentBookings(ApartmentBookings newApartmentBookings);
}
