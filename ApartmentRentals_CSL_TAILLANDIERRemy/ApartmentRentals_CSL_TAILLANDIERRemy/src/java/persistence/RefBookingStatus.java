/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Remy
 */
@Entity
@Table(name = "REF_BOOKING_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefBookingStatus.findAll", query = "SELECT r FROM RefBookingStatus r")
    , @NamedQuery(name = "RefBookingStatus.findByBookingStatusCode", query = "SELECT r FROM RefBookingStatus r WHERE r.bookingStatusCode = :bookingStatusCode")
    , @NamedQuery(name = "RefBookingStatus.findByBookingStatusDescription", query = "SELECT r FROM RefBookingStatus r WHERE r.bookingStatusDescription = :bookingStatusDescription")})
public class RefBookingStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "BOOKING_STATUS_CODE")
    private String bookingStatusCode;
    @Size(max = 255)
    @Column(name = "BOOKING_STATUS_DESCRIPTION")
    private String bookingStatusDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingStatusCode")
    private Collection<ApartmentBookings> apartmentBookingsCollection;

    public RefBookingStatus() {
    }

    public RefBookingStatus(String newBookingStatusCode) {
        bookingStatusCode = newBookingStatusCode;
    }

    public String getBookingStatusCode() {
        return bookingStatusCode;
    }

    public void setBookingStatusCode(String newBookingStatusCode) {
        bookingStatusCode = newBookingStatusCode;
    }

    public String getBookingStatusDescription() {
        return bookingStatusDescription;
    }

    public void setBookingStatusDescription(String newBookingStatusDescription) {
        bookingStatusDescription = newBookingStatusDescription;
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
        hash += (bookingStatusCode != null ? bookingStatusCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefBookingStatus)) {
            return false;
        }
        RefBookingStatus other = (RefBookingStatus) object;
        if ((bookingStatusCode == null && other.bookingStatusCode != null) || (bookingStatusCode != null && !bookingStatusCode.equals(other.bookingStatusCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return bookingStatusCode;
    }
    
}
