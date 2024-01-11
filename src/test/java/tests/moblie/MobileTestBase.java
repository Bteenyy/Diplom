package tests.moblie;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class MobileTestBase {
    public static String deviceHost = System.getProperty("launch");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = null;
        if (deviceHost.equals("android")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else {
            Configuration.browser = LocalDriver.class.getName();
        }
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

   /// @AfterEach
    //void addAttachments() {
    ///    AttachMobile.pageSource();
     //   if (System.getProperty("launch").equals("browserstack")) {
    //        String sessionId = Selenide.sessionId().toString();
//AttachMobile.addVideo(sessionId);
       // }
       // closeWebDriver();
   // }
}
