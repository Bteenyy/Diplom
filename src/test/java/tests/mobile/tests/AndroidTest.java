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
    final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
    final TestData data = new TestData();

    @SuppressWarnings("Convert2MethodRef")
    @Test
    @Tag("android")
    @DisplayName("Successful open website Deeray.com")
    public void MainPageTest() {
        step("Open website Deeray.com", () ->
                googlePage.openMainPage());
        step("Check main page banner", () ->
                mainPage.checkMainPage());
    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    @Tag("android")
    @DisplayName("Successful open company page")
    public void CompanyPageTest() {
        step("Open website Deeray.com", () ->
                googlePage.openMainPage());
        step("Click on the company button", () -> {
            mainPage.checkMainPage()
                    .clickCompanyButton();
        });
        step("Check company page banner", () ->
                companyPage.checkCompanyBanner());
    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    @Tag("android")
    @DisplayName("Successful login on enter page")
    public void successfulLoginTest() {
        step("Open website Deeray.com", () ->
                googlePage.openMainPage());
        step("Click on the enter button", () -> {
            mainPage.checkMainPage()
                    .clickEnterButton();
        });
        step("Input correct email and password for successful login", () ->
                enterPage.insertInputData(config.getEmail(), config.getPassword()));
        step("Make sure successful login by checking the profile title", () ->
                accountPage.checkAccountHeader());
    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    @Tag("android")
    @DisplayName("Unsuccessful login on enter page")
    public void unsuccessfulLoginTest() {
        step("Open website Deeray.com", () ->
                googlePage.openMainPage());
        step("Click on the enter button", () -> {
            mainPage.checkMainPage()
                    .clickEnterButton();
        });
        step("Input incorrect email and password for unsuccessful login", () ->
                enterPage.insertInputData(data.randomEmail, data.randomPassword));
        step("Make sure unsuccessful login by checking error message", () ->
                enterPage.checkErrorMessage());
    }

}