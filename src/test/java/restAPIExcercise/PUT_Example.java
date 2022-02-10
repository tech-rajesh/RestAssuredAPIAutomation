package restAPIExcercise;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.json.simple.JSONObject;

public class PUT_Example {

	

	@Test(dataProvider = "smokeTest")
	public void testPUT(String name, String role) throws Exception {

		
		//Request Body
		JSONObject  request = new JSONObject();
		
		request.put("name", name);
		request.put("job", role);
		
		baseURI="https://reqres.in";
		
		//Request 
		
		given().
			body(request.toJSONString()).
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		when().
			put("/api/users/2").
		then().
			statusCode(200).
			body("name", equalTo(name)).
			body("job", equalTo(role)).
			log().all();
		
		Thread.sleep(5000);
		
	}
	
	@DataProvider(name = "smokeTest")
	public Object[][] testData() {
		
		Object[][] data = {{"Vijaya","Leader"}, {"Gaurav","Sr.Manager"}, {"Sumit","Delivery Head"}};
		
		return data;
		
	}
	
	
	

}
