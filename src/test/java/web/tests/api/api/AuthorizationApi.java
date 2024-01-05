package web.tests.api.api;

import web.tests.api.models.AuthorizationResponseModel;
import web.tests.api.models.LoginBodyModel;

import static io.restassured.RestAssured.given;
import static web.tests.api.specs.Spec.loginTestRequestSpec;
import static web.tests.api.specs.Spec.loginTestResponseSpec;

public class AuthorizationApi {
    public AuthorizationResponseModel login(LoginBodyModel loginBodyModel) {
        return given(loginTestRequestSpec)
                .body(loginBodyModel)
                .when()
                .post("/v1/account/login")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().as(AuthorizationResponseModel.class);
    }
}
