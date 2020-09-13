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
import persistence.Guests;

/**
 *
 * @author Remy
 */
@javax.ejb.Stateless(mappedName = "My_ManageGuests")
public class ManageGuests implements ManageGuestsInterface{
    
    @PersistenceContext(unitName = "ApartmentRentals_CSL_TAILLANDIERRemyPU")
    private EntityManager entityManager = null; 

    @Override
    public List<Guests> getAllGuests() {
        assert (entityManager != null);
        return entityManager.createNamedQuery("Guests.findAll").getResultList();
    }
    
    private Guests findGuests(Guests guests){
        return entityManager.find(Guests.class, guests.getGuestId());
    }
    
    @PreDestroy
    public void destroy(){
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    @Override
    public Guests removeGuests(Guests guests) {
        assert (entityManager != null);
        if (findGuests(guests) != null) {
            Guests g = entityManager.merge(guests);
            entityManager.remove(g);
            return guests;
        }
        return null;
    }

    @Override
    public Guests createGuests(Guests newGuests) {
        assert (entityManager != null);
        if (findGuests(newGuests)== null) {
            entityManager.persist(newGuests);
            return newGuests;
        }
        return null;
    }

    @Override
    public Guests updateGuests(Guests newGuests) {
        assert (entityManager != null);
        if (findGuests(newGuests)!= null) {
            return entityManager.merge(newGuests);
        }
        return null;
    }
}
