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

    @Key("email")
    @DefaultValue("rashitsahbutdinov@yandex.ru")
    String getEmail();

    @Key("password")
    @DefaultValue("mdf9MsZs2bbM7kq_")
    String getPassword();

    @Key("projectName")
    @DefaultValue("qa.quru")
    String getProjectName();

    @Key("projectDescription")
    @DefaultValue("Diplom")
    String getProjectDescription();

    @Key("baseURL")
    @DefaultValue("https://deeray.com/")
    String getBaseURL();

    @Key("baseURI")
    @DefaultValue("https://api.deeray.com")
    String getBaseURI();

}

