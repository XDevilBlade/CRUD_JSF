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
import persistence.Apartments;

/**
 *
 * @author Remy
 */
@javax.ejb.Stateless(mappedName = "My_ManageApartments")
public class ManageApartments implements ManageApartmentsInterface{
    
    @PersistenceContext(unitName = "ApartmentRentals_CSL_TAILLANDIERRemyPU")
    private EntityManager entityManager = null; 

    @Override
    public List<Apartments> getAllApartments() {
        assert (entityManager != null);
        return entityManager.createNamedQuery("Apartments.findAll").getResultList();
    }
    
    private Apartments findApartments(Apartments apartments){
        return entityManager.find(Apartments.class, apartments.getAptId());
    }
    
    @PreDestroy
    public void destroy(){
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    @Override
    public Apartments removeApartments(Apartments apartments) {
        assert (entityManager != null);
        if (findApartments(apartments) != null) {
            Apartments a = entityManager.merge(apartments);
            entityManager.remove(a);
            return apartments;
        }
        return null;
    }

    @Override
    public Apartments createApartments(Apartments newApartments) {
        assert (entityManager != null);
        if (findApartments(newApartments)== null) {
           entityManager.persist(newApartments);
            return newApartments; 
        }
        return null;
    }

    @Override
    public Apartments updateApartments(Apartments newApartments) {
        assert (entityManager != null);
        if (findApartments(newApartments)!= null) {
            return entityManager.merge(newApartments);
        }
        return null;
    }
}
