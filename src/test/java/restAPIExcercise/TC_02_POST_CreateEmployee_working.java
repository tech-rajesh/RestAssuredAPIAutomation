package restAPIExcercise;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_02_POST_CreateEmployee_working {

	Response response;

	@BeforeTest
	public void setup() {

		// https://dummy.restapiexample.com/

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// Request
		RequestSpecification httpRequest = RestAssured.given();

		//JSON file - body
		JSONObject requestPram = new JSONObject();
		
		requestPram.put("name", "Gaurav5");
		requestPram.put("salary", "100000");
		requestPram.put("age", "27");
		
		//Added Header
		httpRequest.header("Content-Type", "application/json");
		
		//Add body
		httpRequest.body(requestPram.toJSONString());
		
		
		
		// Response
		response = httpRequest.request(Method.POST, "/create");
		
		System.out.println("Response : " + response.asString());

	}

	@Test
	public void getStatusCode() {

		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
