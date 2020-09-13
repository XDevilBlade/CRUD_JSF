/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import persistence.ApartmentFacilities;

/**
 *
 * @author Remy
 */
@javax.ejb.Local
public interface ManageApartmentFacilitiesInterface {
    public List<ApartmentFacilities> getAllApartmentFacilities();
    public ApartmentFacilities removeApartmentFacilities(ApartmentFacilities apartmentFacilities);
    public ApartmentFacilities createApartmentFacilities(ApartmentFacilities newApartmentFacilities);
    public String updateApartmentFacilities(Integer oldAptId, String oldFacilityCode, Integer newdAptId, String newFacilityCode);
}
