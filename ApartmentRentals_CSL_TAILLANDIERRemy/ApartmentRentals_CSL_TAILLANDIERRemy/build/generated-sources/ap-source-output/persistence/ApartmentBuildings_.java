package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Apartments;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-12T18:26:25")
@StaticMetamodel(ApartmentBuildings.class)
public class ApartmentBuildings_ { 

    public static volatile SingularAttribute<ApartmentBuildings, String> buildingAddress;
    public static volatile CollectionAttribute<ApartmentBuildings, Apartments> apartmentsCollection;
    public static volatile SingularAttribute<ApartmentBuildings, String> buildingDescription;
    public static volatile SingularAttribute<ApartmentBuildings, String> buildingShortName;
    public static volatile SingularAttribute<ApartmentBuildings, String> buildingManager;
    public static volatile SingularAttribute<ApartmentBuildings, String> buildingPhone;
    public static volatile SingularAttribute<ApartmentBuildings, String> otherBuildingDetails;
    public static volatile SingularAttribute<ApartmentBuildings, String> buildingFullName;
    public static volatile SingularAttribute<ApartmentBuildings, Integer> buildingId;

}