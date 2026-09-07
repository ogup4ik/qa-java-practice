package pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiClient {

    public static Response get(String url) {
        return given()
                .when()
                .get(url);
    }

    public static Response post(String url, Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(url);
    }

    public static Response put(String url, Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .put(url);
    }

    public static Response delete(String url) {
        return given()
                .when()
                .delete(url);
    }
}