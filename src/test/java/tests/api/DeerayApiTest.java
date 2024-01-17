package tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.models.AuthorizationRequestModel;
import tests.api.models.AuthorizationResponseModel;
import tests.api.models.CreateProjectRequestModel;
import tests.api.models.CreateProjectResponseModel;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

public class DeerayApiTest extends ApiTestBase {

    @Test
    @Tag("api")
    @DisplayName("Making a successful login request")
    void successfulLoginTest() {
        AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel(data.email, data.password);
        AuthorizationResponseModel responseModel =
                step("Execute a post-request with the correct password and login and record the response.", () ->
                        given(loginTestRequestSpec)
                                .body(loginBodyModel)
                                .when()
                                .post("/v1/account/login")
                                .then()
                                .spec(loginTestResponseSpec)
                                .statusCode(200)
                                .extract().as(AuthorizationResponseModel.class));
        step("Check the successful receipt of a token", () ->
                assertFalse(responseModel.getData().getToken().isEmpty()));
    }

    @Test
    @Tag("api")
    @DisplayName("Making a unsuccessful login request")
    void unsuccessfulLoginTest() {
        AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel(data.randomEmail, data.randomPassword);
        AuthorizationResponseModel responseModel =
                step("Execute a post-request with an incorrect password and login and record the response", () ->
                        given(loginTestRequestSpec)
                                .body(loginBodyModel)
                                .when()
                                .post("/v1/account/login")
                                .then()
                                .spec(loginTestResponseSpec)
                                .statusCode(200)
                                .extract().as(AuthorizationResponseModel.class));
        step("Check that we have received an error message", () ->
                assertFalse(responseModel.getMessage().isEmpty()));
    }

    @Test
    @Tag("api")
    @DisplayName("Making a successful logout request")
    void LogoutTest() {
        AuthorizationResponseModel responseModel =
                step("Execute a post-request for logout and record the response", () ->
                        given(loginTestRequestSpec)
                                .header("X-Verification-Token", authorizationResponseModel.getData().getToken())
                                .body(loginBodyModel)
                                .when()
                                .post("v1/account/logout")
                                .then()
                                .spec(loginTestResponseSpec)
                                .statusCode(200)
                                .extract().as(AuthorizationResponseModel.class));
        step("Check the success of the request", () ->
                assertEquals(responseModel.getCode(), 0));
    }

    @Test
    @Tag("api")
    @DisplayName("Making a successful create project request")
    void createProjectTestWithSpaceAndWithoutSpace() {
        CreateProjectRequestModel createProjectRequestModel = new CreateProjectRequestModel(data.descr, data.name);
        CreateProjectResponseModel createProjectResponseModel =
                step("Execute a post-request for create project and record the response", () ->
                        given(loginTestRequestSpec)
                                .header("X-Verification-Token", authorizationResponseModel.getData().getToken())
                                .body(createProjectRequestModel)
                                .when()
                                .post("/v2/workspace/create")
                                .then()
                                .spec(loginTestResponseSpec)
                                .statusCode(200)
                                .extract().as(CreateProjectResponseModel.class));
        if (createProjectResponseModel.getCode() == 501) {
            step("Check the unsuccessful create project without space", () ->
                    userApi.createProjectWithoutSpace(createProjectRequestModel, authorizationResponseModel.getData().getToken()));
        } else
            step("Check the success create project", () ->
                    assertEquals(createProjectResponseModel.getData().getItem().getName(), "qa.quru"));
    }

    @Test
    @Tag("api")
    @DisplayName("Making a successful delete project")
    void deleteProject() {
        step("Execute a delete-request for delete project", () ->
                given(loginTestRequestSpec)
                        .header("X-Verification-Token", authorizationResponseModel.getData().getToken())
                        .body(workspaceResponseModel.getData().getItems().get(0))
                        .when()
                        .delete("/v2/workspace")
                        .then()
                        .spec(loginTestResponseSpec)
                        .statusCode(200)
                        .extract().response());
    }
}
