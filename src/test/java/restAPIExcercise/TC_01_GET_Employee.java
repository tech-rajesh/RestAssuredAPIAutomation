package restAPIExcercise;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_01_GET_Employee {

	Response response;

	@BeforeTest
	public void setup() {

		// https://dummy.restapiexample.com/

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// Request
		RequestSpecification httpRequest = RestAssured.given();

		
		//add header information to request object
		httpRequest.header("Content-Type","application/json");
		
		System.out.println("Request : " + httpRequest);
		
		
		
		
		// Response
		response = httpRequest.request(Method.GET, "/employees");

	}

	@Test
	public void getStatusCode() {

		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
