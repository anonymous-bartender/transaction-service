package transaction;


import org.junit.BeforeClass;
import io.restassured.RestAssured;

public class Hooks {
	
    @BeforeClass
    public static void setup() {
//        String port = System.getProperty("server.port");
//        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
//        }
//        else{
//            RestAssured.port = Integer.valueOf(port);
//            
//        }

        System.out.println("port=8080");
        
        String basePath = System.getProperty("server.base");
//        if(basePath==null){
            basePath = "/transactionservice/";
//        }
        RestAssured.basePath = basePath;
        
        System.out.println("basepath="+basePath);

        String baseHost = System.getProperty("server.host");
//        if(baseHost==null){
            baseHost = "http://localhost";
//        }
        RestAssured.baseURI = baseHost;
        
        System.out.println("host="+baseHost);

    }


}
