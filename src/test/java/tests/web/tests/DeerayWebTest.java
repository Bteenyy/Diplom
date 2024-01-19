package tests.web.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.api.api.AuthorizationApi;
import tests.api.api.CreateProjectApi;
import tests.api.api.DeleteProjectApi;
import tests.web.pages.*;

import static com.codeborne.selenide.Selenide.refresh;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DeerayWebTest extends TestBase {
    final HomePage homePage = new HomePage();
    final LoginPage loginPage = new LoginPage();
    final AccountPage accountPage = new AccountPage();
    final ProfilePage profilePage = new ProfilePage();
    final CreateProjectApi createProject = new CreateProjectApi();
    final ProjectPage projectPage = new ProjectPage();


    @Test
    @Tag("web")
    @DisplayName("Successful login")
    void successfulLoginTest() {
        step("Open home page", homePage::openHomePage);
        step("Click enter button", homePage::clickEnterButton);
        step("Input account data", () ->
                loginPage.inputLoginData(config.getEmailWeb(), config.getPasswordWeb()));
        step("Make sure successful login by checking the profile title", () ->
                assertEquals(accountPage.checkSuccessfulLogin().getText(), config.getEmailWeb()));
        step("Click logout button", accountPage::clickLogoutButton);
    }

    @Test
    @Tag("web")
    @DisplayName("Successful logout")
    void successfulLogoutTest() {
        step("Open home page", homePage::openHomePage);
        step("Click enter button", homePage::clickEnterButton);
        step("Input account data", () ->
                loginPage.inputLoginData(config.getEmailWeb(), config.getPasswordWeb()));
        step("Click logout button", accountPage::clickLogoutButton);
        step("Make sure successful logout by checking the account banner", () ->
                assertEquals(loginPage.checkAccountBanner().getText(), "Вход"));
    }

    @Test
    @Tag("web")
    @DisplayName("Successful check profile header")
    void headerProfileCheckTest() {
        step("Open home page", homePage::openHomePage);
        step("Click enter button", homePage::clickEnterButton);
        step("Input account data", () ->
                loginPage.inputLoginData(config.getEmailWeb(), config.getPasswordWeb()));
        step("Click profile button", accountPage::clickLoginButton);
        step("Check profile header", () ->
                assertEquals(profilePage.checkHeaderProfile().getText(), "Профиль"));
        step("Click logout button", accountPage::clickLogoutButton);
    }

    @Tag("web")
    @ValueSource(strings = {"Продукты", "О компании", "Исследования", "Вакансии", "Контакты"})
    @ParameterizedTest
    void homeNavTest(String category) {
        step("Open home page", homePage::openHomePage);
        step("The navigation bar contains an element {0} for the request {0}", () ->
                homePage.checkNavList(category));
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
        step("Open home page", homePage::openHomePage);
        step("Click enter button", homePage::clickEnterButton);
        step("Choose language", () ->
                loginPage.changeLanguage(language));
        step("Checking header after changing language", () ->
                assertEquals(loginPage.checkAccountBanner().getText(), checkItem));
    }

    @Test
    @Tag("web")
    @DisplayName("Successful create project")
    void successfulCreateProjectTest() {
        AuthorizationApi authorizationApi = new AuthorizationApi();
        DeleteProjectApi deleteProjectApi = new DeleteProjectApi();
        deleteProjectApi.deleteProject(authorizationApi.authorization(config.getEmailWeb(), config.getPasswordWeb()));
        step("Open home page", homePage::openHomePage);
        step("Click enter button", homePage::clickEnterButton);
        step("Input account data", () ->
                loginPage.inputLoginData(config.getEmailWeb(), config.getPasswordWeb()));
        step("Click project button", accountPage::clickProjectButton);
        step("Create project with api", () ->
                createProject.createProject(config.getProjectDescriptionWeb(), config.getProjectNameWeb(), authorizationApi.authorization(config.getEmailWeb(), config.getPasswordWeb())));
        refresh();
        step("Make sure successful create project by checking the name project", () ->
                assertEquals(projectPage.checkNameProject().getText(), config.getProjectNameWeb()));
    }

    @Test
    @Tag("web")
    @DisplayName("Successful delete project")
    void successfulDeleteProjectTest() {
        step("Open home page", homePage::openHomePage);
        step("Click enter button", homePage::clickEnterButton);
        step("Input account data", () ->
                loginPage.inputLoginData(config.getEmailWeb(), config.getPasswordWeb()));
        step("Click project button", accountPage::clickProjectButton);
        step("Click project delete button", projectPage::deleteProject);
        step("Make sure successful delete project by checking the name project must be away", () ->
                assertFalse(projectPage.checkNameProject().isDisplayed()));
    }

}
