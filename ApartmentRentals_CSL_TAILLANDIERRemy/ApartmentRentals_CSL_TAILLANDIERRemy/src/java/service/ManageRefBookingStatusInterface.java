/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import persistence.RefBookingStatus;

/**
 *
 * @author Remy
 */
@javax.ejb.Local
public interface ManageRefBookingStatusInterface {
    public List<RefBookingStatus> getAllRefBookingStatus();
    public RefBookingStatus removeRefBookingStatus(RefBookingStatus refBookingStatus);
    public RefBookingStatus createRefBookingStatus(RefBookingStatus newRefBookingStatus);
    public RefBookingStatus updateRefBookingStatus(RefBookingStatus newRefBookingStatus);
}
