package code;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POSTOrderBook {

    @BeforeClass
    public void setup(){
        //Setting BaseURI once
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
    }

    @Test
    (description = "Given baseUrl and token When user order book Then Verify status code is 201")
    void OrderBook(){

        // Given
        // request payload, token, endpoint, content-type

        //token
        String token = utils.bearerToken();

        // payload
        Faker faker = new Faker();
        String bookId = utils.bookId();

        String customerName = faker.name().fullName();

        JSONObject object = new JSONObject();

        object.put("bookId",  bookId);
        object.put("customerName", customerName);

        String payload = object.toString();

        RequestSpecification orderBookRequest = given()
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .body(payload);

        // When

        Response orderBookResponse = orderBookRequest.when().post("/orders");
        orderBookResponse.then().assertThat().statusCode(201);
        String orderId = orderBookResponse.jsonPath().getString("orderId");

        // List the Ordered Book(s)

        RequestSpecification listOfOrdersRequest = given()
                .header("Authorization", token);

        Response listOfOrdersResponse = listOfOrdersRequest.when().get("/orders");

        listOfOrdersResponse.then().statusCode(200);

        System.out.println(listOfOrdersResponse.getBody().asString());

        // UPDATE ORDER

        // access token, content-type:json, path variable, body (customerName)

        String newName = "Ege";
        JSONObject objectNewName = new JSONObject();
        objectNewName.put("customerName", newName);
        String newNamePayload = objectNewName.toString();

        RequestSpecification updateOrderRequest = given()
                .pathParam("orderId",orderId)
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .body(newNamePayload);

        Response updateOrderResponse = updateOrderRequest.when().patch("/orders/{orderId}");

        updateOrderResponse.then().assertThat().statusCode(204);

        // List the Ordered Book(s)

        listOfOrdersRequest = given()
                .header("Authorization", token);

        listOfOrdersResponse = listOfOrdersRequest.when().get("/orders");

        listOfOrdersResponse.then().statusCode(200);

        System.out.println(listOfOrdersResponse.getBody().asString());

        // DELETE Order

        // token,path params:orderId, Content-Type, delete, body

        RequestSpecification deleteOrderRequest = given()
                .pathParam("orderId", orderId)
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{}");

        Response deleteOrderResponse = deleteOrderRequest.when().delete("/orders/{orderId}");

        deleteOrderResponse.then().assertThat().statusCode(204);

        // List the Ordered Book(s)

        listOfOrdersRequest = given()
                .header("Authorization", token);

        listOfOrdersResponse = listOfOrdersRequest.when().get("/orders");

        listOfOrdersResponse.then().statusCode(200);

        System.out.println(listOfOrdersResponse.getBody().asString());

    }
}
