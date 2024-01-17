package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;

public class AccountPage {
    final SelenideElement emailHeader = $x("//android.widget.TextView[@text=\"rasitsahbutdinov915455@gmail.com\"]");

    public AccountPage checkAccountHeader() {
        emailHeader.shouldBe(exist);
        return this;
    }
}
