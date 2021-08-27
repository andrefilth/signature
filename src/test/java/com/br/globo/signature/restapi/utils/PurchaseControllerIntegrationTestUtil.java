package com.br.globo.signature.restapi.utils;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class PurchaseControllerIntegrationTestUtil {

    public static ValidatableResponse requestLogin() {
        return given()
                .log().all()
                .contentType(JSON)
                .get("purchases")
                .then()
                ;
    }
}
