package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.deeray.com";
        Configuration.baseUrl = System.getProperty("baseUrl", config.baseUrl());
        Configuration.browser = System.getProperty("browserName", config.browser());
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion", config.version());
        Configuration.pageLoadStrategy = "eager";
        if (config.getRemoteUrl() != null) {
            Configuration.remote = config.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

 //   @AfterEach
  //  void addAttachments() {
     //   Attach.screenshotAs("Last screenshot");
     //   Attach.pageSource();
      //  Attach.browserConsoleLogs();
      //  if (config.getRemoteUrl() != null) {
      //      Attach.addVideo();
     //   }
     //   closeWebDriver();
 //   }
}
