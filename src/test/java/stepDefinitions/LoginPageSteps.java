package stepDefinitions;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPageObject;
import utilities.PropertiesConfig;

public class LoginPageSteps {
    WebDriver driver;
    LoginPageObject loginPage;
    private PropertiesConfig propertiesConfig;
    private String url;

    public LoginPageSteps() {
        String environment = System.getProperty("environment", "local");
        propertiesConfig = PropertiesConfig.getProperties(environment);
        this.driver = Hooks.openAndQuitBrowser();
        loginPage = PageGeneratorManager.getLoginPage(driver, propertiesConfig);

        this.url = propertiesConfig.getApplicationUrl();
    }

    @Given("Open the application URL")
    public void openTheApplicationURL() {
        driver.get(url);
    }

    @When("Log into OrangeHRM site as Admin role")
    public void loginToTheAdminPage() {
        loginPage.enterToTextboxByText("Username", propertiesConfig.getApplicationUserName());
        loginPage.enterToTextboxByText("Password", propertiesConfig.getApplicationPassword());
        loginPage.clickToButtonByText("Login");

    }

}
