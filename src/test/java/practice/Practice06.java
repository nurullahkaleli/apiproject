package practice;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class Practice06 extends ReqresBaseUrl {


   /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

    @Test
    public void practice06(){
        //Set the url
        spec.pathParams("first","api","second","unknown");

        //Set the expected data


        //Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();


        //Do assertion
        //1)Status code is 200
        assertEquals(200,response.statusCode());

        //2)Print all pantone_values
        JsonPath json = response.jsonPath();
        List<String> pantoneValuesList = json.getList("data.pantone_value");
        System.out.println("pantoneValuesList = " + pantoneValuesList);

        //3)Print all ids greater than 3 on the console
        //Assert that there are 3 ids greater than 3

        List<String> ids = json.getList("data.findAll{it.id>3}.id");
        System.out.println("ids = " + ids);
        Assert.assertEquals(3,ids.size());

        //4)Print all names whose ids are less than 3 on the console
        //Assert that the number of names whose ids are less than 3 is 2

        List<String> names = json.getList("data.findAll{it.id<3}.name");
        System.out.println("names = " + names);
        Assert.assertEquals(2,names.size());


    }



}
