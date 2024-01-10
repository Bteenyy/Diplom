package tests.moblie.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;

public class AccountPage {
    SelenideElement emailHeader = $x("//android.widget.TextView[@text=\"rasitsahbutdinov915455@gmail.com\"]");

    public AccountPage accountHeaderCheck() {
        emailHeader.shouldBe(exist);
        return this;
    }
}
