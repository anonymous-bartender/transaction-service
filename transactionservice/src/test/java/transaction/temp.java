package transaction;

import org.junit.Test;
//import io.restassured.RestAssured.*;
//import io.restassured.matcher.RestAssuredMatchers.*;
//import org.hamcrest.Matchers.*;
//import com.jayway.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class temp {

	@Test
	public void sampleTest() {
		given().when().get("http://www.google.com").then().statusCode(200);
		
	}
}
