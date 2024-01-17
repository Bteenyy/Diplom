package tests.api.api;

import config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;
import tests.api.models.AuthorizationRequestModel;
import tests.api.models.AuthorizationResponseModel;
import tests.api.models.CreateProjectRequestModel;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

public class CreateProjectApi {
    final ApiConfig config = ConfigFactory.create(ApiConfig.class);
    final AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel(config.getEmailApi(), config.getPasswordApi());
    final AuthorizationApi authorizationApi = new AuthorizationApi();
    final AuthorizationResponseModel authorizationResponseModel = authorizationApi.authorization(loginBodyModel);

    public void createProject(String description, String name) {
        CreateProjectRequestModel createProjectRequestModel = new CreateProjectRequestModel(description, name);
        given(loginTestRequestSpec)
                .header("X-Verification-Token", authorizationResponseModel.getData().getToken())
                .body(createProjectRequestModel)
                .when()
                .post("/v2/workspace/create")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().response();
    }

}
