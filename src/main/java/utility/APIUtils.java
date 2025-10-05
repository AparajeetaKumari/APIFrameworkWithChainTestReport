package utility;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Map;

import enums.APIEndPoints;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class APIUtils {
	
	public static Response post(RequestSpecification reqspec,ResponseSpecification resspec,String path,Object payload) {
		Response res = given()
		.spec(reqspec)
		.body(payload)
		.when()
		.post(path);
		
		return res;
	}
	
	public static Response post(RequestSpecification reqspec,ResponseSpecification resspec,String path,String payload) {
		Response res = given()
		.spec(reqspec)
		.body(payload)
		.when()
		.post(path);
		
		return res;
	}
	
	public static Response post(RequestSpecification reqspec,ResponseSpecification resspec,String path,File payload) {
		Response res = given()
		.spec(reqspec)
		.body(payload)
		.when()
		.post(path);
		
		return res;
	}
	
	public static Response put(RequestSpecification reqspec,ResponseSpecification resspec,String path,Object payload,String pathparam,Headers headers,Cookies cookies) 
	{
		Response res = given()
		.spec(reqspec)
		.headers(headers)
		.cookies(cookies)
		.body(payload)
		.when()
		.put(path);
		
		return res;
	}
	
	public static Response put(RequestSpecification reqspec,ResponseSpecification resspec,String path,Object payload,Map<String,Object> pathparam,Map<String,Object> queryparam,Map<String,Object> headers) 
	{
		Response res = given()
		.spec(reqspec)
		.headers(headers!=null?headers:Map.of())
		.pathParams(pathparam!=null?pathparam:Map.of())
		.queryParams(queryparam!=null?queryparam:Map.of())
		.body(payload)
		.when()
		.put(path);
		
		return res;
	}
	
	public static Response delete(RequestSpecification reqspec,ResponseSpecification resspec,String path,Object payload,Map<String,Object> pathparam,Map<String,Object> queryparam,Map<String,Object> headers) 
	{
		Response res = given()
		.spec(reqspec)
		.headers(headers!=null?headers:Map.of())
		.pathParams(pathparam!=null?pathparam:Map.of())
		.queryParams(queryparam!=null?queryparam:Map.of())
		.body(payload)
		.when()
		.delete(path);
		
		return res;
	}

}
