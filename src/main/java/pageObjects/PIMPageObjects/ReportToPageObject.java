package pageObjects.PIMPageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testData.EmployeeInfo;

public class ReportToPageObject extends BaseElement {
    private WebDriver driver;

    public ReportToPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setSupervisor(EmployeeInfo employeeInfo) {
        enterAndSelectInDropdown("Name", employeeInfo.getSupervisorName(), employeeInfo.getSupervisorName());
        selectInDropdown("Reporting Method", employeeInfo.getReportingMethod());
    }

    public void verifySupervisor(EmployeeInfo employeeInfo) {
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Supervisors","Name", "1", employeeInfo.getSupervisorName()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Supervisors","Reporting Method", "1", employeeInfo.getReportingMethod()));
    }

    public void setSubordinate(EmployeeInfo employeeInfo) {
        enterAndSelectInDropdown("Name", employeeInfo.getSubordinateName(), employeeInfo.getSubordinateName());
        selectInDropdown("Reporting Method", employeeInfo.getReportingMethod());
    }

    public void verifySubordinate(EmployeeInfo employeeInfo) {
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Subordinates","Name", "1", employeeInfo.getSubordinateName()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Subordinates","Reporting Method", "1", employeeInfo.getReportingMethod()));
    }
}
