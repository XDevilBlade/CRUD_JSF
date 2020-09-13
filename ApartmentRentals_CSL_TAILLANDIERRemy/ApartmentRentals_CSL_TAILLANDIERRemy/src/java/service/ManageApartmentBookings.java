/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.ApartmentBookings;

/**
 *
 * @author Remy
 */
@javax.ejb.Stateless(mappedName = "My_ManageApartmentBookings")
public class ManageApartmentBookings implements ManageApartmentBookingsInterface{
    
    @PersistenceContext(unitName = "ApartmentRentals_CSL_TAILLANDIERRemyPU")
    private EntityManager entityManager = null;    

    @Override
    public List<ApartmentBookings> getAllApartmentBookings() {
        assert (entityManager != null);
        return entityManager.createNamedQuery("ApartmentBookings.findAll").getResultList();
    }
    
    private ApartmentBookings findApartmentBookings(ApartmentBookings apartmentBookings){
        return entityManager.find(ApartmentBookings.class, apartmentBookings.getAptBookingId());
    }
    
    @PreDestroy
    public void destroy(){
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    @Override
    public ApartmentBookings removeApartmentBookings(ApartmentBookings apartmentBookings) {
        assert (entityManager != null);
        if (findApartmentBookings(apartmentBookings)!= null) {
            ApartmentBookings ab = entityManager.merge(apartmentBookings);
            entityManager.remove(ab);
            return apartmentBookings;
        }
        return null;
    }

    @Override
    public ApartmentBookings createApartmentBookings(ApartmentBookings newApartmentBookings) {
        assert (entityManager != null);
        if (findApartmentBookings(newApartmentBookings)== null) {
            entityManager.persist(newApartmentBookings);
            return newApartmentBookings;
        }
        return null;
        
    }

    @Override
    public ApartmentBookings updateApartmentBookings(ApartmentBookings newApartmentBookings) {
        assert (entityManager != null);
        if (findApartmentBookings(newApartmentBookings)!= null) {
            return entityManager.merge(newApartmentBookings);
        }
        return null;
    }
    
    
}
