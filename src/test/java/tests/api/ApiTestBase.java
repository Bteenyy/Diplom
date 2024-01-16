package tests.api;

import com.codeborne.selenide.Configuration;
import config.WebConfig;
import helpers.TestData;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import tests.api.api.AuthorizationApi;
import tests.api.api.CreateProjectApi;
import tests.api.api.DeleteProjectApi;
import tests.api.models.AuthorizationRequestModel;
import tests.api.models.AuthorizationResponseModel;
import tests.api.models.WorcspaceResponseModel;

public class ApiTestBase {
    final TestData data = new TestData();
    final AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel(data.email, data.password);
    final AuthorizationApi authorizationApi = new AuthorizationApi();
    final AuthorizationResponseModel authorizationResponseModel = authorizationApi.authorization(loginBodyModel);
    final CreateProjectApi userApi = new CreateProjectApi();
    final DeleteProjectApi deleteProjectApi = new DeleteProjectApi();
    final WorcspaceResponseModel worcspaceResponseModel = deleteProjectApi.projectId();


    @BeforeAll
    static void beforeAll() {
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
        RestAssured.baseURI = "https://api.deeray.com";
        if (config.getRemoteUrl() != null || System.getProperty("remoteUrl") != null) {
            Configuration.remote = System.getProperty("remoteUrl", config.getRemoteUrl());
        }
    }
}
