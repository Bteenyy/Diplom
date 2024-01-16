package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AccountPage {
    final SelenideElement checkSuccessfulLogin = $("div[class='View-sc-qqgzek-0 MenuItemStyled-sc-11xrj9h-0 clQVJy']"),
            logOut = $("svg[width='25'] use"),
            projectbut = $("div[class='View-sc-qqgzek-0 MenuItemStyled-sc-11xrj9h-0 dHrPwE']"),
            languageBar = $("div[class='View-sc-qqgzek-0 DropdownStyled-sc-1jkuymq-0 kjwpRp']"),
            enBut = $("span[class='Text-sc-kheewc-0 ZzGWa']");

    public AccountPage checkSuccessfulLogin(String email) {
        checkSuccessfulLogin.shouldHave(text(email));
        return this;
    }

    public AccountPage logOut() {
        logOut.click();
        return this;
    }

    public AccountPage loginClick() {
        checkSuccessfulLogin.click();
        return this;
    }

    public AccountPage projectButtonClick() {
        projectbut.click();
        return this;
    }

    public AccountPage changeLanguage() {
        languageBar.click();
        enBut.click();
        return this;
    }
}
