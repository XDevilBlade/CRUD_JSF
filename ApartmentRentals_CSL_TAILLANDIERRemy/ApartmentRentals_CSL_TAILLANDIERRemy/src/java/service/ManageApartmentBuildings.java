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
import persistence.ApartmentBuildings;

/**
 *
 * @author Remy
 */
@javax.ejb.Stateless(mappedName = "My_ManageApartmentBuildings")
public class ManageApartmentBuildings implements ManageApartmentBuildingsInterface{
    
    @PersistenceContext(unitName = "ApartmentRentals_CSL_TAILLANDIERRemyPU")
    private EntityManager entityManager = null; 

    @Override
    public List<ApartmentBuildings> getAllApartmentBuildings() {
        assert (entityManager != null);
        return entityManager.createNamedQuery("ApartmentBuildings.findAll").getResultList();
    }

    private ApartmentBuildings findApartmentBuildings(ApartmentBuildings apartmentBuildings){
        return entityManager.find(ApartmentBuildings.class, apartmentBuildings.getBuildingId());
    }
    
    @PreDestroy
    public void destroy(){
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    @Override
    public ApartmentBuildings removeApartmentBuildings(ApartmentBuildings apartmentBuildings) {
        assert (entityManager != null);
        if (findApartmentBuildings(apartmentBuildings) != null) {
            ApartmentBuildings ab = entityManager.merge(apartmentBuildings);
            entityManager.remove(ab);
            return apartmentBuildings;
        }
        return null;
    }

    @Override
    public ApartmentBuildings createApartmentBuildings(ApartmentBuildings newApartmentBuildings) {
        assert (entityManager != null);
        if (findApartmentBuildings(newApartmentBuildings)== null) {
            entityManager.persist(newApartmentBuildings);
            return newApartmentBuildings;
        }
        return null;
    }

    @Override
    public ApartmentBuildings updateApartmentBuildings(ApartmentBuildings newApartmentBuildings) {
        assert (entityManager != null);
        if (findApartmentBuildings(newApartmentBuildings)!= null) {
            return entityManager.merge(newApartmentBuildings);
        }
        return null;
    }
}
