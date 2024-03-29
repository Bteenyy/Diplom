package tests.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EnterPage {
    final SelenideElement emailInput = $x("//android.view.View[@resource-id=\"all-content-section\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.EditText"),
            passwordInput = $x("//android.widget.EditText[@text=\"Пароль\"]"),
            loginBut = $x("//android.widget.Button[@text=\"ВОЙТИ\"]"),
            errorMessage = $x("//android.widget.TextView[@text=\"Ошибка авторизации\"]");

    public EnterPage insertInputData(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginBut.click();
        return this;
    }

    public EnterPage checkErrorMessage() {
        errorMessage.shouldBe(Condition.visible);
        return this;
    }
}
