/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import persistence.ApartmentBuildings;

/**
 *
 * @author Remy
 */
@javax.ejb.Local
public interface ManageApartmentBuildingsInterface {
    public List<ApartmentBuildings> getAllApartmentBuildings();
    public ApartmentBuildings removeApartmentBuildings(ApartmentBuildings apartmentBuildings);
    public ApartmentBuildings createApartmentBuildings(ApartmentBuildings newApartmentBuildings);
    public ApartmentBuildings updateApartmentBuildings(ApartmentBuildings newApartmentBuildings);
}
