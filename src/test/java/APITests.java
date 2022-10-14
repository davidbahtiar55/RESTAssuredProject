package test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class APITests {

    @Test
    void test1(){

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println("Status Code : "+response.asString());
        System.out.println("Status Code : "+response.getStatusCode());
        System.out.println("Body : "+response.getBody().asString());
        System.out.println("Time taken : "+response.getTime());
        System.out.println("Header : "+response.getHeader("content-type"));

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void test2(){

        baseURI = "https://reqres.in/api";

        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[1].id", equalTo(8))
                .log().all();
    }
}
