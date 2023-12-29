package web.helpers;

import io.restassured.response.Response;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;
import web.api.LoginWithApi;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CookieBase implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        LoginWithApi loginWithApi = new LoginWithApi();
        Response cookie = loginWithApi.getAuth();
        open("/images/Toolsqa.jpg");
        getWebDriver().manage().addCookie(new Cookie("userID", cookie.path("userId")));
        getWebDriver().manage().addCookie(new Cookie("expires", cookie.path("expires")));
        getWebDriver().manage().addCookie(new Cookie("token", cookie.path("token")));
    }
}
