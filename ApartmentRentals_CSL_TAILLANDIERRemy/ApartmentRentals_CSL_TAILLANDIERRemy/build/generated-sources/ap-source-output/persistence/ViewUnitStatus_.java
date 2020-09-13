package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.ApartmentBookings;
import persistence.Apartments;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-17T00:27:41")
@StaticMetamodel(ViewUnitStatus.class)
public class ViewUnitStatus_ { 

    public static volatile SingularAttribute<ViewUnitStatus, String> statusDate;
    public static volatile SingularAttribute<ViewUnitStatus, Character> availableYn;
    public static volatile SingularAttribute<ViewUnitStatus, Apartments> aptId;
    public static volatile SingularAttribute<ViewUnitStatus, ApartmentBookings> aptBookingId;

}