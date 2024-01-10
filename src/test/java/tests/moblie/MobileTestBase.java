package tests.moblie;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.EmulatorDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.TestData;
import tests.moblie.pages.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class MobileTestBase {
    GooglePage googlePage = new GooglePage();
    MainPage mainPage = new MainPage();
    CompanyPage companyPage = new CompanyPage();
    EnterPage enterPage = new EnterPage();
    AccountPage accountPage = new AccountPage();
    TestData data = new TestData();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = EmulatorDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }
    @AfterEach
    void addAttachments() {
        Attach.pageSource();
        closeWebDriver();
    }
}
