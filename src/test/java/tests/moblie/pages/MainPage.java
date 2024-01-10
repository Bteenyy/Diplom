package tests.moblie.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {
    SelenideElement banner = $(id("com.android.chrome:id/terms_accept"));
    public MainPage checkMainPage(){
        banner.shouldBe(Condition.visible);
        return this;
    }
}
