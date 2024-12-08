package stepDefinitions.PIM;

import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;

public class DependentsPageSteps {
    WebDriver driver;

    public DependentsPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }
}
