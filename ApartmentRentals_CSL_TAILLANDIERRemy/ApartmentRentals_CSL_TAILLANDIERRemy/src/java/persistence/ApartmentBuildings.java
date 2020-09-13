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
@Table(name = "APARTMENT_BUILDINGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApartmentBuildings.findAll", query = "SELECT a FROM ApartmentBuildings a")
    , @NamedQuery(name = "ApartmentBuildings.findByBuildingId", query = "SELECT a FROM ApartmentBuildings a WHERE a.buildingId = :buildingId")
    , @NamedQuery(name = "ApartmentBuildings.findByBuildingShortName", query = "SELECT a FROM ApartmentBuildings a WHERE a.buildingShortName = :buildingShortName")
    , @NamedQuery(name = "ApartmentBuildings.findByBuildingFullName", query = "SELECT a FROM ApartmentBuildings a WHERE a.buildingFullName = :buildingFullName")
    , @NamedQuery(name = "ApartmentBuildings.findByBuildingDescription", query = "SELECT a FROM ApartmentBuildings a WHERE a.buildingDescription = :buildingDescription")
    , @NamedQuery(name = "ApartmentBuildings.findByBuildingAddress", query = "SELECT a FROM ApartmentBuildings a WHERE a.buildingAddress = :buildingAddress")
    , @NamedQuery(name = "ApartmentBuildings.findByBuildingManager", query = "SELECT a FROM ApartmentBuildings a WHERE a.buildingManager = :buildingManager")
    , @NamedQuery(name = "ApartmentBuildings.findByBuildingPhone", query = "SELECT a FROM ApartmentBuildings a WHERE a.buildingPhone = :buildingPhone")
    , @NamedQuery(name = "ApartmentBuildings.findByOtherBuildingDetails", query = "SELECT a FROM ApartmentBuildings a WHERE a.otherBuildingDetails = :otherBuildingDetails")})
public class ApartmentBuildings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUILDING_ID")
    private Integer buildingId;
    @Size(max = 15)
    @Column(name = "BUILDING_SHORT_NAME")
    private String buildingShortName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "BUILDING_FULL_NAME")
    private String buildingFullName;
    @Size(max = 255)
    @Column(name = "BUILDING_DESCRIPTION")
    private String buildingDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "BUILDING_ADDRESS")
    private String buildingAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BUILDING_MANAGER")
    private String buildingManager;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "BUILDING_PHONE")
    private String buildingPhone;
    @Size(max = 255)
    @Column(name = "OTHER_BUILDING_DETAILS")
    private String otherBuildingDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buildingId")
    private Collection<Apartments> apartmentsCollection;

    public ApartmentBuildings() {
    }

    public ApartmentBuildings(Integer newBuildingId) {
        buildingId = newBuildingId;
    }

    public ApartmentBuildings(Integer newBuildingId, String newBuildingFullName, String newBuildingAddress, String newBuildingManager, String newBuildingPhone) {
        buildingId = newBuildingId;
        buildingFullName = newBuildingFullName;
        buildingAddress = newBuildingAddress;
        buildingManager = newBuildingManager;
        buildingPhone = newBuildingPhone;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer newBuildingId) {
        buildingId = newBuildingId;
    }

    public String getBuildingShortName() {
        return buildingShortName;
    }

    public void setBuildingShortName(String newBuildingShortName) {
        buildingShortName = newBuildingShortName;
    }

    public String getBuildingFullName() {
        return buildingFullName;
    }

    public void setBuildingFullName(String newBuildingFullName) {
        buildingFullName = newBuildingFullName;
    }

    public String getBuildingDescription() {
        return buildingDescription;
    }

    public void setBuildingDescription(String newBuildingDescription) {
        buildingDescription = newBuildingDescription;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String newBuildingAddress) {
        buildingAddress = newBuildingAddress;
    }

    public String getBuildingManager() {
        return buildingManager;
    }

    public void setBuildingManager(String newBuildingManager) {
        buildingManager = newBuildingManager;
    }

    public String getBuildingPhone() {
        return buildingPhone;
    }

    public void setBuildingPhone(String newBuildingPhone) {
        buildingPhone = newBuildingPhone;
    }

    public String getOtherBuildingDetails() {
        return otherBuildingDetails;
    }

    public void setOtherBuildingDetails(String newOtherBuildingDetails) {
        otherBuildingDetails = newOtherBuildingDetails;
    }

    @XmlTransient
    public Collection<Apartments> getApartmentsCollection() {
        return apartmentsCollection;
    }

    public void setApartmentsCollection(Collection<Apartments> newApartmentsCollection) {
        apartmentsCollection = newApartmentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buildingId != null ? buildingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApartmentBuildings)) {
            return false;
        }
        ApartmentBuildings other = (ApartmentBuildings) object;
        if ((buildingId == null && other.buildingId != null) || (buildingId != null && !buildingId.equals(other.buildingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return buildingId.toString();
    }
    
}
