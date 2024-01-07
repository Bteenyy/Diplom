package tests.api;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.api.api.AuthorizationApi;
import tests.api.models.AuthorizationResponseModel;
import tests.api.models.AuthorizationRequestModel;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

@Tag("api")
public class LoginTest extends TestBase {
    AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_");
    AuthorizationApi authorizationApi = new AuthorizationApi();
    AuthorizationResponseModel authorizationResponseModel = authorizationApi.authorization(loginBodyModel);

    @Test
    @Story("Testing of successful login using method POST")
    @Tag("positive")
    void successfulLoginTest() {
        AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_");
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
        AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_1");
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

    @Test
    void LogoutTest() {
        AuthorizationResponseModel responseModel =
                given(loginTestRequestSpec)
                        .header("X-Verification-Token", authorizationResponseModel.getData().getToken())
                        .body(loginBodyModel)
                        .when()
                        .post("v1/account/logout")
                        .then()
                        .spec(loginTestResponseSpec)
                        .statusCode(200)
                        .extract().as(AuthorizationResponseModel.class);
        assertEquals(responseModel.getCode(), 0);
    }

}
