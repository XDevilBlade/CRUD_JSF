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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "APARTMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apartments.findAll", query = "SELECT a FROM Apartments a")
    , @NamedQuery(name = "Apartments.findByAptId", query = "SELECT a FROM Apartments a WHERE a.aptId = :aptId")
    , @NamedQuery(name = "Apartments.findByAptNumber", query = "SELECT a FROM Apartments a WHERE a.aptNumber = :aptNumber")
    , @NamedQuery(name = "Apartments.findByBathroomCount", query = "SELECT a FROM Apartments a WHERE a.bathroomCount = :bathroomCount")
    , @NamedQuery(name = "Apartments.findByBedroomCount", query = "SELECT a FROM Apartments a WHERE a.bedroomCount = :bedroomCount")
    , @NamedQuery(name = "Apartments.findByRoomCount", query = "SELECT a FROM Apartments a WHERE a.roomCount = :roomCount")
    , @NamedQuery(name = "Apartments.findByOtherApartmentDetails", query = "SELECT a FROM Apartments a WHERE a.otherApartmentDetails = :otherApartmentDetails")})
public class Apartments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "APT_ID")
    private Integer aptId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "APT_NUMBER")
    private String aptNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BATHROOM_COUNT")
    private int bathroomCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BEDROOM_COUNT")
    private int bedroomCount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ROOM_COUNT")
    private String roomCount;
    @Size(max = 255)
    @Column(name = "OTHER_APARTMENT_DETAILS")
    private String otherApartmentDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apartments")
    private Collection<ApartmentFacilities> apartmentFacilitiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aptId")
    private Collection<ViewUnitStatus> viewUnitStatusCollection;
    @JoinColumn(name = "BUILDING_ID", referencedColumnName = "BUILDING_ID")
    @ManyToOne(optional = false)
    private ApartmentBuildings buildingId;
    @JoinColumn(name = "APT_TYPE_CODE", referencedColumnName = "APT_TYPE_CODE")
    @ManyToOne(optional = false)
    private RefApartmentTypes aptTypeCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aptId")
    private Collection<ApartmentBookings> apartmentBookingsCollection;

    public Apartments() {
    }

    public Apartments(Integer newAptId) {
        aptId = newAptId;
    }

    public Apartments(Integer newAptId, String newAptNumber, int newBathroomCount, int newBedroomCount, String newRoomCount) {
        aptId = newAptId;
        aptNumber = newAptNumber;
        bathroomCount = newBathroomCount;
        bedroomCount = newBedroomCount;
        roomCount = newRoomCount;
    }

    public Integer getAptId() {
        return aptId;
    }

    public void setAptId(Integer newAptId) {
        aptId = newAptId;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(String newAptNumber) {
        aptNumber = newAptNumber;
    }

    public int getBathroomCount() {
        return bathroomCount;
    }

    public void setBathroomCount(int newBathroomCount) {
        bathroomCount = newBathroomCount;
    }

    public int getBedroomCount() {
        return bedroomCount;
    }

    public void setBedroomCount(int newBedroomCount) {
        bedroomCount = newBedroomCount;
    }

    public String getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(String newRoomCount) {
        roomCount = newRoomCount;
    }

    public String getOtherApartmentDetails() {
        return otherApartmentDetails;
    }

    public void setOtherApartmentDetails(String newOtherApartmentDetails) {
        otherApartmentDetails = newOtherApartmentDetails;
    }

    @XmlTransient
    public Collection<ApartmentFacilities> getApartmentFacilitiesCollection() {
        return apartmentFacilitiesCollection;
    }

    public void setApartmentFacilitiesCollection(Collection<ApartmentFacilities> newApartmentFacilitiesCollection) {
        apartmentFacilitiesCollection = newApartmentFacilitiesCollection;
    }

    

    @XmlTransient
    public Collection<ViewUnitStatus> getViewUnitStatusCollection() {
        return viewUnitStatusCollection;
    }

    public void setViewUnitStatusCollection(Collection<ViewUnitStatus> newViewUnitStatusCollection) {
        viewUnitStatusCollection = newViewUnitStatusCollection;
    }

    public ApartmentBuildings getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(ApartmentBuildings newBuildingId) {
        buildingId = newBuildingId;
    }

    public RefApartmentTypes getAptTypeCode() {
        return aptTypeCode;
    }

    public void setAptTypeCode(RefApartmentTypes newAptTypeCode) {
        aptTypeCode = newAptTypeCode;
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
        hash += (aptId != null ? aptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apartments)) {
            return false;
        }
        Apartments other = (Apartments) object;
        if ((aptId == null && other.aptId != null) || (aptId != null && !aptId.equals(other.aptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return aptId.toString();
    }
    
}
