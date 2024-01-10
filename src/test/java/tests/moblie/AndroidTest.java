package tests.moblie;

import com.codeborne.selenide.Condition;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.moblie.pages.*;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

@Tag("mobile")
public class AndroidTest extends MobileTestBase {
    GooglePage googlePage = new GooglePage();
    MainPage mainPage = new MainPage();
    CompanyPage companyPage = new CompanyPage();
    EnterPage enterPage = new EnterPage();
    AccountPage accountPage = new AccountPage();

    @Test
    public void MainPageTest() {
        googlePage.mainPageOpen("deeray.com");
        mainPage.mainPageCheck();
    }

    @Test
    public void CompanyPageTest() {
        googlePage.mainPageOpen("deeray.com");
        mainPage.mainPageCheck()
                .companyButClick();
        companyPage.companyBannerCheck();
    }

    @Test
    public void successfulLoginTest() {
        googlePage.mainPageOpen("deeray.com");
        mainPage.mainPageCheck()
                .enterButClick();
        enterPage.enterDataInput("rasitsahbutdinov915455@gmail.com", "mdf9MsZs2bbM7kq_");
        accountPage.accountHeaderCheck();
    }
}
