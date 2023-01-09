import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestV1 {

    @Test
    void shouldReturnTextString() {
        ResponseAwareMatcher<Response> equalTo;
        given()
                .baseUri("https://postman-echo.com/")
                .contentType("text/plain; charset=UTF-8")
                .body("Hello, World!")

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("Hello, World!"));
    }
}
