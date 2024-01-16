package tests.api.api;

import helpers.TestData;
import tests.api.models.AuthorizationRequestModel;
import tests.api.models.AuthorizationResponseModel;
import tests.api.models.WorcspaceResponseModel;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

public class DeleteProjectApi {
    TestData data = new TestData();
    final AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel(data.email, data.password);
    final AuthorizationApi authorizationApi = new AuthorizationApi();
    final AuthorizationResponseModel authorizationResponseModel = authorizationApi.authorization(loginBodyModel);

    public WorcspaceResponseModel projectId() {
        return given(loginTestRequestSpec)
                .header("X-Verification-Token", authorizationResponseModel.getData().getToken())
                .when()
                .get("/v2/workspaces")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().as(WorcspaceResponseModel.class);
    }
}
