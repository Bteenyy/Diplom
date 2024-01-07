package web.tests.web;

import org.junit.jupiter.api.Test;
import web.pages.AccountPage;
import web.pages.LoginPage;
import web.pages.HomePage;
import web.tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeerayTest extends TestBase {
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
    void successfulLoginTest1() {
        homePage.homePageOpen()
                .enterButtonClick();
        loginPage.loginDataInput("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_");

    }
    @Test
    void successfulLoginTests()
    {
        open("");
        $("a[class$='btn-demo-wr']").click();
        accountPage.checkSuccessfulLogin("rasitsahbutdinov915455@gmail.com");
    }
}
