package drivers;


import com.codeborne.selenide.WebDriverProvider;
import config.EmulatorConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;

public class EmulatorDriver implements WebDriverProvider {
    static EmulatorConfig configEm = ConfigFactory.create(EmulatorConfig.class, System.getProperties());

    @Nonnull
    @Override
    public AndroidDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(configEm.platformName())
                .setPlatformVersion(configEm.platformVersion())
                .setDeviceName(configEm.deviceName())
                .setAppPackage(configEm.appPackage())
                .setAppActivity(configEm.appActivity());
        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(configEm.localServer());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}