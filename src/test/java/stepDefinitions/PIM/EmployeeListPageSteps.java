package stepDefinitions.PIM;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.PIMPageObjects.EmployeeListPageObject;
import stepDefinitions.Context;
import stepDefinitions.TestContext;
import testData.EmployeeInfo;

public class EmployeeListPageSteps {
    WebDriver driver;
    EmployeeListPageObject employeeListPage;
    EmployeeInfo employeeInfo;
    TestContext testContext;

    public EmployeeListPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
        this.testContext = Hooks.getTestContext();
    }

    @Then("Click on the {string} icon of employee has ID {string}")
    public void clickToIcon(String iconClass, String employeeID) {
        employeeID = (String) testContext.getDataContext().getContext(Context.EMPLOYEE_ID);
        employeeListPage.clickEmployeeActionIconByClass(employeeID, iconClass);
    }
}
