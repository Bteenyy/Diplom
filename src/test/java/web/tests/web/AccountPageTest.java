package web.tests.web;

import org.junit.jupiter.api.Test;
import web.pages.AccountPage;

import static com.codeborne.selenide.Selenide.open;

import web.pages.HomePage;
import web.tests.TestBase;

public class AccountPageTest extends TestBase {
    HomePage homePage = new HomePage();
    AccountPage accountPage = new AccountPage();

    @Test
    void successfulLoginTest() {
        homePage.homePageOpen()
                .enterButtonClick();
        accountPage.accountDataInput("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_");

    }
}
