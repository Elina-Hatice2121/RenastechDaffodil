package code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Deserialization { // Convert JSON to POJO

    public static void main(String[] args) throws JsonProcessingException {

        // Conversion of JSON Object to POJO Object

        String jsonObject = "{\n" + "  \"bookId\" : \"1\",\n" + "  \"customerName\" : \"Gulsen\"\n" + "}";
        ObjectMapper objectMapper = new ObjectMapper();

        // Deserialize JSON Object to POJO Object
        SerializationAndDeserialization deserialization = objectMapper.readValue(jsonObject, SerializationAndDeserialization.class);

        // Once we get SerializationAndDeserialization object we can use getter method to fetch values
        System.out.println("bookId is :" + deserialization.getBookId());
        System.out.println("customerName :" + deserialization.getCustomerName());

        // Deserialize JSON Object to Map Object
        Map< String, Object> orderAsMap = objectMapper.readValue(jsonObject, Map.class);
        // Once we get Map Object we can use keys to fetch values
        System.out.println("bookId is :" + orderAsMap.get("bookId"));
        System.out.println("customerName is :" + orderAsMap.get("customerName"));
    }


}
