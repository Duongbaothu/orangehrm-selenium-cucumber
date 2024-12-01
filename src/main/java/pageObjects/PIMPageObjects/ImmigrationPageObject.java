package pageObjects.PIMPageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testData.EmployeeInfo;

public class ImmigrationPageObject extends BaseElement {
    private WebDriver driver;

    public ImmigrationPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setImmigration(EmployeeInfo employeeInfo) {
        clickToRadioButtonByLabel(employeeInfo.getDocumentType());
        enterToTextboxByText("Number", employeeInfo.getDocNumber());
        enterToTextboxByText("Issued Date", employeeInfo.getIssuedDate());
        enterToTextboxByText("Expiry Date", employeeInfo.getExpiryDate());
        selectInDropdown("Issued By", employeeInfo.getIssuedBy());
        enterToTextboxByText("Eligible Review Date", employeeInfo.getEligibleReviewDate());
    }

    public void verifyImmigration(EmployeeInfo employeeInfo) {
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Immigration Records","Document", "1", employeeInfo.getDocumentType()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Immigration Records","Number", "1", employeeInfo.getDocNumber()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Immigration Records","Issued By", "1", employeeInfo.getIssuedBy()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Immigration Records","Issued Date", "1", employeeInfo.getIssuedDate()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Immigration Records","Expiry Date", "1", employeeInfo.getExpiryDate()));
    }
}
