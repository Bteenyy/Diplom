package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$x;

public class AccountPage {

    static final SelenideElement loginHeader = $x("//*[contains(text(), 'rashitsahbutdinov@yandex.ru')]"),
            loginButton = $x("(//menu)[2]//div/div"),
            logOut = $x("//*[name()='use'][contains(@*, '#sign-out')]"),
            projectButton = $x("(//menu)[1]/div/div");

    public WebElement getLoginHeader() {
        return loginHeader;
    }


    public AccountPage clickLogoutButton() {
        logOut.click();
        return this;
    }

    public AccountPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public AccountPage clickProjectButton() {
        projectButton.click();
        return this;
    }


}
