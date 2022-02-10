package demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Examples {

	//@Test
	public void test_get() {

		baseURI = "http://localhost:3000/";

		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		when().
			get("/users").
		then().
			statusCode(200).
			body("[2].first_name", equalTo("Vijaya")).
			log().all();

	}

	//@Test
	public void test_get_2() {

		baseURI = "http://localhost:3000/";

		given().
		param("name", "Automation").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		when().
		get("/subjects").
		then().
		statusCode(200).
		log().all();

	}
	
	@Test
	public void test_post() {

		JSONObject request = new JSONObject();

		request.put("first_name", "Sneha");
		request.put("last_name", "M");
		request.put("subjectId", 2);

		baseURI = "http://localhost:3000/";
		System.out.println(request);
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			body("first_name", equalTo("Sneha")).
			log().all();

	}

	//@Test
	public void test_delete_temp() {

		
		baseURI = "http://localhost:3000/";

		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			
		when().
			delete("/users/11").
		then().
			statusCode(204).
			log().all();
		
		//Log bug - 

	}
	
	
	
	
	//@Test
	public void test_patch_temp() {

		JSONObject request = new JSONObject();

		request.put("first_name", "Sumit");
		request.put("last_name", "M");
		request.put("subjectId", 2);

		baseURI = "http://localhost:3000/";

		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/10").
		then().
			statusCode(200).
			body("first_name", equalTo("Sumit")).
			log().all();

	}
	
	
	//@Test
	public void test_patch() {

		JSONObject request = new JSONObject();

		request.put("last_name", "Shephered");

		baseURI = "http://localhost:3000/";

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/users/5").
		then().
		statusCode(200)
		.log().all();

	}


	//@Test
	public void test_put() {

		JSONObject request = new JSONObject();

		request.put("first_name", "Ray");
		request.put("last_name", "Murphy");
		request.put("subjectId", 1);


		baseURI = "http://localhost:3000/";

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("/users/5").
		then().
		statusCode(200)
		.log().all();

	}
	
	//@Test
	public void test_delete() {

		

		baseURI = "http://localhost:3000/";

		
		when().
		delete("/users/5").
		then().
		statusCode(200)
		.log().all();

	}

}
