package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${launch}.properties"
})
public interface BrowserstackMobileConfig extends Config {
    @Key("browserstackAccessKey")
    String getAccessKey();

    @Key("browserstackUserName")
    String getUserName();

    @Key("browserstackUrl")
    String getUrl();

    @Key("browserstackDevice")
    @DefaultValue("Google Pixel 3")
    String getDevice();

    @Key("browserstackOsVersion")
    @DefaultValue("9.0")
    String getOS();

    @Key("browserstackApp")
    @DefaultValue("bs://e198539b3c32892d8324292a1668eb3c6beb1f66")
    String getApp();
}