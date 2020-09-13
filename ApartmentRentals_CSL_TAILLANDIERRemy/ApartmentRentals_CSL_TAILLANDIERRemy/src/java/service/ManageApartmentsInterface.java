/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import persistence.Apartments;

/**
 *
 * @author Remy
 */
@javax.ejb.Local
public interface ManageApartmentsInterface {
    public List<Apartments> getAllApartments();
    public Apartments removeApartments(Apartments apartments);
    public Apartments createApartments(Apartments newApartments);
    public Apartments updateApartments(Apartments newApartments);
}
