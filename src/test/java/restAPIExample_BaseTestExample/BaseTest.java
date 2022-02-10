package restAPIExample_BaseTestExample;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

	
	Response response;
	@BeforeTest
	public void getUserDetailsTest() {
		
		//Specify base URI
		RestAssured.baseURI = "https://reqres.in/";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		response = httpRequest.request(Method.GET,"/api/users?page=2");
		
				
		//Print on console window, converting JSON in string 
		String responseBody = response.getBody().asPrettyString();
		System.out.println("Resonse Body is: " + responseBody);
		

		
	}
	
	
}
