package tests.api.api;

import tests.api.models.AuthorizationRequestModel;
import tests.api.models.AuthorizationResponseModel;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

public class AuthorizationApi {
    public AuthorizationResponseModel authorization(String email, String password) {
        AuthorizationRequestModel authorizationRequestModel = new AuthorizationRequestModel(email, password);
        return given(loginTestRequestSpec)
                .body(authorizationRequestModel)
                .when()
                .post("/v1/account/login")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().as(AuthorizationResponseModel.class);
    }
}
