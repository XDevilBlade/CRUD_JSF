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
import javax.persistence.ManyToMany;
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
@Table(name = "REF_APARTMENT_FACILITIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefApartmentFacilities.findAll", query = "SELECT r FROM RefApartmentFacilities r")
    , @NamedQuery(name = "RefApartmentFacilities.findByFacilityCode", query = "SELECT r FROM RefApartmentFacilities r WHERE r.facilityCode = :facilityCode")
    , @NamedQuery(name = "RefApartmentFacilities.findByFacilityDescription", query = "SELECT r FROM RefApartmentFacilities r WHERE r.facilityDescription = :facilityDescription")})
public class RefApartmentFacilities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "FACILITY_CODE")
    private String facilityCode;
    @Size(max = 255)
    @Column(name = "FACILITY_DESCRIPTION")
    private String facilityDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refApartmentFacilities")
    private Collection<ApartmentFacilities> apartmentFacilitiesCollection;

    public RefApartmentFacilities() {
    }

    public RefApartmentFacilities(String newFacilityCode) {
        facilityCode = newFacilityCode;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String newFacilityCode) {
        facilityCode = newFacilityCode;
    }

    public String getFacilityDescription() {
        return facilityDescription;
    }

    public void setFacilityDescription(String newFacilityDescription) {
        facilityDescription = newFacilityDescription;
    }

    @XmlTransient
    public Collection<ApartmentFacilities> getApartmentFacilitiesCollection() {
        return apartmentFacilitiesCollection;
    }

    public void setApartmentFacilitiesCollection(Collection<ApartmentFacilities> newApartmentFacilitiesCollection) {
        apartmentFacilitiesCollection = newApartmentFacilitiesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facilityCode != null ? facilityCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefApartmentFacilities)) {
            return false;
        }
        RefApartmentFacilities other = (RefApartmentFacilities) object;
        if ((facilityCode == null && other.facilityCode != null) || (facilityCode != null && !facilityCode.equals(other.facilityCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return facilityCode;
    }
    
}
