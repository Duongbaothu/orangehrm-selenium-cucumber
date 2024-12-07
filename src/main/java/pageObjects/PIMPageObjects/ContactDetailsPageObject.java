package pageObjects.PIMPageObjects;

import pageObjects.CommonPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testData.EmployeeInfo;

public class ContactDetailsPageObject extends CommonPageObject {
    private WebDriver driver;

    public ContactDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setContactDetail(EmployeeInfo employeeInfo) {
        enterToTextboxByText("Street 1", employeeInfo.getStreet1());
        enterToTextboxByText("City", employeeInfo.getCity());
        enterToTextboxByText("State/Province", employeeInfo.getState());
        enterToTextboxByText("Zip/Postal Code", employeeInfo.getZip());
        selectInDropdown("Country", employeeInfo.getCountry());
        enterToTextboxByText("Mobile", employeeInfo.getMobile());
        enterToTextboxByText("Work Email", employeeInfo.getWorkEmail());
    }

    public void verifyContactDetail(EmployeeInfo employeeInfo) {
        Assert.assertEquals(getTextboxAttributeByText("Street 1"), employeeInfo.getStreet1());
        Assert.assertEquals(getTextboxAttributeByText("City"), employeeInfo.getCity());
        Assert.assertEquals(getTextboxAttributeByText("State/Province"), employeeInfo.getState());
        Assert.assertEquals(getTextboxAttributeByText("Zip/Postal Code"), employeeInfo.getZip());
        Assert.assertEquals(getItemTextSelectedInDropdownByText("Country"), employeeInfo.getCountry());
        Assert.assertEquals(getTextboxAttributeByText("Mobile"), employeeInfo.getMobile());
        Assert.assertEquals(getTextboxAttributeByText("Work Email"), employeeInfo.getWorkEmail());
    }
}
