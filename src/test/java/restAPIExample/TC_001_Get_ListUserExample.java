package restAPIExample;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_Get_ListUserExample {
	
	Response response;
	@BeforeTest
	public void getUserDetailsTest() {
		
		//Specify base URI
		RestAssured.baseURI = "https://reqres.in/";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		response = httpRequest.request(Method.GET,"/api/users?page=2");
		
		
		//POST/PUT/PATCH
		//Request body
		//Request header
		
		
		
		
		
		
		
		
		
		
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
	
	@Test(priority=1)
	public void verifyStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is : " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
	}
	
	
	@Test(priority=2)
	public void verifyHeaderContentType() {
		String contentType = response.getContentType();
		System.out.println("Content-Type is : " + contentType);
		Assert.assertEquals(contentType, "application/json;");
		Assert.assertTrue(contentType.contains("application/json"));
		System.out.println("*************" +response.contentType());
		
		
		//application/json;
		//application/json; charset=utf-8
	}
	
	@Test(priority=3)
	public void verifyResponseTime() {
		long responseTime = response.getTime();
		System.out.println("Response Time is : " + responseTime);
		//Assert.assertEquals(responseTime, 2000);
		
	}
	
	@Test(priority=4)
	public void verifyStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("statusLine is : " + statusLine);
		//Assert.assertEquals(statusLine, "");
		
	}
	
		

}
