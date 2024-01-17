package tests.mobile.tests;

import config.WebConfig;
import helpers.TestData;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.mobile.pages.*;

import static io.qameta.allure.Allure.step;


@SuppressWarnings("ALL")
public class AndroidTest extends MobileTestBase {
    final GooglePage googlePage = new GooglePage();
    final MainPage mainPage = new MainPage();
    final CompanyPage companyPage = new CompanyPage();
    final EnterPage enterPage = new EnterPage();
    final AccountPage accountPage = new AccountPage();
    static final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
    final TestData data = new TestData();

    @SuppressWarnings("Convert2MethodRef")
    @Test
    @Tag("android")
    @DisplayName("Successful open website Deeray.com")
    public void MainPageTest() {
        step("Open website Deeray.com", () ->
                googlePage.mainPageOpen());
        step("Check main page banner", () ->
                mainPage.mainPageCheck());
    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    @Tag("android")
    @DisplayName("Successful open company page")
    public void CompanyPageTest() {
        step("Open website Deeray.com", () ->
                googlePage.mainPageOpen());
        step("Click on the company button", () -> {
            mainPage.mainPageCheck()
                    .companyButClick();
        });
        step("Check company page banner", () ->
                companyPage.companyBannerCheck());
    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    @Tag("android")
    @DisplayName("Successful login on enter page")
    public void successfulLoginTest() {
        step("Open website Deeray.com", () ->
                googlePage.mainPageOpen());
        step("Click on the enter button", () -> {
            mainPage.mainPageCheck()
                    .enterButClick();
        });
        step("Input correct email and password for successful login", () ->
                enterPage.enterDataInput(config.getEmail(), config.getPassword()));
        step("Make sure successful login by checking the profile title", () ->
                accountPage.accountHeaderCheck());
    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    @Tag("android")
    @DisplayName("Unsuccessful login on enter page")
    public void unsuccessfulLoginTest() {
        step("Open website Deeray.com", () ->
                googlePage.mainPageOpen());
        step("Click on the enter button", () -> {
            mainPage.mainPageCheck()
                    .enterButClick();
        });
        step("Input incorrect email and password for unsuccessful login", () ->
                enterPage.enterDataInput(data.randomEmail, data.randomPassword));
        step("Make sure unsuccessful login by checking error message", () ->
                enterPage.errorMessageCheck());
    }

}