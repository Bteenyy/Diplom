package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.LocalDeviceDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class MobileTestBase {
    @BeforeAll
    static void beforeAll() {

        if (System.getProperty("launchMob").equals("browserstack"))
            Configuration.browser = BrowserstackDriver.class.getName();
        else if (System.getProperty("launchMob").equals("emulator"))
            Configuration.browser = LocalDeviceDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        Attach.pageSource();
        if (System.getProperty("launchMob").equals("browserstack")) {
            String sessionId = Selenide.sessionId().toString();
            Attach.addVideo(sessionId);
        }
        closeWebDriver();
    }
}
