package tests.web;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import helpers.TestData;
import tests.api.api.CreateProject;
import tests.web.pages.*;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("Convert2MethodRef")
public class DeerayWebTest extends TestBase {
    final HomePage homePage = new HomePage();
    final LoginPage loginPage = new LoginPage();
    final AccountPage accountPage = new AccountPage();
    final ProfilePage profilePage = new ProfilePage();
    final TestData data = new TestData();
    CreateProject createProject = new CreateProject();
    final ProjectPage projectPage = new ProjectPage();

    @Test
    //@Tag("web")
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
    //  @Tag("web")
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
    // @Tag("web")
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

    //@Tag("web")
    @ValueSource(strings = {"Продукты", "О компании", "Исследования", "Вакансии", "Контакты"})
    @ParameterizedTest(name = "В навигационном панели присутствует элемент {0} для запроса {0}")
    void homeNavTest(String category) {
        step("Open home page", () ->
                homePage.homePageOpen());
        step("The navigation bar contains an element {0} for the request {0}", () ->
                homePage.navListCheck(category));
    }

    @Test
    @Tag("web")
    @DisplayName("Successful delete project")
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
        step("Make sure successful create project by checking the name project", () ->
                projectPage.nameProjectCheck(data.name));
    }
}
