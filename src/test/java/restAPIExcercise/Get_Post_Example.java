package restAPIExcercise;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Get_Post_Example {

	
	@Test
	public void testPOST1() {

		String name = "Vijaya1";
		String salary = "999111";
		String age = "27";
		
		baseURI = "http://dummy.restapiexample.com/api/v1";

		JSONObject request = new JSONObject();

		request.put("name", name);
		request.put("salary", salary);
		request.put("age", age);

		System.out.println("Body" + request.toJSONString());

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/create").
		then().
			statusCode(201).
			body("data.name", equalTo(name)).
			body("data.salary", equalTo(salary)).
			log().all();

//			

	}

}
