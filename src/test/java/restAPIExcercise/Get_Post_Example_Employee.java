package restAPIExcercise;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Get_Post_Example_Employee {

	@Test(enabled = false)
	public void testGet() {

		baseURI = "https://reqres.in";

		given().
			get("/api/users?page=2").
		then().
			statusCode(200).
			body("data[0].first_name", equalTo("Michael")).
			body("data[1].email", equalTo("lindsay.ferguson@reqres.in")).
			body("data.first_name", hasItems("Michael", "Lindsay", "Tobias"));

	}

	@Test
	public void testPOST() {

		String name = "Vijaya";
		String role = "Leader";
		baseURI = "https://reqres.in";

		JSONObject request = new JSONObject();

		request.put("name", name);
		request.put("job", role);

		System.out.println("Body" + request.toJSONString());

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/api/users").
		then().
			statusCode(201).
			body("name", equalTo(name)).
			body("job", equalTo(role)).
			log().all();

//			

	}

}
