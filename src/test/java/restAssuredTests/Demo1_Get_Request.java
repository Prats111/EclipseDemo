package restAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Demo1_Get_Request {

	@Test
	public void getWeatherDetails() {
		
		given()
        .baseUri("https://jsonplaceholder.typicode.com")
    .when()
        .get("/users/1")
    .then()
        .statusCode(200)
        .body("username", is("Bret"))
        .header("Content-Type",is("application/json; charset=utf-8"));
	}

	
	
}
