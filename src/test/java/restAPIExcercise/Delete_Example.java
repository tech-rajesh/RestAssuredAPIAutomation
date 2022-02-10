package restAPIExcercise;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.json.simple.JSONObject;

public class Delete_Example {

	
	@Parameters("userID")
	@Test
	public void testDelete(String id) throws Exception {

		
		//baseURI="https://reqres.in";
		baseURI="http://localhost:3000/";
		
		//Request 
		
		given().
			
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		when().
			delete("/users/"+id).
		then().
			statusCode(200).
			log().all();
		
		Thread.sleep(5000);
		
	}
	
	
	
	

}
