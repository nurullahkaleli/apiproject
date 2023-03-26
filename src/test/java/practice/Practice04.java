package practice;

import base_urls.HerOkuAppBaseUrl;
import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.codehaus.groovy.control.io.ReaderSource;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Practice04 extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson
        When
            User sends get request to the URL
        Then
            Status code is 200
        And
            Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"

 */
    @Test
    public void practice04(){

        //Set the url
        spec.pathParams("first","booking").queryParams("Brandon","Jane","lastname","Wilson");

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("{first}");
        response.prettyPrint();

        //        Then
        //        Status code is 200
        Assert.assertEquals(200,response.getStatusCode());

        //        And
        //        Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"
        Assert.assertTrue(response.asString().contains("bookingid"));

    }


}
