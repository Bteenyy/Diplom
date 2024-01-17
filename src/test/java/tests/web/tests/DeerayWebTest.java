package tests.web.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.web.TestBase;

import static com.codeborne.selenide.Selenide.refresh;
import static io.qameta.allure.Allure.step;

public class DeerayWebTest extends TestBase {

    @Test
    @Tag("web")
    @DisplayName("Successful login on enter page")
    void successfulLoginTest() {
        step("Open home page", () ->
                homePage.homePageOpen());
        step("Click enter button", () ->
                homePage.enterButtonClick());
        step("Input account data", () ->
                loginPage.loginDataInput(data.email, data.password));
        step("Make sure successful login by checking the profile title", () ->
                accountPage.checkSuccessfulLogin(data.email));
        step("Click logout button", () ->
                accountPage.logOut());
    }

    @Test
    @Tag("web")
    @DisplayName("Successful logout from account page")
    void successfulLogoutTest() {
        step("Open home page", () ->
                homePage.homePageOpen());
        step("Click enter button", () ->
                homePage.enterButtonClick());
        step("Input account data", () ->
                loginPage.loginDataInput(data.email, data.password));
        step("Make sure successful login by checking the profile title", () ->
                accountPage.checkSuccessfulLogin(data.email));
        step("Click logout button", () ->
                accountPage.logOut());
        step("Make sure successful logout by checking the account banner", () ->
                loginPage.accountBannerCheck());
    }

    @Test
    @Tag("web")
    @DisplayName("Successful check profile header")
    void headerProfileCheck() {
        step("Open home page", () ->
                homePage.homePageOpen());
        step("Click enter button", () ->
                homePage.enterButtonClick());
        step("Input account data", () ->
                loginPage.loginDataInput(data.email, data.password));
        step("Click profile button", () ->
                accountPage.loginClick());
        step("Check profile header", () ->
                profilePage.headerProfileCheck());
        step("Click logout button", () ->
                accountPage.logOut());
    }

    @Tag("web")
    @ValueSource(strings = {"Продукты", "О компании", "Исследования", "Вакансии", "Контакты"})
    @ParameterizedTest
    void homeNavTest(String category) {
        step("Open home page", () ->
                homePage.homePageOpen());
        step("The navigation bar contains an element {0} for the request {0}", () ->
                homePage.navListCheck(category));
    }

    @CsvSource(value = {
            "EN, Entry",
            "RU, Вход",
            "FR, Inscription",
            "DE, Login"
    })
    @Tag("web")
    @DisplayName("Successful change language")
    @ParameterizedTest
    void changeLanguageTest(String language, String checkItem) {
        step("Open home page", () ->
                homePage.homePageOpen());
        step("Click enter button", () ->
                homePage.enterButtonClick());
        step("Choose language", () ->
                accountPage.changeLanguage(language));
        step("Checking header after changing language", () ->
                accountPage.changeLanguageCheck(checkItem));
    }

    @Test
    @Tag("web")
    @DisplayName("Successful create project")
    void successfulCreateProjectTest() {
        step("Open home page", () ->
                homePage.homePageOpen());
        step("Click enter button", () ->
                homePage.enterButtonClick());
        step("Input account data", () ->
                loginPage.loginDataInput(data.email, data.password));
        step("Click project button", () ->
                accountPage.projectButtonClick());
        step("Create project with api", () ->
                createProject.createProject());
        refresh();
        step("Make sure successful create project by checking the name project", () ->
                projectPage.nameProjectCheck(data.name));
    }

    @Test
    @Tag("web")
    @DisplayName("Successful delete project")
    void successfulDeleteProjectTest() {
        step("Open home page", () ->
                homePage.homePageOpen());
        step("Click enter button", () ->
                homePage.enterButtonClick());
        step("Input account data", () ->
                loginPage.loginDataInput(data.email, data.password));
        step("Click project button", () ->
                accountPage.projectButtonClick());
        step("Click project delete button", () ->
                projectPage.projectDelete());
        step("Make sure successful delete project by checking the name project must be away", () ->
                projectPage.deleteProjectCheck(data.name));
    }

}
