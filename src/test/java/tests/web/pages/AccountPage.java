package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AccountPage {
    final SelenideElement checkSuccessfulLogin = $("div[class='View-sc-qqgzek-0 MenuItemStyled-sc-11xrj9h-0 clQVJy']"),
            logOut = $("svg[width='25'] use"),
            projectButton = $("div[class='View-sc-qqgzek-0 MenuItemStyled-sc-11xrj9h-0 dHrPwE']"),
            languageBar = $("div[class='View-sc-qqgzek-0 DropdownStyled-sc-1jkuymq-0 kjwpRp']"),
            lnBut = $("div[class='View-sc-qqgzek-0 kMhCCs']"),
            logHeader = $("span[class='Text-sc-kheewc-0 dzoeaH']");

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

    public AccountPage changeLanguage(String language) {
        languageBar.click();
        lnBut.$(byText(language)).click();
        return this;
    }

    public AccountPage changeLanguageCheck(String text) {
        logHeader.shouldHave(text(text));
        return this;
    }
}
