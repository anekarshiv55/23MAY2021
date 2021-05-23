import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RestAssured2
{
    public static void main(String[] args) {
        RestAssured.baseURI="";

        given().log().all();
        given().log().uri();
        given().log().ifValidationFails();

        given().header("","");
        given().cookie("","");
        given().queryParam("","");
        given().param("","");
        given().pathParam("",new Object());



    }
}
