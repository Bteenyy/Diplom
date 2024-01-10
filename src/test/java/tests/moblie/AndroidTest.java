package tests.moblie;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.appium.java_client.AppiumBy.id;

@Tag("mobile")
public class AndroidTest extends TestBaseMobile {
    @Test
    void successfulLoginTest() {

    }
}
