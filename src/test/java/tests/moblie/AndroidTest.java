package tests.moblie;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.moblie.pages.GooglePage;
import tests.moblie.pages.MainPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.linkText;

@Tag("mobile")
public class AndroidTest extends MobileTestBase {
    GooglePage googlePage = new GooglePage();
    MainPage mainPage=new MainPage();
    @Test
    public void openMainPage() {
        googlePage.openMainPage();
mainPage.checkMainPage();
    }
    @Test
    public void checkSuccessfulLogin() {
        googlePage.openMainPage();
        mainPage.checkMainPage();
    }
}
