package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookinDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static herokuapp_smoketest.S1_Post.bookingId;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static utils.AuthenticationHerOkuApp.generateToken;

public class S2_Put extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/{id}
        And
            {
                "firstname" : "Veli",
                "lastname" : "Can",
                "totalprice" : 333,
                "depositpaid" : true,
                "bookingdates" : {
                    "checkin" : "2023-01-01",
                    "checkout" : "2023-01-01"
                },
                "additionalneeds" : "Breakfast"
            }
        When
            Send put request

        Then
            Status code should be 200
        And
            Body should be:
            {
                "firstname": "Veli",
                "lastname": "Can",
                "totalprice": 333,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2023-01-01",
                    "checkout": "2023-01-01"
                },
                "additionalneeds": "Breakfast"
            }



     */

    @Test
    public void putTest(){
        //Set the url
        spec.pathParams("first","booking","second", bookingId);

        //Set the expected data
        BookinDatesPojo bookinDatesPojo = new BookinDatesPojo("2023-01-01","2023-01-01");
        BookingPojo expectedData = new BookingPojo("Veli","Can",333,true,bookinDatesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).
                            body(expectedData).
                            put("{first}/{second}");

        response.prettyPrint();

        //Do assertion
        BookingPojo actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(),BookingPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        Assert.assertEquals(expectedData.getLastname(),actualData.getLastname());
        Assert.assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        Assert.assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());

        Assert.assertEquals(bookinDatesPojo.getCheckin(), actualData.getBookingdates().getCheckin());
        Assert.assertEquals(bookinDatesPojo.getCheckout(), actualData.getBookingdates().getCheckout());

        Assert.assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
    }
}
