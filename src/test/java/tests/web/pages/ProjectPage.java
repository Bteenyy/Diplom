package tests.web.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

public class ProjectPage {
    final SelenideElement projectTable = $x("//*[contains(text(), 'qa.quru')]"),
            projectMenuBut = $("div[class*='Projects__SettingsButton']"),
            projectDeleteBut = $("div[class*='gnjCbB'] span[class^='Text-sc-kheewc-0']");

    public WebElement checkNameProject() {
        return projectTable;
    }

    public ProjectPage deleteProject() {
        projectMenuBut.click();
        projectDeleteBut.click();
        refresh();
        Configuration.timeout = 30000;
        return this;
    }
}