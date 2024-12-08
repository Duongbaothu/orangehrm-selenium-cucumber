package stepDefinitions;

import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;

public class DashboardPageSteps {
    WebDriver driver;

    public DashboardPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }

}
