package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Apartments;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-10-24T19:25:46")
@StaticMetamodel(RefApartmentTypes.class)
public class RefApartmentTypes_ { 

    public static volatile SingularAttribute<RefApartmentTypes, String> aptTypeCode;
    public static volatile CollectionAttribute<RefApartmentTypes, Apartments> apartmentsCollection;
    public static volatile SingularAttribute<RefApartmentTypes, String> aptTypeDescription;

}