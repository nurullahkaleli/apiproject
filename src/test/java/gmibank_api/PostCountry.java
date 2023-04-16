package gmibank_api;

import base_urls.GmiBankBaseUrl;
import org.junit.Test;

public class PostCountry extends GmiBankBaseUrl {

    //Type an automation test that creates a "country" which includes at least 3 "states" using the document //https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1
     /*
        Given
            https://gmibank.com/api/tp-countries

        And

            {
  "name": "My Country",
  "states": [
    {
      "id": 1,
      "name": "My State"
    },
    {
      "id": 2,
      "name": "Your State"
    },
    {
      "id":3,
      "name": "Her State"
    }
  ]
}

        When

            Send post request
        Then
            Status code should be 201

        And
            Response body should be like this

            {
    "id": 181984,
    "name": "My Country",
    "states": [
        {
            "id": 1,
            "name": "My State",
            "tpcountry": null
        },
        {
            "id": 2,
            "name": "Your State",
            "tpcountry": null
        },
        {
            "id": 3,
            "name": "Her State",
            "tpcountry": null
        }
    ]
}
      */



    @Test
    public void postCountry(){

        //Set the url
        spec.pathParams("first","api","second","tp-countries");

        //Set the expected data


    }
}
