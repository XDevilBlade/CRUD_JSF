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
import persistence.RefApartmentFacilities;

/**
 *
 * @author Remy
 */
@javax.ejb.Stateless(mappedName = "My_ManageRefApartmentFacilities")
public class ManageRefApartmentFacilities implements ManageRefApartmentFacilitiesInterface{
 
    @PersistenceContext(unitName = "ApartmentRentals_CSL_TAILLANDIERRemyPU")
    private EntityManager entityManager = null; 

    @Override
    public List<RefApartmentFacilities> getAllRefApartmentFacilities() {
        assert (entityManager != null);
        return entityManager.createNamedQuery("RefApartmentFacilities.findAll").getResultList();
    }
    
    private RefApartmentFacilities findRefApartmentFacilities(RefApartmentFacilities refApartmentFacilities){
        return entityManager.find(RefApartmentFacilities.class, refApartmentFacilities.getFacilityCode());
    }
    
    @PreDestroy
    public void destroy(){
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    @Override
    public RefApartmentFacilities removeRefApartmentFacilities(RefApartmentFacilities refApartmentFacilities) {
        assert (entityManager != null);
        if (findRefApartmentFacilities(refApartmentFacilities) != null) {
            RefApartmentFacilities raf = entityManager.merge(refApartmentFacilities);
            entityManager.remove(raf);
            return refApartmentFacilities;
        }
        return null;
    }

    @Override
    public RefApartmentFacilities createRefApartmentFacilities(RefApartmentFacilities newRefApartmentFacilities) {
        assert (entityManager != null);
        if (findRefApartmentFacilities(newRefApartmentFacilities)== null) {
            entityManager.persist(newRefApartmentFacilities);
            return newRefApartmentFacilities;
        }
        return null;
    }

    @Override
    public RefApartmentFacilities updateRefApartmentFacilities(RefApartmentFacilities newRefApartmentFacilities) {
        assert (entityManager != null);
        if (findRefApartmentFacilities(newRefApartmentFacilities)!= null) {
            return entityManager.merge(newRefApartmentFacilities);
        }
        return null;
    }
}
