package transaction;

import org.junit.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class BasicPingTest extends Hooks {
    @Test
    public void Root() {
        //given().when().get("http://localhost:8080/transactionservice/").then().statusCode(200);
        RestAssured
        .given()
        .when().get("http://localhost:8080/transactionservice/")
        .then().statusCode(200);
    }
    
    @Test
    public void contextLevel() {
   
    	
    	RestAssured
    .given()
    .when().get("/transactionservice/")
    .then().statusCode(200);
    }
}
