package stepDefinitions.PIM;

import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;

public class ReportPageSteps {
    WebDriver driver;

    public ReportPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }
}
