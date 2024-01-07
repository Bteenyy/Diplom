package tests.api.api;

import tests.api.models.AuthorizationResponseModel;
import tests.api.models.AuthorizationRequestModel;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

public class AuthorizationApi {
    public AuthorizationResponseModel authorization(AuthorizationRequestModel loginBodyModel) {
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
