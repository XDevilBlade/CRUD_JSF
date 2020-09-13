/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import persistence.Guests;

/**
 *
 * @author Remy
 */
@javax.ejb.Local
public interface ManageGuestsInterface {
    public List<Guests> getAllGuests();
    public Guests removeGuests(Guests guests);
    public Guests createGuests(Guests newGuests);
    public Guests updateGuests(Guests newGuests);
}
