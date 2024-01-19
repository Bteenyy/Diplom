package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    final SelenideElement telField = $x("//*[contains(text(), 'Профиль')]");

    public WebElement getHeaderProfile() {
        return telField;
    }
}
