package admin;

import pageObjects.AdminPageObjects.JobTitlePageObject;
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
import utilities.FakerConfig;
import utilities.PropertiesConfig;

import java.lang.reflect.Method;

public class Admin_01_Job_Titles extends BaseTest {
    private WebDriver driver;
    private String browserName;
    public static String jobTitle;
    private String image;

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private SystemUsersPageObject systemUsersPage;
    private JobTitlePageObject JobTitlePage;
    private FakerConfig fakerConfig;
    private PropertiesConfig propertiesConfig;

    @Parameters({"browser", "server"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName){
        propertiesConfig = PropertiesConfig.getProperties(serverName);
        driver = EnvironmentFactoryProvider.createDriver(browserName, serverName);
        this.browserName = browserName;

        fakerConfig = FakerConfig.getFaker();

        jobTitle = fakerConfig.getCompanyProfession() + getNumberRandom();
        image = "image01.jpg";

        loginPage = PageGeneratorManager.getLoginPage(driver, propertiesConfig);

        loginPage.loginToAdmin();

        dashboardPage = PageGeneratorManager.getDashboardPage(driver);

        dashboardPage.openMainMenuPageByName("Admin");
        systemUsersPage = PageGeneratorManager.getSystemUsersPage(driver);
    }

    @Test
    public void Job_Title_01_Add_New_Empty_Data(Method method){
        ExtentTestManager.startTest(method.getName(), "Job_Title_01_Add_New_Empty_Data");

        systemUsersPage.clickToHeaderMenu("Job");
        systemUsersPage.clickToItemInHeaderMenu("Job Titles");
        JobTitlePage = PageGeneratorManager.getJobTitlePage(driver);

        JobTitlePage.clickToButtonByText("Add");

        JobTitlePage.clickToButtonByText("Save");

        Assert.assertEquals(JobTitlePage.getTextboxErrorMessageByTextboxLabel("Job Title"), "Required");
    }

    @Test
    public void Job_Title_02_Add_New_Sucess(Method method){
        ExtentTestManager.startTest(method.getName(), "Job_Title_02_Add_New_Sucess");

        JobTitlePage.clickToHeaderMenu("Job");
        JobTitlePage.clickToItemInHeaderMenu("Job Titles");
        JobTitlePage = PageGeneratorManager.getJobTitlePage(driver);

        JobTitlePage.clickToButtonByText("Add");

        JobTitlePage.enterToTextboxByText("Job Title", jobTitle);

        JobTitlePage.uploadFileType(driver, "Job Specification", image);

        Assert.assertTrue(JobTitlePage.isFileLoadedSuccess("Job Specification", image));

        JobTitlePage.clickToButtonByText("Save");

        Assert.assertTrue(JobTitlePage.isSuccessMessageDisplayed("Successfully Saved"));
        JobTitlePage.waitForSpinnerIconInvisible();

        Assert.assertTrue(JobTitlePage.isRecordPresentInTableByColumnName("Job Titles", jobTitle));
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
