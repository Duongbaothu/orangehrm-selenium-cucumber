package stepDefinitions.PIM;

import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;

public class QualificationsPageSteps {
    WebDriver driver;

    public QualificationsPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }
}
