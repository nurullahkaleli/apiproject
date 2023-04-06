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

    //Using the https://petstore.swagger.io/ document, write an automation test that finds the number of "pets" with a status of "available" and asserts that those are more than 100.

//    @Test
//    public void practice09(){
//
//        //Set the url
//        spec.pathParams("first","v2","second","pet","third","findByStatus").
//                queryParams("status","available");
//
//        //Set the expected data
//
//        //Send the request and get the response
//        Response response = given(spec).when().get("{first}/{second/{third}");
//        response.prettyPrint();
//
//   //     response.then().statusCode(200).body()



        //Chatcbt

        @Test
        public void practice09() {
            // Set base URL for the Swagger Petstore API
            String url = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";


            Response response = given().get(url);
            response.prettyPrint();

            int numOfElements = response.jsonPath().getList("findAll{it.status=='available'}.status").size();
            System.out.println("numOfElements = " + numOfElements);

            assertEquals(200, response.statusCode());
            assertTrue(numOfElements > 100);


        }
    }














