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
import javax.persistence.Query;
import persistence.ApartmentFacilities;


/**
 *
 * @author Remy
 */
@javax.ejb.Stateless(mappedName = "My_ManageApartmentFacilities")
public class ManageApartmentFacilities implements ManageApartmentFacilitiesInterface{
    
    @PersistenceContext(unitName = "ApartmentRentals_CSL_TAILLANDIERRemyPU")
    private EntityManager entityManager = null; 

    @Override
    public List<ApartmentFacilities> getAllApartmentFacilities() {
        assert (entityManager != null);
        return entityManager.createNamedQuery("ApartmentFacilities.findAll").getResultList();
    }
    
    private ApartmentFacilities findApartmentFacilities(ApartmentFacilities apartmentFacilities){
        return entityManager.find(ApartmentFacilities.class, apartmentFacilities.getApartmentFacilitiesPK());
    }
    
    @Override
    public ApartmentFacilities removeApartmentFacilities(ApartmentFacilities apartmentFacilities) {
        assert (entityManager != null);
        if (findApartmentFacilities(apartmentFacilities) != null) {
            ApartmentFacilities af = entityManager.merge(apartmentFacilities);
            entityManager.remove(af);
            return apartmentFacilities;
        }
        return null;
    }
    
    @PreDestroy
    public void destroy(){
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    @Override
    public ApartmentFacilities createApartmentFacilities(ApartmentFacilities newApartmentFacilities) {
        assert (entityManager != null);
        if (findApartmentFacilities(newApartmentFacilities)== null) {
            entityManager.persist(newApartmentFacilities);
            return newApartmentFacilities;
        }
        return null;
        
    }

    @Override
    public String updateApartmentFacilities(Integer oldAptId, String oldFacilityCode, Integer newdAptId, String newFacilityCode) {
        assert (entityManager != null);
        //Si l'ApartmentFacilities que l'on souhaite modifier existe dans la table alors
        if (findApartmentFacilities(new ApartmentFacilities(oldAptId, oldFacilityCode))!= null) {
            //Si l'on souhaite modifier l'ApartmentFacilities avec les données qu'il possede deja
            if ((oldAptId.equals(newdAptId)) && (oldFacilityCode.equals(newFacilityCode))) {
                return "updated";
            }
            //Si l'on souhaite modifier l'ApartmentFacilities avec des donnees qui n'existent pas encore dans la table
            if (findApartmentFacilities(new ApartmentFacilities(newdAptId, newFacilityCode))== null) {
                Query query = entityManager.createNamedQuery("ApartmentFacilities.update");
                query.setParameter("oldAptId", oldAptId);
                query.setParameter("oldFacilityCode", oldFacilityCode);
                query.setParameter("newAptId", newdAptId);
                query.setParameter("newFacilityCode", newFacilityCode);
                int numberLaneChange = query.executeUpdate();
                if (numberLaneChange==1) {
                   return "updated";
                } 
            }
            //Sinon il y a un doublon de cle primaire 
            else{
                return "doublonPrimaryKey";
            }
        }
        //Sinon l'ApartmentFacilities que l'on souhaite modifier n'existe plus dans la table
        return "notExist"; 
    }

    

    
}
