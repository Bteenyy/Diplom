package tests.moblie;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

@Tag("mobile")
public class AndroidTest extends MobileTestBase {
    @Test
    public void testcase_001() {
        $(By.className("android.widget.Button")).$(id("com.android.chrome:id/terms_accept")).click();
        $(id("com.android.chrome:id/negative_button")).click();
        $(id("com.android.chrome:id/search_box_text")).click();
        $(id("com.android.chrome:id/url_bar")).sendKeys("deeray.com");
        $(id("com.android.chrome:id/line_1")).click();
        $(className("android.view.View")).shouldHave(text("AI-аналитика звонков, чатов, NPS и отзывов в одном месте"));
    }
}
