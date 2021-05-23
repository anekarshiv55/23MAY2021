import io.restassured.path.json.JsonPath;

import java.util.Locale;

public class ComplexJsonTest
{
    public static void main(String[] args) {
        String response="{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\n" +
                "\"purchaseAmount\": 910,\n" +
                "\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\n" +
                "\"price\": 50,\n" +
                "\n" +
                "\"copies\": 6\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Cypress\",\n" +
                "\n" +
                "\"price\": 40,\n" +
                "\n" +
                "\"copies\": 4\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"RPA\",\n" +
                "\n" +
                "\"price\": 45,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}";
        JsonPath jsonPath=new JsonPath(response);
        //Get the total purchase Amount
        System.out.println(Integer.parseInt(jsonPath.getString("dashboard.purchaseAmount")));
        //Get the website name
        System.out.println(jsonPath.getString("dashboard.website").toUpperCase(Locale.ROOT));
        //Get size of array
        System.out.println(jsonPath.getInt("courses.size()")+"SIZE");
        //Get title price copies at 0th index
        System.out.println(jsonPath.getString("courses[0].title")+" "+
                jsonPath.getFloat("courses[0].price")+" "+
                jsonPath.getInt("courses[0].copies"));

        for(int i=0;i<=2;i++)
        {
            System.out.println(jsonPath.getString("courses["+i+"].title")+" "+
                    jsonPath.getDouble("courses["+i+"].price")+" "+
                    jsonPath.getLong("courses["+i+"].copies")+"************");

            float sum=0;

        }
    }
}
