/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Remy
 */
@Entity
@Table(name = "APARTMENT_FACILITIES")
@NamedQueries({
    @NamedQuery(name = "ApartmentFacilities.findAll", query = "SELECT a FROM ApartmentFacilities a"),
    @NamedQuery(name = "ApartmentFacilities.update", query = "UPDATE ApartmentFacilities a SET a.apartmentFacilitiesPK.aptId=:newAptId, "
            + "a.apartmentFacilitiesPK.facilityCode=:newFacilityCode "
            + "WHERE a.apartmentFacilitiesPK.aptId=:oldAptId AND a.apartmentFacilitiesPK.facilityCode=:oldFacilityCode")
})
public class ApartmentFacilities implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private ApartmentFacilitiesPK apartmentFacilitiesPK;

    public ApartmentFacilitiesPK getApartmentFacilitiesPK() {
        return apartmentFacilitiesPK;
    }

    public void setApartmentFacilitiesPK(ApartmentFacilitiesPK newApartmentFacilitiesPK) {
        apartmentFacilitiesPK = newApartmentFacilitiesPK;
    }
    
    @JoinColumn(name = "APT_ID", referencedColumnName = "APT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Apartments apartments;

    public Apartments getApartments() {
        return apartments;
    }

    public void setApartments(Apartments newApartments) {
        apartments = newApartments;
    }
    
    @JoinColumn(name = "FACILITY_CODE", referencedColumnName = "FACILITY_CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RefApartmentFacilities refApartmentFacilities;

    public RefApartmentFacilities getRefApartmentFacilities() {
        return refApartmentFacilities;
    }

    public void setRefApartmentFacilities(RefApartmentFacilities newRefApartmentFacilities) {
        refApartmentFacilities = newRefApartmentFacilities;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apartmentFacilitiesPK != null ? apartmentFacilitiesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ApartmentFacilities)) {
            return false;
        } else {
            ApartmentFacilities other = (ApartmentFacilities) object;
            if ((apartmentFacilitiesPK == null && other.apartmentFacilitiesPK != null) || (apartmentFacilitiesPK != null && !apartmentFacilitiesPK.equals(other.apartmentFacilitiesPK))) {
                return false;
            }
        }
        return true;
    }
   
    @Override
    public String toString() {
        return apartmentFacilitiesPK.toString();
    }

    public ApartmentFacilities() {
        apartmentFacilitiesPK = new ApartmentFacilitiesPK();
    }

    public ApartmentFacilities(ApartmentFacilitiesPK newApartmentFacilitiesPK) {
        apartmentFacilitiesPK = newApartmentFacilitiesPK;
    }
    
    public ApartmentFacilities(Integer aptId, String facilityCode) {
        apartmentFacilitiesPK = new ApartmentFacilitiesPK(aptId, facilityCode);
    }    
}
