package practice;

import base_urls.AutomationExerciseBaseUrl;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class API1_GetAllProductsList extends AutomationExerciseBaseUrl {


        /*
            API 1: Get All Products List
            API URL: https://automationexercise.com/api/productsList
            Request Method: GET
            Response Code: 200
            Response JSON: All products list
         */

    @Test
    public void getAllProductsList(){


        //Set the url
        spec.pathParams("first","productsList");



        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("text/html; charset=utf-8");








    }


}
