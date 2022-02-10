package restAPIExampleDemo;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;



import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_Post_Employee_Record {

	RequestSpecification httpRequest;
	Response response;
	
	String empName="Priya";
	String empSalary="100000";
	String empAge="27";
	
	
	@BeforeClass
	void createEmployee() throws InterruptedException
	{
		
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", empName); // Cast
		requestParams.put("salary", empSalary);
		requestParams.put("age", empAge);
		
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		httpRequest.body(requestParams.toJSONString());

		
		
		
		
		
		
		response = httpRequest.request(Method.POST, "/create");
		
		Thread.sleep(5000);

	}
	
			
	@Test
	void checkStatusCode()
	{
		int statusCode = response.getStatusCode(); 
		Assert.assertEquals(statusCode, 200);
	}
		
	
	
	@AfterClass
	void tearDown()
	{
		System.out.println("Scripts Executed successfully");
	}

}
