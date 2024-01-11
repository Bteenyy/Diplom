package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.TestBase;
import tests.TestData;
import tests.web.pages.AccountPage;
import tests.web.pages.HomePage;
import tests.web.pages.LoginPage;
import tests.web.pages.ProfilePage;

import static io.qameta.allure.Allure.step;

@Tag("web")
public class DeerayTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();
    ProfilePage profilePage = new ProfilePage();
    TestData data = new TestData();

    @Test
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


    @ValueSource(strings = {"Продукты", "О компании", "Исследования", "Вакансии", "Контакты"})
    @ParameterizedTest(name = "В навигационном панели присутствует элемент {0} для запроса {0}")
    void homeNavTest(String category) {
        step("Open home page", () ->
                homePage.homePageOpen());
        step("The navigation bar contains an element {0} for the request {0}", () ->
                homePage.navListCheck(category));
    }
}
