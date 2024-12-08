package stepDefinitions.PIM;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.PIMPageObjects.ContactDetailsPageObject;
import testData.EmployeeInfo;
import utilities.CommonUtils;

import java.util.List;
import java.util.Map;

public class ContactDetailsPageSteps {
    WebDriver driver;
    ContactDetailsPageObject contactDetailsPage;
    private EmployeeInfo employeeInfo;
    static String workEmail;

    public ContactDetailsPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        contactDetailsPage = PageGeneratorManager.getContactDetailsPage(driver);
        employeeInfo = EmployeeInfo.getEmployee();
        workEmail = CommonUtils.getEmailRandom();
    }

    @When("Input Contact Detail information with data")
    public void inputContactDetailInformationWithData(DataTable contactDetailTable) {
        List<Map<String, String>> contactDetail = contactDetailTable.asMaps(String.class, String.class);
        contactDetailsPage.enterToTextboxByText("Street 1", contactDetail.get(0).get("street1"));
        contactDetailsPage.enterToTextboxByText("City", contactDetail.get(0).get("city"));
        contactDetailsPage.enterToTextboxByText("State/Province", contactDetail.get(0).get("stateOrProvince"));
        contactDetailsPage.enterToTextboxByText("Zip/Postal Code", contactDetail.get(0).get("zipOrPostalCode"));
        contactDetailsPage.selectInDropdown("Country", contactDetail.get(0).get("country"));
        contactDetailsPage.enterToTextboxByText("Mobile", contactDetail.get(0).get("mobile"));
        contactDetailsPage.enterToTextboxByText("Work Email", workEmail);
    }

    @And("Contact Detail information displayed correct as input")
    public void contactDetailInformationDisplayedCorrect(DataTable contactDetailTable) {
        List<Map<String, String>> contactDetail = contactDetailTable.asMaps(String.class, String.class);
        Assert.assertEquals(contactDetailsPage.getTextboxAttributeByText("Street 1"), contactDetail.get(0).get("street1"));
        Assert.assertEquals(contactDetailsPage.getTextboxAttributeByText("City"), contactDetail.get(0).get("city"));
        Assert.assertEquals(contactDetailsPage.getTextboxAttributeByText("State/Province"), contactDetail.get(0).get("stateOrProvince"));
        Assert.assertEquals(contactDetailsPage.getTextboxAttributeByText("Zip/Postal Code"), contactDetail.get(0).get("zipOrPostalCode"));
        Assert.assertEquals(contactDetailsPage.getItemTextSelectedInDropdownByText("Country"), contactDetail.get(0).get("country"));
        Assert.assertEquals(contactDetailsPage.getTextboxAttributeByText("Mobile"), contactDetail.get(0).get("mobile"));
        Assert.assertEquals(contactDetailsPage.getTextboxAttributeByText("Work Email"), workEmail);
    }
}
