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
import persistence.RefApartmentTypes;

/**
 *
 * @author Remy
 */
@javax.ejb.Stateless(mappedName = "My_ManageRefApartmentTypes")
public class ManageRefApartmentTypes implements ManageRefApartmentTypesInterface{
    
    @PersistenceContext(unitName = "ApartmentRentals_CSL_TAILLANDIERRemyPU")
    private EntityManager entityManager = null; 

    @Override
    public List<RefApartmentTypes> getAllRefApartmentTypes() {
        assert (entityManager != null);
        return entityManager.createNamedQuery("RefApartmentTypes.findAll").getResultList();
    }
    
    private RefApartmentTypes findRefApartmentTypes(RefApartmentTypes refApartmentTypes){
        return entityManager.find(RefApartmentTypes.class, refApartmentTypes.getAptTypeCode());
    }
    
    @PreDestroy
    public void destroy(){
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    @Override
    public RefApartmentTypes removeRefApartmentTypes(RefApartmentTypes refApartmentTypes) {
        assert (entityManager != null);
        if (findRefApartmentTypes(refApartmentTypes) != null) {
            RefApartmentTypes rat = entityManager.merge(refApartmentTypes);
            entityManager.remove(rat);
            return refApartmentTypes;
        }
        return null;
    }

    @Override
    public RefApartmentTypes createRefApartmentTypes(RefApartmentTypes newRefApartmentTypes) {
        assert (entityManager != null);
        if (findRefApartmentTypes(newRefApartmentTypes)== null) {
            entityManager.persist(newRefApartmentTypes);
            return newRefApartmentTypes;
        }
        return null;
    }

    @Override
    public RefApartmentTypes updateRefApartmentTypes(RefApartmentTypes newRefApartmentTypes) {
        assert (entityManager != null);
        if (findRefApartmentTypes(newRefApartmentTypes)!= null) {
            return entityManager.merge(newRefApartmentTypes);
        }
        return null;
    }
}
