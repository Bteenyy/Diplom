package tests.api.tests;

import com.codeborne.selenide.Configuration;
import config.ApiConfig;
import config.WebConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {
    static final ApiConfig config = ConfigFactory.create(ApiConfig.class);
    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = config.getBaseUriApi();
        //if (config.getRemoteUrl() != null || System.getProperty("remoteUrl") != null) {
    //        Configuration.remote = System.getProperty("remoteUrl", config.getRemoteUrl());
    //    }
    }
}
