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
@Table(name = "REF_APARTMENT_TYPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefApartmentTypes.findAll", query = "SELECT r FROM RefApartmentTypes r")
    , @NamedQuery(name = "RefApartmentTypes.findByAptTypeCode", query = "SELECT r FROM RefApartmentTypes r WHERE r.aptTypeCode = :aptTypeCode")
    , @NamedQuery(name = "RefApartmentTypes.findByAptTypeDescription", query = "SELECT r FROM RefApartmentTypes r WHERE r.aptTypeDescription = :aptTypeDescription")})
public class RefApartmentTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "APT_TYPE_CODE")
    private String aptTypeCode;
    @Size(max = 255)
    @Column(name = "APT_TYPE_DESCRIPTION")
    private String aptTypeDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aptTypeCode")
    private Collection<Apartments> apartmentsCollection;

    public RefApartmentTypes() {
    }

    public RefApartmentTypes(String newAptTypeCode) {
        aptTypeCode = newAptTypeCode;
    }

    public String getAptTypeCode() {
        return aptTypeCode;
    }

    public void setAptTypeCode(String newAptTypeCode) {
        aptTypeCode = newAptTypeCode;
    }

    public String getAptTypeDescription() {
        return aptTypeDescription;
    }

    public void setAptTypeDescription(String newAptTypeDescription) {
        aptTypeDescription = newAptTypeDescription;
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
        hash += (aptTypeCode != null ? aptTypeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefApartmentTypes)) {
            return false;
        }
        RefApartmentTypes other = (RefApartmentTypes) object;
        if ((aptTypeCode == null && other.aptTypeCode != null) || (aptTypeCode != null && !aptTypeCode.equals(other.aptTypeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return aptTypeCode;
    }
    
}
