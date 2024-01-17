package tests.web.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.api.api.CreateProjectApi;
import tests.web.pages.*;

import static com.codeborne.selenide.Selenide.refresh;
import static io.qameta.allure.Allure.step;

public class DeerayWebTest extends TestBase {

    final HomePage homePage = new HomePage();
    final LoginPage loginPage = new LoginPage();
    final AccountPage accountPage = new AccountPage();
    final ProfilePage profilePage = new ProfilePage();
    final CreateProjectApi createProject = new CreateProjectApi();
    final ProjectPage projectPage = new ProjectPage();


    @Test
    @Tag("web")
    @DisplayName("Successful login on enter page")
    void successfulLoginTest() {
        step("Open home page", () ->
                homePage.openHomePage());
        step("Click enter button", () ->
                homePage.clickEnterButton());
        step("Input account data", () ->
                loginPage.inputLoginData(config.getEmailWeb(), config.getPasswordWeb()));
        step("Make sure successful login by checking the profile title", () ->
                accountPage.checkSuccessfulLogin(config.getEmailWeb()));
        step("Click logout button", () ->
                accountPage.clickLogoutButton());
    }

    @Test
    //  @Tag("web")
    @DisplayName("Successful logout from account page")
    void successfulLogoutTest() {
        step("Open home page", () ->
                homePage.openHomePage());
        step("Click enter button", () ->
                homePage.clickEnterButton());
        step("Input account data", () ->
                loginPage.inputLoginData(config.getEmailWeb(), config.getPasswordWeb()));
        step("Make sure successful login by checking the profile title", () ->
                accountPage.checkSuccessfulLogin(config.getEmailWeb()));
        step("Click logout button", () ->
                accountPage.clickLogoutButton());
        step("Make sure successful logout by checking the account banner", () ->
                loginPage.checkAccountBanner("Вход"));
    }

    @Test
    //  @Tag("web")
    @DisplayName("Successful check profile header")
    void headerProfileCheck() {
        step("Open home page", () ->
                homePage.openHomePage());
        step("Click enter button", () ->
                homePage.clickEnterButton());
        step("Input account data", () ->
                loginPage.inputLoginData(config.getEmailWeb(), config.getPasswordWeb()));
        step("Click profile button", () ->
                accountPage.clickLoginButton());
        step("Check profile header", () ->
                profilePage.checkHeaderProfile());
        step("Click logout button", () ->
                accountPage.clickLogoutButton());
    }

    // @Tag("web")
    @ValueSource(strings = {"Продукты", "О компании", "Исследования", "Вакансии", "Контакты"})
    @ParameterizedTest
    void homeNavTest(String category) {
        step("Open home page", () ->
                homePage.openHomePage());
        step("The navigation bar contains an element {0} for the request {0}", () ->
                homePage.checkNavList(category));
    }

    @CsvSource(value = {
            "EN, Entry",
            "RU, Вход",
            "FR, Inscription",
            "DE, Login"
    })
    //  @Tag("web")
    @DisplayName("Successful change language")
    @ParameterizedTest
    void changeLanguageTest(String language, String checkItem) {
        step("Open home page", () ->
                homePage.openHomePage());
        step("Click enter button", () ->
                homePage.clickEnterButton());
        step("Choose language", () ->
                loginPage.changeLanguage(language));
        step("Checking header after changing language", () ->
                loginPage.checkAccountBanner(checkItem));
    }

    @Test
    // @Tag("web")
    @DisplayName("Successful create project")
    void successfulCreateProjectTest() {
        step("Open home page", () ->
                homePage.openHomePage());
        step("Click enter button", () ->
                homePage.clickEnterButton());
        step("Input account data", () ->
                loginPage.inputLoginData(config.getEmailWeb(), config.getPasswordWeb()));
        step("Click project button", () ->
                accountPage.clickProjectButton());
        step("Create project with api", () ->
                createProject.createProject());
        refresh();
        step("Make sure successful create project by checking the name project", () ->
                projectPage.checkNameProject(config.getProjectNameWeb()));
    }

    @Test
    // @Tag("web")
    @DisplayName("Successful delete project")
    void successfulDeleteProjectTest() {
        step("Open home page", () ->
                homePage.openHomePage());
        step("Click enter button", () ->
                homePage.clickEnterButton());
        step("Input account data", () ->
                loginPage.inputLoginData(config.getEmailWeb(), config.getPasswordWeb()));
        step("Click project button", () ->
                accountPage.clickProjectButton());
        step("Click project delete button", () ->
                projectPage.deleteProject());
        step("Make sure successful delete project by checking the name project must be away", () ->
                projectPage.checkDeleteProject(config.getProjectNameWeb()));
    }

}
