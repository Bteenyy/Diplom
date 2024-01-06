package web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    SelenideElement enterButton = $("div[class='header-login'] a");

    public HomePage homePageOpen() {
        open("");
        return this;
    }

    public HomePage enterButtonClick() {
        enterButton.click();
        return this;
    }
}
