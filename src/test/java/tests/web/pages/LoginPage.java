package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    final SelenideElement headerName = $x("//div[2]/div[2]/div[1]/span"),
            emailInput = $("input[placeholder='Email']"),
            passwordInput = $("input[type='password']"),
            loginBut = $x("//div[2]/div[4]/button/span"),
            languageBar = $x("//div[2]/div[1]/div/div"),
            lnBut = $("div[class*='kMhCCs']");

    public LoginPage inputLoginData(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginBut.click();
        return this;
    }

    public WebElement getAccountBanner() {
        return headerName;
    }

    public LoginPage changeLanguage(String language) {
        languageBar.click();
        lnBut.$(byText(language)).click();
        return this;
    }
}
