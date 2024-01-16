package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    final SelenideElement telField = $("div[class='View-sc-qqgzek-0 kFdMNw']");

    public ProfilePage headerProfileCheck() {
        telField.shouldHave(text("Профиль"));
        return this;
    }
}
