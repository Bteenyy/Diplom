package web.tests.api;

import org.junit.jupiter.api.Test;
import web.tests.api.models.AuthorizationResponseModel;
import web.tests.api.models.LoginBodyModel;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static web.tests.api.specs.Spec.loginTestRequestSpec;
import static web.tests.api.specs.Spec.loginTestResponseSpec;

public class LoginTest extends TestBase {
    @Test
    void successfulLoginTest() {
        LoginBodyModel loginBodyModel = new LoginBodyModel("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_");
        AuthorizationResponseModel responseModel =
                given(loginTestRequestSpec)
                        .body(loginBodyModel)
                        .when()
                        .post("/v1/account/login")
                        .then()
                        .spec(loginTestResponseSpec)
                        .statusCode(200)
                        .extract().as(AuthorizationResponseModel.class);
        assertFalse(responseModel.getData().getToken().isEmpty());
    }

    @Test
    void unsuccessfulLoginTest() {
        LoginBodyModel loginBodyModel = new LoginBodyModel("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_1");
        AuthorizationResponseModel responseModel =
                given(loginTestRequestSpec)
                        .body(loginBodyModel)
                        .when()
                        .post("/v1/account/login")
                        .then()
                        .spec(loginTestResponseSpec)
                        .statusCode(200)
                        .extract().as(AuthorizationResponseModel.class);
        assertFalse(responseModel.getMessage().isEmpty());
        assertEquals(responseModel.getCode(), 101);
    }

}
