package restAssuredTests;


import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class TestWithNoSerialization {
	
	public HashMap map = new HashMap();
	
	@Test(priority=1)
	public void createNewStudent() {
		System.out.println(RestAssured.config().getObjectMapperConfig().defaultObjectMapperType());
		map.put("name", "chunu");
		map.put("job", "qa");
		
		given()
		.contentType("application/json")
		.body(map)
		.when().post("https://reqres.in/api/users/2").then().statusCode(201)
		.body("name",equalTo("chunu"));
			
	}
	@Test(priority=2)
	public void getNewStudent() {
		
		given()
		.when().get("https://reqres.in/api/users/2").then().statusCode(200)
		.body("data.first_name",equalTo("Janet"));
			
	}

}
