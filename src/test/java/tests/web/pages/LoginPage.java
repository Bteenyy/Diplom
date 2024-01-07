package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    SelenideElement emailInput = $("input[type='text']"),
            passwordInput = $("input[type='password']"),
            loginBut = $("button"),
            errorAut = $("div[class='View-sc-qqgzek-0 hxpMcS']");

    public LoginPage loginDataInput(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginBut.click();
        return this;
    }

    public LoginPage errorMessage() {
        errorAut.shouldHave(visible);
        return this;
    }
}
