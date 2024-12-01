package admin;

import pageObjects.AdminPageObjects.EmploymentStatusPageObject;
import pageObjects.AdminPageObjects.SystemUsersPageObject;
import pageObjects.PIMPageObjects.DashboardPageObject;
import pageObjects.PIMPageObjects.LoginPageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import reportConfig.ExtentTestManager;
import utilities.PropertiesConfig;

import java.lang.reflect.Method;

public class Admin_03_Employment_Status extends BaseTest {
    private WebDriver driver;
    private String browserName;
    public static String employmentStatusName;

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private SystemUsersPageObject systemUsersPage;
    private EmploymentStatusPageObject employmentStatusPage;
    private PropertiesConfig propertiesConfig;

    @Parameters({"browser", "server"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName){
        propertiesConfig = PropertiesConfig.getProperties(serverName);
        driver = EnvironmentFactoryProvider.createDriver(browserName, serverName);
        this.browserName = browserName;

        employmentStatusName = "Full-time" + getNumberRandom();

        loginPage = PageGeneratorManager.getLoginPage(driver, propertiesConfig);

        loginPage.loginToAdmin();

        dashboardPage = PageGeneratorManager.getDashboardPage(driver);

        dashboardPage.openMainMenuPageByName("Admin");
        systemUsersPage = PageGeneratorManager.getSystemUsersPage(driver);
    }

    @Test
    public void Employment_Status_01_Add_New_Empty_Data(Method method){
        ExtentTestManager.startTest(method.getName(), "Employment_Status_01_Add_New_Empty_Data");

        systemUsersPage.clickToHeaderMenu("Job");
        systemUsersPage.clickToItemInHeaderMenu("Employment Status");
        employmentStatusPage = PageGeneratorManager.getEmploymentStatusPage(driver);

        employmentStatusPage.clickToButtonByText("Add");

        employmentStatusPage.clickToButtonByText("Save");

        Assert.assertEquals(employmentStatusPage.getTextboxErrorMessageByTextboxLabel("Name"), "Required");
    }

    @Test
    public void Employment_Status_02_Add_New_Sucess(Method method){
        ExtentTestManager.startTest(method.getName(), "Employment_Status_02_Add_New_Sucess");

        employmentStatusPage.clickToHeaderMenu("Job");
        employmentStatusPage.clickToItemInHeaderMenu("Employment Status");
        employmentStatusPage = PageGeneratorManager.getEmploymentStatusPage(driver);

        employmentStatusPage.clickToButtonByText("Add");

        employmentStatusPage.enterToTextboxByText("Name", employmentStatusName);

        employmentStatusPage.clickToButtonByText("Save");

        Assert.assertTrue(employmentStatusPage.isSuccessMessageDisplayed("Successfully Saved"));
        employmentStatusPage.waitForSpinnerIconInvisible();

        Assert.assertTrue(employmentStatusPage.isRecordPresentInTableByColumnName("Employment Status", employmentStatusName));
    }

    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
