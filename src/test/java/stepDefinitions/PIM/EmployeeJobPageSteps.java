package stepDefinitions.PIM;

import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;

public class EmployeeJobPageSteps {
    WebDriver driver;

    public EmployeeJobPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }
}
