package com.api;


import com.core.models.ErrorResponse;
import com.core.models.RegistrationResponse;
import com.core.models.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

public class UserController extends  RestApiMethods{
    static Faker faker = new Faker();
    private static String baseUrl = "https://reqres.in";
    private static String createUrl = "/api/users";
    private static String registrationUrl = "/api/register";

    public static User postCreate(User user){
        Response response = post(baseUrl+createUrl, user);
        if(response.statusCode()<300){
           return response.getBody().as(User.class);
        }
        throw new RuntimeException(response.getBody().as(ErrorResponse.class).getError());
    };

    public static RegistrationResponse postRegistration(User user){
        Response response = post(baseUrl+registrationUrl, user);
        if(response.statusCode()<300){
           return response.getBody().as(RegistrationResponse.class);
        }
        throw new RuntimeException(response.getBody().as(ErrorResponse.class).getError());
    };
}
