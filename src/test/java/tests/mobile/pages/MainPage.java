package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
  final  SelenideElement banner = $x("//android.webkit.WebView[@text=\"Deeray\"]/android.view.View/android.view.View[1]/android.view.View"),
            companyBut = $x("//android.widget.TextView[@text=\"О компании\"]"),
            enterBut = $x("//android.widget.TextView[@text=\"Вход\"]");

    public MainPage mainPageCheck() {
        banner.shouldBe(exist);
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
