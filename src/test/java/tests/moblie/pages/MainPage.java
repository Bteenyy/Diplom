package tests.moblie.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.className;

public class MainPage {
    SelenideElement banner = $(className("android.view.View")),
            companyBut = $x("//android.widget.TextView[@text=\"О компании\"]"),
            enterBut = $x("//android.widget.TextView[@text=\"Вход\"]");

    public MainPage mainPageCheck() {
        banner.shouldBe(visible);
        return this;
    }

    public MainPage companyButClick() {
        companyBut.click();
        return this;
    }

    public MainPage enterButClick() {
        enterBut.click();
        return this;
    }
}
