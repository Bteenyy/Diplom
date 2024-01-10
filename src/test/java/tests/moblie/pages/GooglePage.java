package tests.moblie.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class GooglePage {
    SelenideElement firstPage = $(id("com.android.chrome:id/terms_accept")),
            secondPage = $(id("com.android.chrome:id/negative_button")),
            thirdPage = $(id("com.android.chrome:id/url_bar")),
            fourthPage = $(id("com.android.chrome:id/line_1")),
            fivePage = $(id("com.android.chrome:id/search_box_text"));

    public GooglePage openMainPage() {
        firstPage.click();
        secondPage.click();
        fivePage.click();
        thirdPage.sendKeys("deeray.com");
        fourthPage.click();
        return this;
    }
}
