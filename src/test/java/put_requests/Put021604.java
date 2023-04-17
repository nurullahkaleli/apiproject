package put_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.Country;
import pojos.DummyRestApiPojo;
import test_data.DummyRestApiTestData;
import utils.ObjectMapperUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put021604 extends DummyRestApiBaseUrl {
    /*
     URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been added."
                    }

     */

    @Test
    public void put02() throws IOException {

        //Set the expected data
        spec.pathParams("first","update","second","21");

        //Set the expected data
        //1.Way
//        Map<String, Object> expectedData = new DummyRestApiTestData().expectedDataMapMethod("Tom Hanks", 111111, 23, "Perfect image");
//        System.out.println("expectedData = " + expectedData);

        //2.Way
        DummyRestApiPojo expectedData = new DummyRestApiPojo("Tom Hanks",111111,23,"Perfect image");
        System.out.println("expectedData = " + expectedData);

        //Send the request get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        HashMap actualData = new ObjectMapper().readValue(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
//        assertEquals(expectedData.getEmployee_name(),actualData.get("Tom Hanks"));
//        assertEquals(expectedData.getEmployee_salary(),actualData.get(111111));
//        assertEquals(expectedData.getEmployee_age(),actualData.get(23));
//        assertEquals(expectedData.getProfile_image(),actualData.get("Perfect image"));


    }



}