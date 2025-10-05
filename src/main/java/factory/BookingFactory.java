package factory;

import models.Booking;
import models.Booking.Bookingdates;

public class BookingFactory {
	
	public static Booking generateBookingData(String firstname,String lastname) {
		Booking user=null;
		if(firstname==null || lastname==null) {
			user = new Booking("Aparajeeta","anjanj",1000,true,"Breakfast",new Bookingdates("2025-11-01","2025-12-01"));
		}else {
			user = new Booking(firstname,lastname,1000,true,"Breakfast",new Bookingdates("2025-11-01","2025-12-01"));
		}
		 
		return user;
	}

}
