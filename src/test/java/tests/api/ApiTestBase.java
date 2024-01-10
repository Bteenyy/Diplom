package tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import tests.TestData;
import tests.api.api.AuthorizationApi;
import tests.api.api.CreateProjectWithoutSpace;
import tests.api.models.AuthorizationRequestModel;
import tests.api.models.AuthorizationResponseModel;

public class ApiTestBase {
    TestData data = new TestData();
    AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel(data.email, data.password);
    AuthorizationApi authorizationApi = new AuthorizationApi();
    AuthorizationResponseModel authorizationResponseModel = authorizationApi.authorization(loginBodyModel);
    CreateProjectWithoutSpace userApi = new CreateProjectWithoutSpace();
    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.deeray.com";
    }
}