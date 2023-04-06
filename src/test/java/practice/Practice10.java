package practice;

import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Practice10 {

    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends Get request
        Note: use prettyPrint like: response.jsonPath().prettyPrint()
    Then
        Assert that number of "Women" usertype is 12

*/

   @Test

    public void practice10(){

       //Set the url
       String url = "https://automationexercise.com/api/productsList";

       // Send the request and get the response
       Response response = given().get(url);
       response.jsonPath().prettyPrint();

       //Do assertion
       //int numWomenProducts = response.jsonPath().getList("products.category.usertype.findAll{ it.usertype == 'Women' }.usertype").size();
      List<String> numWomenProducts = response.jsonPath().getList("products.category.usertype.findAll{ it.usertype == 'Women' }.usertype"); //   ==> Liste olarak görmek istiyorsak bu şekilde yazarız.

       System.out.println("numWomenProducts = " + numWomenProducts);
       System.out.println(numWomenProducts.size());;


       //assertEquals(12,numWomenProducts);


   }
}