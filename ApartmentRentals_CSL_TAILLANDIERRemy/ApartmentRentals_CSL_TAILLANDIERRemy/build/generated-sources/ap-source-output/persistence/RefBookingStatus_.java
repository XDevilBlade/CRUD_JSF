package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.ApartmentBookings;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-10-24T19:25:46")
@StaticMetamodel(RefBookingStatus.class)
public class RefBookingStatus_ { 

    public static volatile SingularAttribute<RefBookingStatus, String> bookingStatusDescription;
    public static volatile SingularAttribute<RefBookingStatus, String> bookingStatusCode;
    public static volatile CollectionAttribute<RefBookingStatus, ApartmentBookings> apartmentBookingsCollection;

}