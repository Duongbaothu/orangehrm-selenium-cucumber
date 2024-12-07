package pageObjects.PIMPageObjects;

import pageObjects.CommonPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testData.EmployeeInfo;

public class QualificationsPageObject extends CommonPageObject {
    private WebDriver driver;

    public QualificationsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setQualification(EmployeeInfo employeeInfo) {
        enterToTextboxByText("Company", employeeInfo.getCompany());
        enterToTextboxByText("Job Title", employeeInfo.getJobTitleEmployee());
        enterToTextboxByText("From", employeeInfo.getWorkFrom());
        enterToTextboxByText("To", employeeInfo.getWorkTo());
    }

    public void verifyQualification(EmployeeInfo employeeInfo) {
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Work Experience","Company", "1", employeeInfo.getCompany()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Work Experience","Job Title", "1", employeeInfo.getJobTitleEmployee()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Work Experience","From", "1", employeeInfo.getWorkFrom()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Work Experience","To", "1", employeeInfo.getWorkTo()));
    }
}
