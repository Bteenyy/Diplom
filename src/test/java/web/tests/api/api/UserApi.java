package web.tests.api.api;

import web.tests.api.models.CreateProjectRequestModel;
import web.tests.api.models.CreateProjectResponseModel;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static web.tests.api.specs.Spec.loginTestRequestSpec;
import static web.tests.api.specs.Spec.loginTestResponseSpec;

public class UserApi {
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
        assertFalse(createProjectResponseModel.getMessage().isEmpty());
    }
}
