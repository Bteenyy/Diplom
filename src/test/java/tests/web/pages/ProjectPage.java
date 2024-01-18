package tests.web.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class ProjectPage {
    final SelenideElement projectTable = $("div[class$='Table']"),
            projectMenuBut = $("div[class*='Projects__SettingsButton']"),
            projectDeleteBut = $("div[class*='gnjCbB'] span[class^='Text-sc-kheewc-0']");

    public ProjectPage checkNameProject(String name) {
        projectTable.shouldHave(text(name));
        return this;
    }

    public ProjectPage deleteProject() {
        projectMenuBut.click();
        projectDeleteBut.click();
        refresh();
        Configuration.timeout = 30000;
        return this;
    }

    public ProjectPage checkDeleteProject(String name) {
        projectTable.shouldNotHave(text(name));
        return this;
    }
}