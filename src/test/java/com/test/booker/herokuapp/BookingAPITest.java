package com.test.booker.herokuapp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import auth.TokenManager;
import base.BaseTest;
import enums.APIEndPoints;
import factory.BookingFactory;
import io.restassured.response.Response;
import utility.APIUtils;

public class BookingAPITest extends BaseTest{
	int bookingId;
	@Test(description = "This test is to verify the new booking using post call",priority = 1)
	public void createBookingTest() {
		
		
		Response res = APIUtils.post(reqspec, resspec, APIEndPoints.CREATE_BOOKING.getPath(), BookingFactory.generateBookingData(null,null))
				.then().spec(resspec).extract().response();
		
		bookingId = res.jsonPath().get("bookingid");
		System.out.println("Booking Is id::"+bookingId);
		
		Assert.assertEquals(res.getStatusCode(), 200,"Status code mismatch");
	}
	
	@Test(enabled = true,description  = "This test is to verify the new booking using post call")
	public void createBookingWithJsonTest() {
		
		File file = new File("./src/test/resources/jsondata/CreateBooking.json");
		Response res = APIUtils.post(reqspec, resspec, APIEndPoints.CREATE_BOOKING.getPath(), file);
		res.then().spec(resspec).extract().response();
		Assert.assertEquals(res.getStatusCode(), 200,"Status code mismatch");
	}
	
	@Test(enabled = true,description  = "This test is to verify the update booking api call",priority = 2)
	public void updateBooking() {
		Map<String,Object> pathparam = new HashMap<String, Object>();
		pathparam.put("id", bookingId);
		
		Map<String,Object> headers = new HashMap<String, Object>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		headers.put("Cookie", "token="+TokenManager.getToken());
		
		
		Response res = APIUtils.put(reqspec, resspec, APIEndPoints.UPDATE_BOOKING.getPath(),  BookingFactory.generateBookingData("Aiduu","Sweety"), pathparam, null, headers);
		
		Assert.assertEquals(res.getStatusCode(), 200,"Response code mismatch");
		
	}
	
	@Test(enabled = true,description  = "This test is to verify the update booking api call",priority = 3)

	public void deleteBooking() {
		Map<String,Object> pathparam = new HashMap<String, Object>();
		pathparam.put("id", bookingId);
		
		Map<String,Object> headers = new HashMap<String, Object>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		headers.put("Cookie", "token="+TokenManager.getToken());
		
		
		Response res = APIUtils.delete(reqspec, resspec, APIEndPoints.UPDATE_BOOKING.getPath(),  BookingFactory.generateBookingData("Aiduu","Sweety"), pathparam, null, headers);
		
		Assert.assertEquals(res.getStatusCode(), 201,"Response code mismatch");
		
	}

}
