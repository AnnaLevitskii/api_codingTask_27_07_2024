package com.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public abstract class RestApiMethods {
    public static String get(String endpoint){
        return RestAssured
                .given()
                .get(endpoint)
                .getBody().asString();
    }
    public static Response post(String endpoint, Object payload){
        return  given()
                .body(payload)
                .contentType(ContentType.JSON)
                .when()
                .post(endpoint);
    }
    public static String put(String endpoint, Object payload){
        return given()
                .body(payload)
                .contentType(ContentType.JSON)
                .when()
                .put(endpoint)
                .thenReturn()
                .getBody()
                .asString();
    }
    public static String delete(String endpoint){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .delete(endpoint)
                .thenReturn()
                .getBody()
                .asString();
    }
}
