package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
   final SelenideElement headerName = $("span[class*='dzoeaH']"),
            emailInput = $("input[placeholder='Email']"),
            passwordInput = $("input[type='password']"),
            loginBut = $("button"),
            languageBar = $("div[class*='kjwpRp']"),
            lnBut = $("div[class*='kMhCCs']");

    public LoginPage inputLoginData(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginBut.click();
        return this;
    }

    public WebElement checkAccountBanner() {
        return headerName;
    }
    public LoginPage changeLanguage(String language) {
        languageBar.click();
        lnBut.$(byText(language)).click();
        return this;
    }
}
