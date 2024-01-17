package tests.api.tests;

import config.ApiConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {
    static final ApiConfig config = ConfigFactory.create(ApiConfig.class);

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = config.getBaseUriApi();
    }
}
