package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.ApartmentBookings;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-17T02:47:05")
@StaticMetamodel(Guests.class)
public class Guests_ { 

    public static volatile SingularAttribute<Guests, Character> genderCode;
    public static volatile SingularAttribute<Guests, String> otherGuestDetails;
    public static volatile SingularAttribute<Guests, String> guestLastName;
    public static volatile SingularAttribute<Guests, String> guestFirstName;
    public static volatile SingularAttribute<Guests, String> dateOfBirth;
    public static volatile SingularAttribute<Guests, Integer> guestId;
    public static volatile CollectionAttribute<Guests, ApartmentBookings> apartmentBookingsCollection;

}