package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookinDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class S1_Post extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking

        And
            {
                "firstname" : "Jim",
                "lastname" : "Brown",
                "totalprice" : 111,
                "depositpaid" : true,
                "bookingdates" : {
                    "checkin" : "2018-01-01",
                    "checkout" : "2019-01-01"
                },
                "additionalneeds" : "Breakfast"
            }
       When
            Send post request
       Then
            Status code should be 200
       And
            Response body should be
            {
                "bookingid": 5827,
                "booking": {
                    "firstname": "Jim",
                    "lastname": "Brown",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                    },
                    "additionalneeds": "Breakfast"
                }
            }
     */

    public static int bookingId;  //We put the created bookingId into a container and use it in other classes.
    @Test

    public void postTest(){

        //Set the url
        spec.pathParam("first","booking");

        //Set the expected data
        BookinDatesPojo bookinDatesPojo = new BookinDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("Jim","Brown",111,true,bookinDatesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);

        //Send the request get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        BookingResponsePojo actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(),BookingResponsePojo.class);
        //With convertJsonToJavaObject() method we handled throw exception issue
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.getFirstname(),actualData.getBooking().getFirstname());
        Assert.assertEquals(expectedData.getLastname(),actualData.getBooking().getLastname());
        Assert.assertEquals(expectedData.getTotalprice(),actualData.getBooking().getTotalprice());
        Assert.assertEquals(expectedData.getDepositpaid(),actualData.getBooking().getDepositpaid());

        Assert.assertEquals(bookinDatesPojo.getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(bookinDatesPojo.getCheckout(), actualData.getBooking().getBookingdates().getCheckout());

        Assert.assertEquals(expectedData.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());

        bookingId =actualData.getBookingid();


    }

}
