package web.tests.api;

import org.junit.jupiter.api.Test;
import web.tests.api.api.AuthorizationApi;
import web.tests.api.models.AuthorizationResponseModel;
import web.tests.api.models.CreateProjectResponseModel;
import web.tests.api.models.CreateProjectRequestModel;
import web.tests.api.models.AuthorizationRequestModel;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static web.tests.api.specs.Spec.loginTestRequestSpec;
import static web.tests.api.specs.Spec.loginTestResponseSpec;

public class ProjectTest extends TestBase {
    AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_");
    CreateProjectRequestModel createProjectBodyModel = new CreateProjectRequestModel("diplom","qa.quru");
    AuthorizationApi authorizationApi = new AuthorizationApi();
    AuthorizationResponseModel authorizationResponseModel = authorizationApi.login(loginBodyModel);
    @Test
    void createProjectTest() {

        CreateProjectResponseModel response =
                given(loginTestRequestSpec)
                        .header("X-Verification-Token", authorizationResponseModel.getData().getToken())
                        .body(createProjectBodyModel)
                        .when()
                        .post("/v2/workspace/create")
                        .then()
                        .spec(loginTestResponseSpec)
                        .statusCode(200)
                        .extract().as(CreateProjectResponseModel.class);
        assertEquals(response.getData().getItem().getName(), "qa.quru");
    }
    @Test
    void deleteProjectTest() {
        CreateProjectResponseModel response =
                given(loginTestRequestSpec)
                        .header("X-Verification-Token", authorizationResponseModel.getData().getToken())
                        .body(createProjectBodyModel)
                        .when()
                        .delete("/v2/workspace")
                        .then()
                        .spec(loginTestResponseSpec)
                        .statusCode(200)
                        .extract().as(CreateProjectResponseModel.class);
        assertEquals(response.getData().getItem().getName(), "qa.quru");
    }
}
