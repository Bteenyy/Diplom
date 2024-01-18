package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    final SelenideElement telField = $("div[class*='kFdMNw']");

    public ProfilePage checkHeaderProfile() {
        telField.shouldHave(text("Профиль"));
        return this;
    }
}
