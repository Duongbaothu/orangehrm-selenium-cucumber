package pageObjects.PIMPageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testData.EmployeeInfo;

public class EmployeeJobPageObject extends BaseElement {
    private WebDriver driver;

    public EmployeeJobPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setEmployeeJob(EmployeeInfo employeeInfo) {
        enterToTextboxByText("Joined Date", employeeInfo.getJoinedDate());
        selectInDropdown("Job Title", employeeInfo.getJobTitleEmployee());
        selectInDropdown("Job Category", employeeInfo.getJobCategory());
        selectInDropdown("Employment Status", employeeInfo.getEmploymentStatus());
    }

    public void setEmployeeContractDetails(EmployeeInfo employeeInfo) {
        enterToTextboxByText("Contract Start Date", employeeInfo.getContractStartDate());
        enterToTextboxByText("Contract End Date", employeeInfo.getContractEndDate());
        uploadFileType(driver, "Contract Details", employeeInfo.getImage());
    }

    public void verifyEmployeeJob(EmployeeInfo employeeInfo) {
        Assert.assertEquals(getTextboxAttributeByText("Joined Date"), employeeInfo.getJoinedDate());
        Assert.assertEquals(getItemTextSelectedInDropdownByText("Job Category"), employeeInfo.getJobCategory());
        Assert.assertEquals(getItemTextSelectedInDropdownByText("Employment Status"), employeeInfo.getEmploymentStatus());
    }

    public void verifyEmployeeContractDetails(EmployeeInfo employeeInfo) {
        Assert.assertEquals(getTextboxAttributeByText("Contract Start Date"), employeeInfo.getContractStartDate());
        Assert.assertEquals(getTextboxAttributeByText("Contract End Date"), employeeInfo.getContractEndDate());
        Assert.assertTrue(isFileLoadedSuccess("Contract Details", employeeInfo.getImage()));
    }
}
