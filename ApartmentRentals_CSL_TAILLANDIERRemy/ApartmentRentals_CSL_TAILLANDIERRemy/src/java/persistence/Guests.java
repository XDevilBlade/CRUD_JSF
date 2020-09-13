/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Remy
 */
@Entity
@Table(name = "GUESTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guests.findAll", query = "SELECT g FROM Guests g")
    , @NamedQuery(name = "Guests.findByGuestId", query = "SELECT g FROM Guests g WHERE g.guestId = :guestId")
    , @NamedQuery(name = "Guests.findByGenderCode", query = "SELECT g FROM Guests g WHERE g.genderCode = :genderCode")
    , @NamedQuery(name = "Guests.findByGuestFirstName", query = "SELECT g FROM Guests g WHERE g.guestFirstName = :guestFirstName")
    , @NamedQuery(name = "Guests.findByGuestLastName", query = "SELECT g FROM Guests g WHERE g.guestLastName = :guestLastName")
    , @NamedQuery(name = "Guests.findByDataOfBirth", query = "SELECT g FROM Guests g WHERE g.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Guests.findByOtherGuestDetails", query = "SELECT g FROM Guests g WHERE g.otherGuestDetails = :otherGuestDetails")})
public class Guests implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GUEST_ID")
    private Integer guestId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENDER_CODE")
    private Character genderCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "GUEST_FIRST_NAME")
    private String guestFirstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "GUEST_LAST_NAME")
    private String guestLastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;
    @Size(max = 255)
    @Column(name = "OTHER_GUEST_DETAILS")
    private String otherGuestDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guestId")
    private Collection<ApartmentBookings> apartmentBookingsCollection;

    public Guests() {
    }

    public Guests(Integer newGuestId) {
        guestId = newGuestId;
    }

    public Guests(Integer newGuestId, Character newGenderCode, String newGuestFirstName, String newGuestLastName, String newDateOfBirth) {
        guestId = newGuestId;
        genderCode = newGenderCode;
        guestFirstName = newGuestFirstName;
        guestLastName = newGuestLastName;
        dateOfBirth = newDateOfBirth;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer newGuestId) {
        guestId = newGuestId;
    }

    public Character getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(Character newGenderCode) {
        genderCode = newGenderCode;
    }

    public String getGuestFirstName() {
        return guestFirstName;
    }

    public void setGuestFirstName(String newGuestFirstName) {
        guestFirstName = newGuestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public void setGuestLastName(String newGuestLastName) {
        guestLastName = newGuestLastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String newDateOfBirth) {
        dateOfBirth = newDateOfBirth;
    }

    public String getOtherGuestDetails() {
        return otherGuestDetails;
    }

    public void setOtherGuestDetails(String newOtherGuestDetails) {
        otherGuestDetails = newOtherGuestDetails;
    }

    @XmlTransient
    public Collection<ApartmentBookings> getApartmentBookingsCollection() {
        return apartmentBookingsCollection;
    }

    public void setApartmentBookingsCollection(Collection<ApartmentBookings> newApartmentBookingsCollection) {
        apartmentBookingsCollection = newApartmentBookingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guestId != null ? guestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guests)) {
            return false;
        }
        Guests other = (Guests) object;
        if ((guestId == null && other.guestId != null) || (guestId != null && !guestId.equals(other.guestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return guestId.toString();
    }
    
}
