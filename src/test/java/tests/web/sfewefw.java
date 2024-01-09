package tests.web;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

@Tag("mobile")
public class sfewefw {
    @Test
    void check()
    {
open("https://account.deeray.com");
    }
}
