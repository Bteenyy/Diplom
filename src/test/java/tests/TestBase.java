package tests;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.deeray.com";
        Configuration.baseUrl = "https://deeray.com/";
        Configuration.pageLoadStrategy = "eager";
}}
