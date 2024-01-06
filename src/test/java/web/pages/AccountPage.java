package web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AccountPage {
    SelenideElement checkSuccessfulLogin = $("div[class='View-sc-qqgzek-0 MenuItemStyled-sc-11xrj9h-0 clQVJy']");

    public AccountPage checkSuccessfulLogin(String email) {
        checkSuccessfulLogin.shouldHave(text(email));
        return this;
    }
}
