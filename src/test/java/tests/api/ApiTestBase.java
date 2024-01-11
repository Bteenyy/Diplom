package tests.api;

import com.codeborne.selenide.Configuration;
import config.WebConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {
    @BeforeAll
    static void beforeAll() {
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
        RestAssured.baseURI = "https://api.deeray.com";
        if (config.getRemoteUrl() != null || System.getProperty("remoteUrl") != null) {
            Configuration.remote = System.getProperty("remoteUrl", config.getRemoteUrl());
        }
    }
}
