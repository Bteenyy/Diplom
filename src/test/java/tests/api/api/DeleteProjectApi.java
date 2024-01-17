package tests.api.api;

import config.ApiConfig;
import config.WebConfig;
import helpers.TestData;
import org.aeonbits.owner.ConfigFactory;
import tests.api.models.AuthorizationRequestModel;
import tests.api.models.AuthorizationResponseModel;
import tests.api.models.WorkspaceResponseModel;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

public class DeleteProjectApi {
    final ApiConfig config = ConfigFactory.create(ApiConfig.class);
    final AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel(config.getEmailApi(), config.getPasswordApi());
    final AuthorizationApi authorizationApi = new AuthorizationApi();
    final AuthorizationResponseModel authorizationResponseModel = authorizationApi.authorization(loginBodyModel);

    public WorkspaceResponseModel projectId() {
        return given(loginTestRequestSpec)
                .header("X-Verification-Token", authorizationResponseModel.getData().getToken())
                .when()
                .get("/v2/workspaces")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().as(WorkspaceResponseModel.class);
    }
}
