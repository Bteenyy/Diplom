package web.tests.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAff() {
        RestAssured.baseURI = "https://api.deeray.com";
}}
