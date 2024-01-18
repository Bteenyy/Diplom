package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
   final SelenideElement headerName = $("span[class='Text-sc-kheewc-0 dzoeaH']"),
            emailInput = $("input[placeholder='Email']"),
            passwordInput = $("input[type='password']"),
            loginBut = $("button"),
            languageBar = $("div[class='View-sc-qqgzek-0 DropdownStyled-sc-1jkuymq-0 kjwpRp']"),
            lnBut = $("div[class='View-sc-qqgzek-0 kMhCCs']");

    public LoginPage inputLoginData(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginBut.click();
        return this;
    }

    public WebElement checkAccountBanner() {
        //headerName.shouldHave(text(text));
        return headerName;
    }
    public LoginPage changeLanguage(String language) {
        languageBar.click();
        lnBut.$(byText(language)).click();
        return this;
    }
}
