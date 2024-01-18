package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AccountPage {

    static final SelenideElement checkSuccessfulLogin = $("div[class*='lhPzUu']"),
            logOut = $("svg[width='25'] use"),
            projectButton = $("span[class*='ffOqsC']");

    //  public AccountPage checkSuccessfulLogin(String email) {
    //  checkSuccessfulLogin.shouldHave(text(email));
    //   return this;
    //}
    public WebElement checkSuccessfulLogin() {
        return checkSuccessfulLogin;
    }


    public AccountPage clickLogoutButton() {
        logOut.click();
        return this;
    }

    public AccountPage clickLoginButton() {
        checkSuccessfulLogin.click();
        return this;
    }

    public AccountPage clickProjectButton() {
        projectButton.click();
        return this;
    }


}
