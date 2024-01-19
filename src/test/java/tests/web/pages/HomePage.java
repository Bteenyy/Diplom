package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byText;
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

    public WebElement checkNavList(String name) {
        return navigationList.$(byText(name));
    }
}
