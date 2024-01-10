package tests.api;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.models.AuthorizationRequestModel;
import tests.api.models.AuthorizationResponseModel;
import tests.api.models.CreateProjectRequestModel;
import tests.api.models.CreateProjectResponseModel;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

@Tag("api")
public class LoginTest extends ApiTestBase {
    @Test
    @Story("Testing of successful login using method POST")
    void successfulLoginTest() {
        AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel(data.email, data.password);
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
        AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel(data.randomEmail, data.randomPassword);
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

    @Test
    void createProjectTestWithSpaceAndWithoutSpace() {
        CreateProjectRequestModel createProjectRequestModel = new CreateProjectRequestModel("Diplom", "qa.quru");
        CreateProjectResponseModel createProjectResponseModel = given(loginTestRequestSpec)
                .header("X-Verification-Token", authorizationResponseModel.getData().getToken())
                .body(createProjectRequestModel)
                .when()
                .post("/v2/workspace/create")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().as(CreateProjectResponseModel.class);
        if (createProjectResponseModel.getCode() == 501) {
            userApi.createProjectWithoutSpace(createProjectRequestModel, authorizationResponseModel.getData().getToken());
        } else
            assertEquals(createProjectResponseModel.getData().getItem().getName(), "qa.quru");
    }

}
