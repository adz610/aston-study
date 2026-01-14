import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestMethodsTest {
    @BeforeAll
    static void setBaseURI() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    void testGetRequest() {
        given()
            .queryParam("foo1", "bar1")
            .queryParam("foo2", "bar2")

            .when()
            .get("/get")

            .then()
            .statusCode(200)
            .body("args.foo1", equalTo("bar1"))
            .body("args.foo2", equalTo("bar2"))
            .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    void testPostRawText() {
        given()
            .contentType(ContentType.TEXT)
            .body("This is expected to be sent back as part of response body.")

            .when()
            .post("/post")

            .then()
            .statusCode(200)
            .body("data", equalTo("This is expected to be sent back as part of response body."))
            .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    void testPostFormData() {
        given()
            .contentType(ContentType.URLENC.withCharset("UTF-8"))
            .formParam("foo1", "bar1")
            .formParam("foo2", "bar2")

            .when()
            .post("/post")

            .then()
            .statusCode(200)
            .body("form.foo1", equalTo("bar1"))
            .body("form.foo2", equalTo("bar2"))
            .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    void testPutRequest() {
        given()
            .contentType(ContentType.TEXT)
            .body("This is expected to be sent back as part of response body.")

            .when()
            .put("/put")

            .then()
            .statusCode(200)
            .body("data", equalTo("This is expected to be sent back as part of response body."))
            .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    void testPatchRequest() {
        given()
            .contentType(ContentType.TEXT)
            .body("This is expected to be sent back as part of response body.")

            .when()
            .patch("/patch")

            .then()
            .statusCode(200)
            .body("data", equalTo("This is expected to be sent back as part of response body."))
            .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    void testDeleteRequest() {
        given()
            .contentType(ContentType.TEXT)
            .body("This is expected to be sent back as part of response body.")

            .when()
            .delete("/delete")

            .then()
            .statusCode(200)
            .body("data", equalTo("This is expected to be sent back as part of response body."))
            .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
