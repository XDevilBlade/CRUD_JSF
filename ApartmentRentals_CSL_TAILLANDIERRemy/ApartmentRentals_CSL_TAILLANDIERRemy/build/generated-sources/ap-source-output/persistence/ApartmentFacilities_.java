package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.ApartmentFacilitiesPK;
import persistence.Apartments;
import persistence.RefApartmentFacilities;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-18T16:36:16")
@StaticMetamodel(ApartmentFacilities.class)
public class ApartmentFacilities_ { 

    public static volatile SingularAttribute<ApartmentFacilities, RefApartmentFacilities> refApartmentFacilities;
    public static volatile SingularAttribute<ApartmentFacilities, ApartmentFacilitiesPK> apartmentFacilitiesPK;
    public static volatile SingularAttribute<ApartmentFacilities, Apartments> apartments;

}