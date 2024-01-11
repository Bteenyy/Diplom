package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CompanyPage {
    SelenideElement companyBanner = $x("//android.view.View[@text=\"КОМПАНИЯ\"]");

    public CompanyPage companyBannerCheck() {
        companyBanner.shouldBe(visible);
        return this;
    }
}
