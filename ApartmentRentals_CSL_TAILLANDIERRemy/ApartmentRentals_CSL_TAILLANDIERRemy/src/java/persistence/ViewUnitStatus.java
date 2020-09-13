/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Remy
 */
@Entity
@Table(name = "VIEW_UNIT_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewUnitStatus.findAll", query = "SELECT v FROM ViewUnitStatus v")
    , @NamedQuery(name = "ViewUnitStatus.findByStatusDate", query = "SELECT v FROM ViewUnitStatus v WHERE v.statusDate = :statusDate")
    , @NamedQuery(name = "ViewUnitStatus.findByAvailableYn", query = "SELECT v FROM ViewUnitStatus v WHERE v.availableYn = :availableYn")})
public class ViewUnitStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "STATUS_DATE")
    private String statusDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AVAILABLE_YN")
    private Character availableYn;
    @JoinColumn(name = "APT_ID", referencedColumnName = "APT_ID")
    @ManyToOne(optional = false)
    private Apartments aptId;
    @JoinColumn(name = "APT_BOOKING_ID", referencedColumnName = "APT_BOOKING_ID")
    @ManyToOne(optional = false)
    private ApartmentBookings aptBookingId;

    public ViewUnitStatus() {
    }

    public ViewUnitStatus(String newStatusDate) {
        statusDate = newStatusDate;
    }

    public ViewUnitStatus(String newStatusDate, Character newAvailableYn) {
        statusDate = newStatusDate;
        availableYn = newAvailableYn;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String newStatusDate) {
        statusDate = newStatusDate;
    }

    public Character getAvailableYn() {
        return availableYn;
    }

    public void setAvailableYn(Character newAvailableYn) {
        availableYn = newAvailableYn;
    }

    public Apartments getAptId() {
        return aptId;
    }

    public void setAptId(Apartments newAptId) {
        aptId = newAptId;
    }

    public ApartmentBookings getAptBookingId() {
        return aptBookingId;
    }

    public void setAptBookingId(ApartmentBookings newAptBookingId) {
        aptBookingId = newAptBookingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusDate != null ? statusDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewUnitStatus)) {
            return false;
        }
        ViewUnitStatus other = (ViewUnitStatus) object;
        if ((statusDate == null && other.statusDate != null) || (statusDate != null && !statusDate.equals(other.statusDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return statusDate.toString();
    }
    
}
