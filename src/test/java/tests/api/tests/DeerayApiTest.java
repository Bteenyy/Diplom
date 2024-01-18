package tests.api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.api.AuthorizationApi;
import tests.api.api.CreateProjectApi;
import tests.api.api.DeleteProjectApi;
import tests.api.api.LogoutApi;
import tests.api.models.AuthorizationResponseModel;
import tests.api.models.CreateProjectResponseModel;
import tests.api.models.DeleteProjectResponseModel;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeerayApiTest extends ApiTestBase {
    final AuthorizationApi authorizationApi = new AuthorizationApi();
    final AuthorizationResponseModel authorizationResponseModel = authorizationApi.authorization(config.getEmailApi(), config.getPasswordApi());

    @Test
    @Tag("api")
    @DisplayName("Making a successful login request")
    void successfulLoginTest() {
        AuthorizationResponseModel responseModel = step("Execute a post-request with correct password and login and record the response", () ->
                authorizationApi.authorization(config.getEmailApi(), config.getPasswordApi()));
        step("Check that the received token has 128 characters", () ->
                assertEquals(responseModel.getData().getToken().length(), 128));
    }

    @Test
    @Tag("api")
    @DisplayName("Making a unsuccessful login request")
    void unsuccessfulLoginTest() {
        AuthorizationResponseModel responseModel =
                step("Execute a post-request with an incorrect password and login and record the response", () ->
                        authorizationApi.authorization(data.randomEmail, data.randomPassword));
        step("Check that we have received an error message", () ->
                assertEquals(responseModel.getMessage().length(), 18));
    }


    @Test
    @Tag("api")
    @DisplayName("Making a successful logout request")
    void LogoutTest() {
        AuthorizationResponseModel responseModel =
                step("Execute a post-request for logout and record the response", () ->
                        new LogoutApi().logout(authorizationResponseModel));
        step("Check the success of the request", () ->
                assertEquals(responseModel.getCode(), 0));
    }

    @Test
    @Tag("api")
    @DisplayName("Making a successful create project request")
    void createProjectTest() {
        DeleteProjectApi deleteProjectApi = new DeleteProjectApi();
        deleteProjectApi.deleteProject(authorizationResponseModel);
        CreateProjectResponseModel createProjectResponseModel =
                step("Execute a post-request for create project and record the response", () ->
                        new CreateProjectApi().createProject(config.getProjectDescriptionApi(), config.getProjectNameApi(), authorizationResponseModel));
        step("Check the success create project", () ->
                assertEquals(createProjectResponseModel.getData().getItem().getName(), config.getProjectNameApi()));
    }

    @Test
    @Tag("api")
    @DisplayName("Making delete project wihen you have one project in workspace")
    void deleteProjectTest() {
        DeleteProjectApi deleteProjectApi = new DeleteProjectApi();
        deleteProjectApi.deleteProject(authorizationResponseModel);
        DeleteProjectResponseModel deleteProjectResponseModel =
                step("Execute a delete-request for delete project", () ->
                        deleteProjectApi.deleteProject(authorizationResponseModel));
        step("Make sure we receive the warning message", () ->
                assertEquals(deleteProjectResponseModel.getMessage(), "Нельзя удалить последний проект в личном кабинете"));
    }
}
