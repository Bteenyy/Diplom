package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    final SelenideElement enterButton = $x("//*[contains(text(), 'Вход')]"),
            navigationList = $x("//div[2]/div/nav/ul");


    public HomePage openHomePage() {
        open("");
        return this;
    }

    public HomePage clickEnterButton() {
        enterButton.click();
        return this;
    }

    public HomePage checkNavList(String name) {
        navigationList.shouldHave(text(name));
        return this;
    }
}
