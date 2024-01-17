package tests.api.api;

import config.WebConfig;
import helpers.TestData;
import org.aeonbits.owner.ConfigFactory;
import tests.api.models.AuthorizationRequestModel;
import tests.api.models.AuthorizationResponseModel;
import tests.api.models.CreateProjectRequestModel;
import tests.api.models.CreateProjectResponseModel;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

public class CreateProjectApi {
    static final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
    final AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel(config.getEmail(), config.getPassword());
    final AuthorizationApi authorizationApi = new AuthorizationApi();
    final AuthorizationResponseModel authorizationResponseModel = authorizationApi.authorization(loginBodyModel);

    public void createProject() {
        CreateProjectRequestModel createProjectRequestModel = new CreateProjectRequestModel(config.getProjectDescription(), config.getProjectName());
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
                    createProjectWithoutSpace(createProjectRequestModel, authorizationResponseModel.getData().getToken()));
        } else
            step("Check the success create project", () ->
                    assertEquals(createProjectResponseModel.getData().getItem().getName(), "qa.quru"));
    }

    public void createProjectWithoutSpace(CreateProjectRequestModel createProjectRequestModel, String token) {
        CreateProjectResponseModel createProjectResponseModel = given(loginTestRequestSpec)
                .header("X-Verification-Token", token)
                .body(createProjectRequestModel)
                .when()
                .post("/v2/workspace/create")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().as(CreateProjectResponseModel.class);
        assertEquals(createProjectResponseModel.getMessage(), "Достигнут лимит на количество проектов");
    }


}
