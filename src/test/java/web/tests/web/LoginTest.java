package web.tests.web;

import org.junit.jupiter.api.Test;
import web.pages.AccountPage;
import web.pages.LoginPage;
import web.pages.HomePage;
import web.tests.TestBase;

public class LoginTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();

    @Test
    void successfulLoginTest() {
        homePage.homePageOpen()
                .enterButtonClick();
        loginPage.loginDataInput("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_");
        accountPage.checkSuccessfulLogin("rasitsahbutdinov915455@gmail.com");
    }
    @Test
    void unsuccessfulLoginTest() {
        homePage.homePageOpen()
                .enterButtonClick();
        loginPage.loginDataInput("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_1")
                .errorMessage();
    }
}
