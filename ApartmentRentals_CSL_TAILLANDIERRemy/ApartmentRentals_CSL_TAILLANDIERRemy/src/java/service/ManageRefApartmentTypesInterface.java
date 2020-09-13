/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import persistence.RefApartmentTypes;

/**
 *
 * @author Remy
 */
@javax.ejb.Local
public interface ManageRefApartmentTypesInterface {
    public List<RefApartmentTypes> getAllRefApartmentTypes();
    public RefApartmentTypes removeRefApartmentTypes(RefApartmentTypes refApartmentTypes);
    public RefApartmentTypes createRefApartmentTypes(RefApartmentTypes newRefApartmentTypes);
    public RefApartmentTypes updateRefApartmentTypes(RefApartmentTypes newRefApartmentTypes);
}
