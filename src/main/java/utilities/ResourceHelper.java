package utilities;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class ResourceHelper {


    public static Response get(String url){

        return given()
                .when()
                .get(url);
    }

    public static Response create(String url, String Json){

        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(Json)
                .post(url);
    }

    public static Response update(String url, String Json){

        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(Json)
                .put("status", "sold");
    }
}
