package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Apartments;
import persistence.Guests;
import persistence.RefBookingStatus;
import persistence.ViewUnitStatus;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-17T02:41:18")
@StaticMetamodel(ApartmentBookings.class)
public class ApartmentBookings_ { 

    public static volatile SingularAttribute<ApartmentBookings, String> bookingStartDate;
    public static volatile SingularAttribute<ApartmentBookings, String> otherBookingDetails;
    public static volatile SingularAttribute<ApartmentBookings, String> bookingEndDate;
    public static volatile CollectionAttribute<ApartmentBookings, ViewUnitStatus> viewUnitStatusCollection;
    public static volatile SingularAttribute<ApartmentBookings, Apartments> aptId;
    public static volatile SingularAttribute<ApartmentBookings, Guests> guestId;
    public static volatile SingularAttribute<ApartmentBookings, RefBookingStatus> bookingStatusCode;
    public static volatile SingularAttribute<ApartmentBookings, Integer> aptBookingId;

}