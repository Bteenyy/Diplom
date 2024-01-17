package config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:${launch}.properties"
})
public interface ApiConfig extends Config {
    @Key("emailApi")
    @DefaultValue("rashitsahbutdinov@yandex.ru")
    String getEmailApi();

    @Key("passwordApi")
    @DefaultValue("mdf9MsZs2bbM7kq_")
    String getPasswordApi();

    @Key("projectNameApi")
    @DefaultValue("qa.1231quru")
    String getProjectNameApi();

    @Key("projectDescriptionApi")
    @DefaultValue("Diplom")
    String getProjectDescriptionApi();
    @Key("baseURIApi")
    @DefaultValue("https://api.deeray.com")
    String getBaseUriApi();
}
