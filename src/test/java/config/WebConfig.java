package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${launch}.properties"
})

public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();


    @Key("version")
    @DefaultValue("100.0")
    String version();

    @Key("baseUrl")
    @DefaultValue("https://deeray.com/")
    String baseUrl();


    @Key("remoteUrl")
    String getRemoteUrl();
}