package practice;

import base_urls.PetStoreBaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.InputStream;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Practice09 extends PetStoreBaseUrl {

     /*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        User sends Get request
    Then
        Assert that number of pets whose status is "available" is more than 100
     */



    @Test
    public void h9(){
        spec.pathParams("first","v2","second","pet","third","findByStatus").
                queryParam("status","available");
        Response response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();
        int numOfAvailablePets = response.jsonPath().getList("id").size();
        System.out.println("numOfAvailablePets = " + numOfAvailablePets);
        assertTrue(numOfAvailablePets>100);



//               @Test
//        public void practice09() {
//            // Set base URL for the Swagger Petstore API
//            String url = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";
//
//
//            Response response = given().get(url);
//            response.prettyPrint();
//
//            int numOfElements = response.jsonPath().getList("findAll{it.status=='available'}.status").size();
//            System.out.println("numOfElements = " + numOfElements);
//
//            assertEquals(200, response.statusCode());
//            assertTrue(numOfElements > 100);


        }
    }














