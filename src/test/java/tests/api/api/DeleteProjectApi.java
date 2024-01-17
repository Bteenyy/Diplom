package tests.api.api;

import tests.api.models.AuthorizationResponseModel;
import tests.api.models.DeleteProjectResponseModel;
import tests.api.models.WorkspaceResponseModel;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

public class DeleteProjectApi {
    public DeleteProjectResponseModel deleteProject(AuthorizationResponseModel token) {
        return given(loginTestRequestSpec)
                .header("X-Verification-Token", token.getData().getToken())
                .body(projectId(token).getData().getItems().get(0))
                .when()
                .delete("/v2/workspace")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().as(DeleteProjectResponseModel.class);
    }

    public WorkspaceResponseModel projectId(AuthorizationResponseModel token) {
        return given(loginTestRequestSpec)
                .header("X-Verification-Token", token.getData().getToken())
                .when()
                .get("/v2/workspaces")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().as(WorkspaceResponseModel.class);
    }


}
