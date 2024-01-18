package tests.api.api;

import tests.api.models.AuthorizationResponseModel;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

public class LogoutApi {
    public AuthorizationResponseModel logout(AuthorizationResponseModel token) {
        return given(loginTestRequestSpec)
                .header("X-Verification-Token", token.getData().getToken())
                .when()
                .post("v1/account/logout")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().as(AuthorizationResponseModel.class);
    }
}
