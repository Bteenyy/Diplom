package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectPage {
    final SelenideElement counterProject =  $("span[class='Text-sc-kheewc-0 kmsPQq']");

    public ProjectPage counterProjectCheck() {
        counterProject.shouldHave(text("1/2"));
        return this;
    }
}