/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.ViewUnitStatus;

/**
 *
 * @author Remy
 */
@javax.ejb.Stateless(mappedName = "My_ManageViewUnitStatus")
public class ManageViewUnitStatus implements ManageViewUnitStatusInterface{
    
    @PersistenceContext(unitName = "ApartmentRentals_CSL_TAILLANDIERRemyPU")
    private EntityManager entityManager = null; 

    @Override
    public List<ViewUnitStatus> getAllViewUnitStatus() {
        assert (entityManager != null);
        return entityManager.createNamedQuery("ViewUnitStatus.findAll").getResultList();
    }

    private ViewUnitStatus findViewUnitStatus(ViewUnitStatus viewUnitStatus){
        return entityManager.find(ViewUnitStatus.class, viewUnitStatus.getStatusDate());
    }
    
    
    @PreDestroy
    public void destroy(){
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    @Override
    public ViewUnitStatus removeViewUnitStatus(ViewUnitStatus viewUnitStatus) {
        assert (entityManager != null);
        if (findViewUnitStatus(viewUnitStatus) != null) {
            ViewUnitStatus vus = entityManager.merge(viewUnitStatus);
            entityManager.remove(vus);
            return viewUnitStatus;
        }
        return null;
    }

    @Override
    public ViewUnitStatus createViewUnitStatus(ViewUnitStatus newViewUnitStatus) {
        assert (entityManager != null);
        if (findViewUnitStatus(newViewUnitStatus)== null) {
            entityManager.persist(newViewUnitStatus);
            return newViewUnitStatus;
        }
        return null;
    }

    @Override
    public ViewUnitStatus updateViewUnitStatus(ViewUnitStatus newViewUnitStatus) {
        assert (entityManager != null);
        if (findViewUnitStatus(newViewUnitStatus)!= null) {
            return entityManager.merge(newViewUnitStatus);
        }
        return null;
    }
    
}
