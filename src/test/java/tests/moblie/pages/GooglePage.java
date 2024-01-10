package tests.moblie.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class GooglePage {
    SelenideElement termsAccept = $(id("com.android.chrome:id/terms_accept")),
            negativeButton = $(id("com.android.chrome:id/negative_button")),
            searchBoxText = $(id("com.android.chrome:id/search_box_text")),
            urlBar = $(id("com.android.chrome:id/url_bar")),
            line = $(id("com.android.chrome:id/line_1")),
            menuButton = $(id("com.android.chrome:id/menu_button")),
            checkbox = $(id("com.android.chrome:id/checkbox"));

    public GooglePage mainPageOpen() {
        termsAccept.click();
        negativeButton.click();
        searchBoxText.click();
        urlBar.sendKeys("deeray.com");
        line.click();
        menuButton.click();
        checkbox.click();
        return this;
    }
}
