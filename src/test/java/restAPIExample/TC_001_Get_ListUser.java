package restAPIExample;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_Get_ListUser {
	
	
	@Test
	public void getUserDetailsTest() {
		
		//Specify base URI
		RestAssured.baseURI = "https://reqres.in/";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"/api/users?page=2");
		
		//Print on console window, converting JSON in string 
		String responseBody = response.getBody().asPrettyString();
		System.out.println("Resonse Body is: " + responseBody);
		
		
		//Status code Validation, 200
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is : " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
		String contentType = response.getContentType();
		System.out.println("Content-Type is : " + contentType);
		
	}
	
		

}
