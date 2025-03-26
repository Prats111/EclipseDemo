package restAssuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo2_Post_Request {
	
	public static HashMap map = new HashMap();
	
	@BeforeClass
	public void postData() {
		
		map.put("name", RestUtils.getName());
		map.put("job", RestUtils.getJob());
		RestAssured.baseURI="https://reqres.in/api/users";
		
		
	}
	

	@Test
	public void postUserDetails() {
		
		given()
		.contentType("application/json").body(map)
		.when().post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.body("name",containsString("john"));
	}
}

