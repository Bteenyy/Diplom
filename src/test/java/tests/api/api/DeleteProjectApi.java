package tests.api.api;

import tests.api.models.WorkspaceResponseModel;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

public class DeleteProjectApi {
    public void deleteProject(String token) {
        given(loginTestRequestSpec)
                .header("X-Verification-Token", token)
                .body(projectId(token).getData().getItems().get(0))
                .when()
                .delete("/v2/workspace")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().response();
    }

    public WorkspaceResponseModel projectId(String token) {
        return given(loginTestRequestSpec)
                .header("X-Verification-Token", token)
                .when()
                .get("/v2/workspaces")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().as(WorkspaceResponseModel.class);
    }


}
