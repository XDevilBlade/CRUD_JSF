/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;
//apt_id INTEGER facility_code CHAR(15)
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Remy
 */
@Embeddable
public class ApartmentFacilitiesPK implements Serializable{
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "APT_ID")
    private Integer aptId;

    public Integer getAptId() {
        return aptId;
    }

    public void setAptId(Integer newAptId) {
        aptId = newAptId;
    }

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "FACILITY_CODE")
    private String facilityCode;

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String newFacilityCode) {
        facilityCode = newFacilityCode;
    }

    public ApartmentFacilitiesPK() {
 
    }

    public ApartmentFacilitiesPK(Integer newAptId, String newFacilityCode) {
        aptId = newAptId;
        facilityCode = newFacilityCode;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aptId != null ? aptId.hashCode() : 0);
        hash += (facilityCode != null ? facilityCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ApartmentFacilitiesPK)) {
            return false;
        } else {
            ApartmentFacilitiesPK other = (ApartmentFacilitiesPK) object;
            if (!aptId.equals(other.aptId) || !facilityCode.equals(other.facilityCode)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return aptId.toString() + '-' + facilityCode;
    }

    public static ApartmentFacilitiesPK To_apartmentFacilitiesPK(String apartmentFacilitiesPK) {
        String pk[] = apartmentFacilitiesPK.split("-");
        return new ApartmentFacilitiesPK(new Integer(pk[0]), pk[1]);
    }
    
}
