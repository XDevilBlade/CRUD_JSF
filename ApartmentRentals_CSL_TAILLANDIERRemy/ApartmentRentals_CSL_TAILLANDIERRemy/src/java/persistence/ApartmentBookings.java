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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "APARTMENT_BOOKINGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApartmentBookings.findAll", query = "SELECT a FROM ApartmentBookings a")
    , @NamedQuery(name = "ApartmentBookings.findByAptBookingId", query = "SELECT a FROM ApartmentBookings a WHERE a.aptBookingId = :aptBookingId")
    , @NamedQuery(name = "ApartmentBookings.findByBookingStartDate", query = "SELECT a FROM ApartmentBookings a WHERE a.bookingStartDate = :bookingStartDate")
    , @NamedQuery(name = "ApartmentBookings.findByBookingEndDate", query = "SELECT a FROM ApartmentBookings a WHERE a.bookingEndDate = :bookingEndDate")
    , @NamedQuery(name = "ApartmentBookings.findByOtherBookingDetails", query = "SELECT a FROM ApartmentBookings a WHERE a.otherBookingDetails = :otherBookingDetails")})
public class ApartmentBookings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "APT_BOOKING_ID")
    private Integer aptBookingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKING_START_DATE")
    private String bookingStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKING_END_DATE")
    private String bookingEndDate;
    @Size(max = 255)
    @Column(name = "OTHER_BOOKING_DETAILS")
    private String otherBookingDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aptBookingId")
    private Collection<ViewUnitStatus> viewUnitStatusCollection;
    @JoinColumn(name = "APT_ID", referencedColumnName = "APT_ID")
    @ManyToOne(optional = false)
    private Apartments aptId;
    @JoinColumn(name = "GUEST_ID", referencedColumnName = "GUEST_ID")
    @ManyToOne(optional = false)
    private Guests guestId;
    @JoinColumn(name = "BOOKING_STATUS_CODE", referencedColumnName = "BOOKING_STATUS_CODE")
    @ManyToOne(optional = false)
    private RefBookingStatus bookingStatusCode;

    public ApartmentBookings() {
    }

    public ApartmentBookings(Integer newAptBookingId) {
        aptBookingId = newAptBookingId;
    }

    public ApartmentBookings(Integer newAptBookingId, String newBookingStartDate, String newBookingEndDate) {
        aptBookingId = newAptBookingId;
        bookingStartDate = newBookingStartDate;
        bookingEndDate = newBookingEndDate;
    }

    public Integer getAptBookingId() {
        return aptBookingId;
    }

    public void setAptBookingId(Integer newAptBookingId) {
        aptBookingId = newAptBookingId;
    }

    public String getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(String newBookingStartDate) {
        bookingStartDate = newBookingStartDate;
    }

    public String getBookingEndDate() {
        return bookingEndDate;
    }

    public void setBookingEndDate(String newBookingEndDate) {
        bookingEndDate = newBookingEndDate;
    }

    public String getOtherBookingDetails() {
        return otherBookingDetails;
    }

    public void setOtherBookingDetails(String newOtherBookingDetails) {
        otherBookingDetails = newOtherBookingDetails;
    }

    @XmlTransient
    public Collection<ViewUnitStatus> getViewUnitStatusCollection() {
        return viewUnitStatusCollection;
    }

    public void setViewUnitStatusCollection(Collection<ViewUnitStatus> newViewUnitStatusCollection) {
        viewUnitStatusCollection = newViewUnitStatusCollection;
    }

    public Apartments getAptId() {
        return aptId;
    }

    public void setAptId(Apartments newAptId) {
        aptId = newAptId;
    }

    public Guests getGuestId() {
        return guestId;
    }

    public void setGuestId(Guests newGuestId) {
        guestId = newGuestId;
    }

    public RefBookingStatus getBookingStatusCode() {
        return bookingStatusCode;
    }

    public void setBookingStatusCode(RefBookingStatus newBookingStatusCode) {
        bookingStatusCode = newBookingStatusCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aptBookingId != null ? aptBookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApartmentBookings)) {
            return false;
        }
        ApartmentBookings other = (ApartmentBookings) object;
        if ((aptBookingId == null && other.aptBookingId != null) || (aptBookingId != null && !aptBookingId.equals(other.aptBookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return aptBookingId.toString();
    }
    
}
