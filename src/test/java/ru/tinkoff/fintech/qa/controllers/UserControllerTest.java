package ru.tinkoff.fintech.qa.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.tinkoff.fintech.qa.controllers.models.UserEntity;

class UserControllerTest {
    public static final String BASE_URL = "http://localhost:8080/api/";

    UserEntity user;

    @BeforeEach
    public void init() {
        user = new UserEntity();
        user.setId(1);
        user.setFio("FIO");
        user.setPhone("Phone");
        user.setPasswordSeries(123213);
        user.setPasswordNumber(121231);
    }

    @Test
    void add() {
        RestAssured.given().contentType(ContentType.JSON).body(user).post(BASE_URL + "add")
                .then().statusCode(200);
    }

    @AfterEach
    public void clean(){
        RestAssured.given().contentType(ContentType.JSON).post(BASE_URL + "delete/1");
    }
}