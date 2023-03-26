package practice;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anEmptyMap;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Practice02 extends ReqresBaseUrl {

     /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty

     */

    @Test
    public void practice02(){

        //Set the url
        spec.pathParams("first", "api","second","users","third",23);

        //Set the expected data


        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

        //Do assertion
        //1.way
        response.
                then().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");

        //Server is "cloudflare"
        assertEquals("cloudflare",response.header("Server"));

        //Response body should be empty
        assertEquals("{}",response.asString());

        //2.Way
        response.
                then().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found").
                header("Server","cloudflare").
                body("",anEmptyMap()); //This is no key value pair in the response body. So it is an empty map.



    }


}
