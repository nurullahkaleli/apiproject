package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;

public class S1_Put extends HerOkuAppBaseUrl {

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

        //Set the expected data

        //Send the request and get the response

        //Do assertion

    }
}
