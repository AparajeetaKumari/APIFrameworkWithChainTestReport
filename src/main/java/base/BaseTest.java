package base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseTest {
	protected RequestSpecification reqspec;
	protected ResponseSpecification resspec;
	protected ResponseSpecification resspec_200;
	ConfigReader config = new ConfigReader();
	String baseURL = config.getProperty("qaBaseURL");
	
	@BeforeClass
	public void setup() {
		
	 reqspec	=new RequestSpecBuilder()
			.log(LogDetail.ALL)
				.setContentType(ContentType.JSON)
				.setBaseUri(baseURL).build();
	
	
	  resspec= new ResponseSpecBuilder()
		.log(LogDetail.ALL)
			.expectContentType("application/json")
				.build();
	  

	  resspec_200= new ResponseSpecBuilder()
		.log(LogDetail.ALL)
			.expectContentType("application/json")
			.expectStatusCode(200)
				.build();
		
	}

}
