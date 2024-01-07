package tests.api;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.api.api.AuthorizationApi;
import tests.api.api.UserApi;
import tests.api.models.AuthorizationResponseModel;
import tests.api.models.CreateProjectResponseModel;
import tests.api.models.CreateProjectRequestModel;
import tests.api.models.AuthorizationRequestModel;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static tests.api.specs.Spec.loginTestRequestSpec;
import static tests.api.specs.Spec.loginTestResponseSpec;

@Tag("api")
public class ProjectTest extends TestBase {
    AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_");
    AuthorizationApi authorizationApi = new AuthorizationApi();
    AuthorizationResponseModel authorizationResponseModel = authorizationApi.authorization(loginBodyModel);
    UserApi userApi = new UserApi();

    @Test
    void createProjectTestWithSpaceAndWithoutSpace() {
        CreateProjectRequestModel createProjectRequestModel = new CreateProjectRequestModel("Diplom", "qa.quru");
        CreateProjectResponseModel createProjectResponseModel = given(loginTestRequestSpec)
                .header("X-Verification-Token", authorizationResponseModel.getData().getToken())
                .body(createProjectRequestModel)
                .when()
                .post("/v2/workspace/create")
                .then()
                .spec(loginTestResponseSpec)
                .statusCode(200)
                .extract().as(CreateProjectResponseModel.class);
        if (createProjectResponseModel.getCode() == 501) {
            userApi.createProjectWithoutSpace(createProjectRequestModel, authorizationResponseModel.getData().getToken());
        } else
            assertEquals(createProjectResponseModel.getData().getItem().getName(), "qa.quru");
    }
}
