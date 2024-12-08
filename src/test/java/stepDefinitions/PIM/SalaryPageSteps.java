package stepDefinitions.PIM;

import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;

public class SalaryPageSteps {
    WebDriver driver;

    public SalaryPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }
}
