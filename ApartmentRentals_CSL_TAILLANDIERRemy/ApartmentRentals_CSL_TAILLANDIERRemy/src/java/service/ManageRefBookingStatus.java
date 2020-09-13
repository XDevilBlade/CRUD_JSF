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
import persistence.RefBookingStatus;

/**
 *
 * @author Remy
 */
@javax.ejb.Stateless(mappedName = "My_ManageRefBookingStatus")
public class ManageRefBookingStatus implements ManageRefBookingStatusInterface{
    
    @PersistenceContext(unitName = "ApartmentRentals_CSL_TAILLANDIERRemyPU")
    private EntityManager entityManager = null; 

    @Override
    public List<RefBookingStatus> getAllRefBookingStatus() {
        assert (entityManager != null);
        return entityManager.createNamedQuery("RefBookingStatus.findAll").getResultList();
    }
    
    private RefBookingStatus findRefBookingStatus(RefBookingStatus refBookingStatus){
        return entityManager.find(RefBookingStatus.class, refBookingStatus.getBookingStatusCode());
    }
    
    @PreDestroy
    public void destroy(){
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    @Override
    public RefBookingStatus removeRefBookingStatus(RefBookingStatus refBookingStatus) {
        assert (entityManager != null);
        if (findRefBookingStatus(refBookingStatus)!= null) {
            RefBookingStatus rbs = entityManager.merge(refBookingStatus);
            entityManager.remove(rbs);
            return refBookingStatus;
        }
        return null;
    }

    @Override
    public RefBookingStatus createRefBookingStatus(RefBookingStatus newRefBookingStatus) {
        assert (entityManager != null);
        if (findRefBookingStatus(newRefBookingStatus)== null) {
            entityManager.persist(newRefBookingStatus);
            return newRefBookingStatus;
        }
        return null;
    }

    @Override
    public RefBookingStatus updateRefBookingStatus(RefBookingStatus newRefBookingStatus) {
        assert (entityManager != null);
        if (findRefBookingStatus(newRefBookingStatus)!= null) {
            return entityManager.merge(newRefBookingStatus);
        }
        return null;
    }
}
