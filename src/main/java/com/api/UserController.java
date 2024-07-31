package com.api;


import com.core.models.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

public class UserController extends  RestApiMethods{
    static Faker faker = new Faker();
    private static String baseUrl = "https://reqres.in";
    private static String createUrl = "/api/users";

    public static User postCreate(User user){
        Response response = post(baseUrl+createUrl, user);
        if(response.statusCode()<300){
           return response.getBody().as(User.class);
        }
        throw new RuntimeException("post response.statusCode > 300");
    };
}
