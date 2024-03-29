package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${launch}.properties",
})

public interface WebConfig extends Config {

    @Key("browserName")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("emailWeb")
    @DefaultValue("rashitsahbutdinov@yandex.ru")
    String getEmailWeb();

    @Key("passwordWeb")
    @DefaultValue("mdf9MsZs2bbM7kq_")
    String getPasswordWeb();

    @Key("projectNameWeb")
    @DefaultValue("qa.quru")
    String getProjectNameWeb();

    @Key("projectDescriptionWeb")
    @DefaultValue("Diplom")
    String getProjectDescriptionWeb();

    @Key("baseURL")
    @DefaultValue("https://deeray.com/")
    String getBaseURL();

    @Key("baseURI")
    @DefaultValue("https://api.deeray.com")
    String getBaseUri();
}

