package stepDefinitions.Admin;

import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;

public class EmploymentStatusPageSteps {
    WebDriver driver;

    public EmploymentStatusPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }
}
