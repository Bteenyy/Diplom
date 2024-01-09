package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties"
})
public interface EmulatorConfig extends Config {
    @Key("local.server")
    String localServer();

    @Key("device.name")
    String deviceName();

    @Key("platform.name")
    String platformName();

    @Key("platform.version")
    String platformVersion();


    @Key("app.package")
    String appPackage();

    @Key("app.activity")
    String appActivity();
}