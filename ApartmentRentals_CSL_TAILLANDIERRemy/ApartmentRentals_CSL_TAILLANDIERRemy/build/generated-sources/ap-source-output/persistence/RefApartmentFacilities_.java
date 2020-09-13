package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.ApartmentFacilities;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-10-24T19:25:46")
@StaticMetamodel(RefApartmentFacilities.class)
public class RefApartmentFacilities_ { 

    public static volatile SingularAttribute<RefApartmentFacilities, String> facilityCode;
    public static volatile CollectionAttribute<RefApartmentFacilities, ApartmentFacilities> apartmentFacilitiesCollection;
    public static volatile SingularAttribute<RefApartmentFacilities, String> facilityDescription;

}