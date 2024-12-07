package pageObjects.PIMPageObjects;

import pageObjects.CommonPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testData.EmployeeInfo;

public class EmergencyContactsPageObject extends CommonPageObject {
    private WebDriver driver;

    public EmergencyContactsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setEmergencyContact(EmployeeInfo employeeInfo) {
        enterToTextboxByText("Name", employeeInfo.getEmergencyContactName());
        enterToTextboxByText("Relationship", employeeInfo.getEmergencyRelationship());
        enterToTextboxByText("Mobile", employeeInfo.getEmergencyContactMobile());
    }

    public void verifyEmergencyContact(EmployeeInfo employeeInfo) {
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Emergency Contacts", "Name", "1", employeeInfo.getEmergencyContactName()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Emergency Contacts","Relationship", "1", employeeInfo.getEmergencyRelationship()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Emergency Contacts","Mobile", "1", employeeInfo.getEmergencyContactMobile()));
    }
}
