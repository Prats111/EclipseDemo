package restAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Demo_Basic_Validation {

	@Test(priority=1)
	public void testStatusCode() {
		
		when()
		  .get("https://jsonplaceholder.typicode.com/posts/2")
		.then()
		  .statusCode(200);
//		  log().all();
	}

	@Test(priority=2)
	public void testLogging() {
		
		given()
		.when().get("https://reqres.in/api/users/2")
		.then().statusCode(200).body("data.first_name", equalTo("Janet"));
	}
	

	@Test(priority=3)
	public void testMultipleContents() {
		
		given()
		.when().get("https://reqres.in/api/users")
		.then().
		 body("data.first_name", hasItems("Janet","George"));
	}
	
}
