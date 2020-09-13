/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import persistence.RefApartmentFacilities;

/**
 *
 * @author Remy
 */
@javax.ejb.Local
public interface ManageRefApartmentFacilitiesInterface {
    public List<RefApartmentFacilities> getAllRefApartmentFacilities();
    public RefApartmentFacilities removeRefApartmentFacilities(RefApartmentFacilities refApartmentFacilities);
    public RefApartmentFacilities createRefApartmentFacilities(RefApartmentFacilities newRefApartmentFacilities);
    public RefApartmentFacilities updateRefApartmentFacilities(RefApartmentFacilities newRefApartmentFacilities);
}
