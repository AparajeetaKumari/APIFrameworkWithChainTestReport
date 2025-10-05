package auth;

import enums.APIEndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TokenManager {
	
	private static String token;
	
	
	public static String getToken() {
		
		AuthenticationRequest authRequest = new AuthenticationRequest("admin","password123");
		if(token==null) {
			Response res = RestAssured.given().body(authRequest).contentType(ContentType.JSON).
					post("https://restful-booker.herokuapp.com/auth");
			token= res.jsonPath().get("token");
		}
		
		return token;
	}

}
