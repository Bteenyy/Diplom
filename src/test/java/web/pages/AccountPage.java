package web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AccountPage {
SelenideElement emailInput = $("input[placeholder='Email']"),
    passwordInput = $("input[type='password']"),
    loginBut= $("button");
    public AccountPage accountDataInput(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginBut.click();
        return this;
    }
}
