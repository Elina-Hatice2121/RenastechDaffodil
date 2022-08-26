package code;

import io.restassured.response.Response;
import com.github.javafaker.Faker;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class utils {

    public static String bookId(){

        Response response = get("/books");
        response.then().assertThat().statusCode(200);

        String bookId = response.jsonPath().getString("[0].id");

        return bookId;
    }

    public static String bearerToken(){

        Faker faker = new Faker();

        String clientName = faker.name().fullName();
        String clientEmail = faker.internet().emailAddress();

        JSONObject object = new JSONObject();

        object.put("clientName",  clientName);
        object.put("clientEmail", clientEmail);

        String payload = object.toString();

        RequestSpecification generateTokenRequest = given()
                .header("Content-Type", "application/json")
                .body(payload);
        Response generateTokenResponse = generateTokenRequest.when().post("/api-clients");

        generateTokenResponse.then().assertThat().statusCode(201);

        return "Bearer " + generateTokenResponse.jsonPath().getString("accessToken");
    }

    public static String readFile(String path) throws IOException { // src/test/java/code/orderBook.json
        return new String(Files.readAllBytes(Paths.get(path)));
    }


}
