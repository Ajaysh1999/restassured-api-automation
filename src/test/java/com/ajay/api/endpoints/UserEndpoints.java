package com.ajay.api.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserEndpoints {

    static {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    private static final String API_KEY = "reqres-free-v1";

    public static Response getUsers() {
        return given()
                .when()
                .get("/users?page=2");
    }

    public static Response addUser(String name, String job) {
        String payload = "{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }";

        return given()
                .header("x-api-key", API_KEY)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/users");
    }

    public static Response updateUser(String id, String name, String job) {
        String payload = "{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }";

        return given()
                .header("x-api-key", API_KEY)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put("/users/" + id);
    }

    public static Response deleteUser(String id) {
        return given()
                .header("x-api-key", API_KEY)
                .when()
                .delete("/users/" + id);
    }
}
