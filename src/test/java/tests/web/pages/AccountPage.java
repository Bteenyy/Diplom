package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AccountPage {
    final SelenideElement checkSuccessfulLogin = $("div[class*='clQVJy']"),
            logOut = $("svg[width='25'] use"),
            projectButton = $("div[class*='dHrPwE']");

    public AccountPage checkSuccessfulLogin(String email) {
        checkSuccessfulLogin.shouldHave(text(email));
        return this;
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
