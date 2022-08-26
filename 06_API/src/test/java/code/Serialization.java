package code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.SQLOutput;

public class Serialization { // Convert POJOToJSON

    public static void main(String[] args) throws JsonProcessingException {

        // 1. Create an object of POJO class

        // Create object of pojo and set values
        SerializationAndDeserialization serialization = new SerializationAndDeserialization();

        // 2. Set values of properties of Pojo class
        serialization.setBookId("1");
        serialization.setCustomerName("Gulsen");

        // ObjectMapper class to serialize Pojo Object to JSON
        // 3.Create an object of ObjectMapper class provided by Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(serialization);

        System.out.println("JSON Object is :-");
        System.out.println(json);

        // Output
        // JSON Object is :-
        // {
        //   "bookId" : "1",
        //   "customerName" : "Gulsen"
        // }
    }
}
