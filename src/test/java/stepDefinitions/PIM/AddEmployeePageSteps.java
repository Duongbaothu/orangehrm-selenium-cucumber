package stepDefinitions.PIM;

import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;

public class AddEmployeePageSteps {
    WebDriver driver;

    public AddEmployeePageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }
}
