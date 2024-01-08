package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envWeb}.properties",
})

public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
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