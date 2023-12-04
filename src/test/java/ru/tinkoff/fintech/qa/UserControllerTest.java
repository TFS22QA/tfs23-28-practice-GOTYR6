package ru.tinkoff.fintech.qa;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.tinkoff.fintech.qa.controllers.models.Response;
import ru.tinkoff.fintech.qa.controllers.models.UserEntity;

public class UserControllerTest {
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


    @ParameterizedTest
    @ValueSource(strings = {"John", "Петя", "", "123", "Вас@"})
    public void addNewUser(final String name) {
        user.setFio(name);
        Response response = RestAssured.given().contentType(ContentType.JSON).body(user)
                .post("https://petstore.swagger.io/v2/user").as(Response.class);
        String responseMessage = response.getMessage();
        Assertions.assertEquals("1", responseMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"John", "Петя"})
    public void deleteUser(final String name) {
        user.setFio(name);
        user.setUserName(name);
        user.setPassword("string");
        RestAssured.given().contentType(ContentType.JSON).body(user)
                .post("https://petstore.swagger.io/v2/user");

        RestAssured.given().contentType(ContentType.JSON).body(user)
                .get("https://petstore.swagger.io/v2/user/login").as(Response.class);

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .delete("https://petstore.swagger.io/v2/user/" + name).as(Response.class);
        Assertions.assertEquals(name, response.getMessage());
    }

}
