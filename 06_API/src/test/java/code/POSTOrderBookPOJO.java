package code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class POSTOrderBookPOJO {

    public POSTOrderBookPOJO() throws IOException {
    }

    @BeforeClass
    public void setup(){
        //Setting BaseURI once
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
    }

    @Test
    (description = "Given baseUrl and token When user order book Then Verify status code is 201")
    void OrderBook() {

        // Given
        // request payload, token, endpoint, content-type

        //token
        String token = utils.bearerToken();

        // payload
        Faker faker = new Faker();
        String bookId = utils.bookId();

        String customerName = faker.name().fullName();

        JSONObject object = new JSONObject();

        object.put("bookId", bookId);
        object.put("customerName", customerName);

        String payload = object.toString();

        RequestSpecification orderBookRequest = given()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body(payload);

        // When

        Response orderBookResponse = orderBookRequest.when().post("/orders");

        // Then
        orderBookResponse.then().assertThat().statusCode(201);
        String orderId = orderBookResponse.jsonPath().getString("orderId");

    }

    @Test
    (description = "Given baseUrl and token When user order book Then Verify status code is 201")
    void OrderBookPOJO() throws JsonProcessingException {

        // Given
        // request payload, token, endpoint, content-type

        //token
        String token = utils.bearerToken();

        // payload
        Faker faker = new Faker();
        String bookId = utils.bookId();

        String customerName = faker.name().fullName();

        // create pojo class, set value as we wish
        orderPOJO body = new orderPOJO(bookId,customerName);

       // Converting a Java class object to a JSON payload as string (deserialization)
        ObjectMapper objectMapper = new ObjectMapper();
        String orderJSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);

        RequestSpecification orderBookRequest = given()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body(orderJSON);

        // When

        Response orderBookResponse = orderBookRequest.when().post("/orders");

        // Then
        orderBookResponse.then().assertThat().statusCode(201);
        String orderId = orderBookResponse.jsonPath().getString("orderId");

    }

    @Test
    (description = "Given baseUrl and token When user order book Then Verify status code is 201")
    void OrderBookJSON() throws IOException {

        // Given
        // request payload, token, endpoint, content-type

        //token
        String token = utils.bearerToken();

        // payload
        String orderJSON = utils.readFile("src/test/java/code/testData/orderBook.json");

        RequestSpecification orderBookRequest = given()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body(orderJSON);

        // When
        Response orderBookResponse = orderBookRequest.when().post("/orders");

        // Then
        orderBookResponse.then().assertThat().statusCode(201);
        String orderId = orderBookResponse.jsonPath().getString("orderId");
        System.out.println("Response Body: " + orderBookResponse.getBody().asString());

    }
}
