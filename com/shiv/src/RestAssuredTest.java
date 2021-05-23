import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest
{
    public static void main(String[] args)
    {
        RestAssured.baseURI="https://rahulshettyacademy.com";

       //Add Place API
        String response=given().log().all().
                queryParam("key","qaclick123").
                header("Content-Type","application/json").
                body("{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"V house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n").
                when().log().all().post("/maps/api/place/add/json").
                then().log().all().assertThat().statusCode(200).assertThat().header("Content-Type","application/json;charset=UTF-8")
                .body("scope",equalTo("APP")).extract().response().asString();

        JsonPath jsonPath=new JsonPath(response);

        String place_id=jsonPath.getString("place_id");
        System.out.println(place_id+"**************************");

        //Update place API
    }
}
