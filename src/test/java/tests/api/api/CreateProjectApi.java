package tests.api.api;

import tests.api.models.AuthorizationResponseModel;
import tests.api.models.CreateProjectRequestModel;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

public class CreateProjectApi {
    public void createProject(String description, String name, AuthorizationResponseModel token) {
        CreateProjectRequestModel createProjectRequestModel = new CreateProjectRequestModel(description, name);
        given(loginTestRequestSpec)
                .header("X-Verification-Token", token)
                .body(createProjectRequestModel)
                .when()
                .post("/v2/workspace/create")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().response();
    }

}
