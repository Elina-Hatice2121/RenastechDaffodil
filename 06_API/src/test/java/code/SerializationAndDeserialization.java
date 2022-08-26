package code;

public class SerializationAndDeserialization {

    // specific to RestAssured. It is related programming language - Java

    // What is Serialization and Deserialization

    // S is conversion of state of a Java object byte stream D is the reverse of it.

    // POJO- Plain Old Java Object

    // Converting a POJO Object to a JSON object => Serialization

    // converting a JSON Object to a POJO object => Deserialization

    // Jackson, Gson etc.

    private String bookId;
    private String customerName;

    public String getBookId(){
        return bookId;
    }

    public void setBookId(String bookId){
        this.bookId = bookId;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

}
