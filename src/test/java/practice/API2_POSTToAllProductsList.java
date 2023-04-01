package practice;

import base_urls.AutomationExerciseBaseUrl;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class API2_POSTToAllProductsList extends AutomationExerciseBaseUrl {

    /*
        API 2: POST To All Products List
        API URL: https://automationexercise.com/api/"productsList"
        Request Method: POST
        Response Code: 405
        Response Message: This request method is not supported.
     */

    @Test
    public void postToAllProductsList(){

        //Set the URL
        spec.pathParams("first","productsList");

        //Set the expected the data
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("Response Code", 405);
        expectedData.put("Response Message", "This request method is not supported.");

        System.out.println("expectedData = " + expectedData);


        //Send the request and get the response
        Response response = given(spec).post("{first}");
        response.prettyPrint();

//        Map<String,Object> actualData = response.as(HashMap.class);
//        System.out.println("actualData = " + actualData);




    }
}
