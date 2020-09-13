package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.ApartmentBookings;
import persistence.ApartmentBuildings;
import persistence.ApartmentFacilities;
import persistence.RefApartmentTypes;
import persistence.ViewUnitStatus;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-10-24T19:20:44")
@StaticMetamodel(Apartments.class)
public class Apartments_ { 

    public static volatile SingularAttribute<Apartments, String> roomCount;
    public static volatile CollectionAttribute<Apartments, ApartmentFacilities> apartmentFacilitiesCollection;
    public static volatile SingularAttribute<Apartments, Integer> bathroomCount;
    public static volatile SingularAttribute<Apartments, RefApartmentTypes> aptTypeCode;
    public static volatile SingularAttribute<Apartments, Integer> bedroomCount;
    public static volatile SingularAttribute<Apartments, String> otherApartmentDetails;
    public static volatile CollectionAttribute<Apartments, ViewUnitStatus> viewUnitStatusCollection;
    public static volatile SingularAttribute<Apartments, Integer> aptId;
    public static volatile SingularAttribute<Apartments, String> aptNumber;
    public static volatile SingularAttribute<Apartments, ApartmentBuildings> buildingId;
    public static volatile CollectionAttribute<Apartments, ApartmentBookings> apartmentBookingsCollection;

}