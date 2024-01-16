package tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectPage {
final SelenideElement projectTble = $("div[class='ReactVirtualized__Table']");

    public ProjectPage nameProjectCheck(String name) {
        projectTble.shouldHave(text(name));
        return this;
    }
}