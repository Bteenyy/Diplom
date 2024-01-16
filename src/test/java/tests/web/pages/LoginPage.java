package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    final SelenideElement headerName = $("span[class='Text-sc-kheewc-0 dzoeaH']"),
            emailInput = $("input[placeholder='Email']"),
            passwordInput = $("input[type='password']"),
            loginBut = $("button");

    public LoginPage loginDataInput(String email, String password) {
        headerName.shouldHave(text("Вход"));
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginBut.click();
        return this;
    }

    public LoginPage accountBannerCheck() {
        headerName.shouldHave(text("Вход"));
        return this;
    }
}
