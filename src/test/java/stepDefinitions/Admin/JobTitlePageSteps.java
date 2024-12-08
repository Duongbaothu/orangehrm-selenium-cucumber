package stepDefinitions.Admin;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pageObjects.AdminPageObjects.JobTitlePageObject;
import pageObjects.AdminPageObjects.SystemUsersPageObject;
import pageObjects.DashboardPageObject;
import pageObjects.LoginPageObject;
import utilities.PropertiesConfig;

public class JobTitlePageSteps {
    WebDriver driver;
    JobTitlePageObject jobTitlePage;

    private String browserName;
    public static String jobTitle;
    private String image;

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private SystemUsersPageObject systemUsersPage;
    private PropertiesConfig propertiesConfig;


    public JobTitlePageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        jobTitlePage = PageGeneratorManager.getJobTitlePage(driver);
    }




}
