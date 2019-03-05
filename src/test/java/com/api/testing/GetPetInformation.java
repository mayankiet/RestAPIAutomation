package com.api.testing;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetPetInformation {

     ConfigReader configReader = new ConfigReader();

     @Test
    public void sendGetRequestAndValidateResponse(){

         given()
                 .queryParam("status", "available")
                 .when()
                 .get(configReader.getEndpointURL("/pet/findByStatus"))
                 .then()
                 .statusCode(200)
                 .body("[0].id", notNullValue())
                 .body("[0].category.name", notNullValue())
                 .body("[0].status", equalTo("available"));
     }

     @Test
    public void sendGetRequestByPassingQueryParamInURL(){

         given()
                 .when()
                 .get("http://petstore.swagger.io/v2/pet/findByStatus?status=available")
                 .then()
                 .statusCode(200)
                 .body("[0].id", notNullValue())
                 .body("[0].category.name", notNullValue())
                 .body("[0].status", equalTo("available"));
     }

     @Test
    public void sendGetRequestAndRetrieveTheStatus(){

         String status = given()
                 .when()
                 .get("http://petstore.swagger.io/v2/pet/findByStatus?status=available")
                 .then()
                 .extract()
                 .path("[0].status");
         if(status == null){

             throw new RuntimeException("Status is empty");
         }
     }

     @Test void sendGetRequestAndStoreTheResponse(){

         Response response = given()
                 .when()
                 .get("http://petstore.swagger.io/v2/pet/findByStatus?status=available");

         Assert.assertEquals(response.getStatusCode(), 200);
     }
}
