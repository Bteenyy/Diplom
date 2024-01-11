package tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import helpers.TestData;
import tests.mobile.pages.*;

import static io.qameta.allure.Allure.step;


public class AndroidTest extends MobileTestBase {
    GooglePage googlePage = new GooglePage();
    MainPage mainPage = new MainPage();
    CompanyPage companyPage = new CompanyPage();
    EnterPage enterPage = new EnterPage();
    AccountPage accountPage = new AccountPage();
    TestData data = new TestData();

    @Test
    @Tag("android")
    @DisplayName("Successful open website Deeray.com")
    public void MainPageTest() {
        step("Open website Deeray.com", () ->
                googlePage.mainPageOpen());
        step("Check main page banner", () ->
                mainPage.mainPageCheck());
    }

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
                enterPage.enterDataInput(data.email, data.password));
        step("Make sure successful login by checking the profile title", () ->
                accountPage.accountHeaderCheck());
    }

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