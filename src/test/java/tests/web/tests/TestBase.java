package tests.web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import helpers.Attach;
import helpers.TestData;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.api.api.CreateProjectApi;
import tests.web.pages.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    static final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    final HomePage homePage = new HomePage();
    final LoginPage loginPage = new LoginPage();
    final AccountPage accountPage = new AccountPage();
    final ProfilePage profilePage = new ProfilePage();
    final CreateProjectApi createProject = new CreateProjectApi();
    final ProjectPage projectPage = new ProjectPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://deeray.com/";
        RestAssured.baseURI = "https://api.deeray.com";
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.remote = config.getRemoteUrl();
        Configuration.pageLoadStrategy = "eager";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}

