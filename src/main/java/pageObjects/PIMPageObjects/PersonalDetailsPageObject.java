package pageObjects.PIMPageObjects;

import pageUIs.PIMPageUIs.PersonalDetailsPageUI;
import pageObjects.CommonPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testData.EmployeeInfo;

public class PersonalDetailsPageObject extends CommonPageObject {
    private WebDriver driver;

    public PersonalDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAvatarImg() {
        waitForElementClickable(driver, PersonalDetailsPageUI.AVATAR_IMG);
        clickToElement(driver, PersonalDetailsPageUI.AVATAR_IMG);
    }

    public void setPersionalDetail(EmployeeInfo employeeInfo) {
        enterToTextboxByText("License Number", employeeInfo.getDriverLicenseNumber());
        enterToTextboxByText("License Expiry Date", employeeInfo.getLicenseExpiryDate());
        selectInDropdown("Nationality", employeeInfo.getNationality());
        selectInDropdown("Marital Status", employeeInfo.getMaritalStatus());
        enterToTextboxByText("Date of Birth", employeeInfo.getEmployeeDateOfBirth());
        clickToRadioButtonByLabel(employeeInfo.getGenderStatus());
    }

    public void verifyPersonalDetail(EmployeeInfo employeeInfo) {
        Assert.assertEquals(getTextboxAttributeByText("License Number"), employeeInfo.getDriverLicenseNumber(), "License Number mismatch");
        Assert.assertEquals(getTextboxAttributeByText("License Expiry Date"), employeeInfo.getLicenseExpiryDate(), "License Expiry Date mismatch");
        Assert.assertEquals(getItemTextSelectedInDropdownByText("Nationality"), employeeInfo.getNationality(), "Nationality mismatch");
        Assert.assertEquals(getItemTextSelectedInDropdownByText("Marital Status"), employeeInfo.getMaritalStatus(), "Marital Status mismatch");
        Assert.assertEquals(getTextboxAttributeByText("Date of Birth"), employeeInfo.getEmployeeDateOfBirth(), "Date of Birth mismatch");
        Assert.assertTrue(isRadioButtonItemSelectedByLabel(employeeInfo.getGenderStatus()), "Gender selection mismatch");
    }
}
