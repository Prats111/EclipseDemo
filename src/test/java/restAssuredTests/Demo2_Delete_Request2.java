package restAssuredTests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo2_Delete_Request2 {
	
	public static HashMap map = new HashMap();
	
	@BeforeClass
	public void postData() {
		
		map.put("name", RestUtils.getName());
		map.put("job", RestUtils.getJob());
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		
	}
	

	@Test
	public void postUserDetails() {
		
		Response response = given()
		.contentType("application/json").body(map)
		.when().delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204)
		.log().all().extract().response();
	}
}

