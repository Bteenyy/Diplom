package tests.web;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.TestBase;
import tests.web.pages.AccountPage;
import tests.web.pages.HomePage;
import tests.web.pages.LoginPage;
import tests.web.pages.ProfilePage;

@Tag("web")
public class DeerayTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();
    ProfilePage profilePage = new ProfilePage();

    @Test
    void successfulLoginTest() {
        homePage.homePageOpen()
                .enterButtonClick();
        loginPage.loginDataInput("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_");
        accountPage.checkSuccessfulLogin("rasitsahbutdinov915455@gmail.com")
                .logOut();
    }
    @Test
    void successfulLogoutTest() {
        homePage.homePageOpen()
                .enterButtonClick();
        loginPage.loginDataInput("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_");
        accountPage.checkSuccessfulLogin("rasitsahbutdinov915455@gmail.com")
                .logOut();
    }

    @Test
    void headerProfileCheck() {
        homePage.homePageOpen()
                .enterButtonClick();
        loginPage.loginDataInput("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_");
        accountPage.loginClick();
        profilePage.headerProfileCheck();
        accountPage.logOut();
    }


    @ValueSource(strings = {"Продукты", "О компании", "Исследования", "Вакансии", "Контакты"})
    @ParameterizedTest(name = "В навигационном панели присутствует элемент {0} для запроса {0}")
    void homeNavTest(String category) {
        homePage.homePageOpen()
                .navListCheck(category);
    }
}
