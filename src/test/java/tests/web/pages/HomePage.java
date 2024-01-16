package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
   final SelenideElement enterButton = $("div[class='header-login'] a"),
            navigationList = $("nav[class*='t-inline'] ul[class*='nav-menu']");

    public HomePage homePageOpen() {
        open("");
        return this;
    }

    public HomePage enterButtonClick() {
        enterButton.click();
        return this;
    }

    public HomePage navListCheck(String name) {
        navigationList.shouldHave(text(name));
        return this;
    }
}
