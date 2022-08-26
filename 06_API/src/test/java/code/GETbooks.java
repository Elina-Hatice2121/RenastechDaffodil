package code;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GETbooks {

    @BeforeClass
    public void setup(){
        //Setting BaseURI once
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
    }

    @Test
    (description = "Given a baseUrl When make GET call w /book Then Verify status Code is 200")
    void userRetrieveListOfTheBooks(){

        // Given

        //When
        Response response = RestAssured.get("/books");
        int actualStatusCode= response.getStatusCode();
        int expectedStatusCode = 200;

        // System.out.println(response.getBody().asString());

        // Then
        Assert.assertEquals(actualStatusCode, expectedStatusCode);
    }

    @Test
    (description = "Given a baseUrl When make GET call w /books and use query param limit=2 Then Verify status Code is 200")
    void userRetrieveListOfTheBooksLimit2(){

        // Given
        RequestSpecification requestBody = given().queryParam("limit", 2);

        //When
        Response response = requestBody.when().get("/books");

        // Then
        response.then().assertThat().statusCode(200);

        String bookId = response.jsonPath().getString("[1].name");

        System.out.println(response.getBody().asString());
        System.out.println("BookId: "+bookId);
    }

    @Test
    (description = "Given a baseUrl When make GET call w /books and use query param type=fiction Then Verify status Code is 200")
    void userRetrieveListOfTheBooksTypeFiction(){

        //Given
        RequestSpecification requestBody = given()
                .queryParams("type","fiction","limit",1);

        //When
        Response response = requestBody.when().get("/books");

        //Then
        response.then().assertThat().statusCode(200);
        String type = response.jsonPath().getString("[0].type");
        Assert.assertEquals(type, "fiction");

        //System.out.println(response.getBody().asString());
        //System.out.println(type);

    }

    @Test
    (description = "Given a baseUrl When make GET call w /books and use query param type=crime(not exist) Then Verify status Code is 400")
    void userRetrieveListOfTheBooksUnExistType(){

        //Given
        RequestSpecification requestBody = given().queryParam("type", "crime");

        //When
        Response response = requestBody.when().get("/books");

        //Then
        response.then().assertThat().statusCode(400);

    }

    @Test
    (description = "Given a baseUrl When make GET call w /books and use query param limit=221(out of limit) Then Verify status Code is 400")
    void userRetrieveListOfTheBooksOutOfLimit(){

        // Given
        RequestSpecification requestBody = given().queryParam("limit", 221);

        //When
        Response response = requestBody.when().get("/books");

        // Then
        response.then().assertThat().statusCode(400); //404
    }

    // test run, regression 2000, %90, 200 //10 20 "auto failed"

    // intellij
    // Locally passed, failed, passed

    @Test
    (description = "Given baseUrl When make Get call to books/:bookId Then Verify status code equal to 200 and get book information")
    void userRetrieveSingleBookInformation(){

        String bookId = utils.bookId();

        RequestSpecification requestBody = given().pathParam("bookId",bookId);

        Response response = requestBody.when().get("/books/{bookId}");

        response.then().assertThat().statusCode(200);

        System.out.println(response.getBody().asString());
    }
}
