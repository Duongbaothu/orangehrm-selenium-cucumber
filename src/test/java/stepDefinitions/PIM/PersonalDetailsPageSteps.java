package stepDefinitions.PIM;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.PIMPageObjects.PersonalDetailsPageObject;

import java.util.List;
import java.util.Map;

public class PersonalDetailsPageSteps {
    WebDriver driver;
    PersonalDetailsPageObject personalDetailsPage;

    public PersonalDetailsPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);

    }

    @When("Input Personal Detail information with data")
    public void inputPersonalDetailInformationWithData(DataTable personalDetailTable) {
        List<Map<String, String>> personalDetail = personalDetailTable.asMaps(String.class, String.class);
        personalDetailsPage.enterToTextboxByText("License Number", personalDetail.get(0).get("licenseNumber"));
        personalDetailsPage.enterToTextboxByText("License Expiry Date", personalDetail.get(0).get("licenseExpiryDate"));
        personalDetailsPage.selectInDropdown("Nationality", personalDetail.get(0).get("nationality"));
        personalDetailsPage.selectInDropdown("Marital Status", personalDetail.get(0).get("maritalStatus"));
        personalDetailsPage.enterToTextboxByText("Date of Birth", personalDetail.get(0).get("dateOfBirth"));
        personalDetailsPage.clickToRadioButtonByLabel(personalDetail.get(0).get("gender"));
    }

    @And("Personal Detail information displayed correct as input")
    public void personalDetailInformationDisplayedCorrect(DataTable personalDetailTable) {
        List<Map<String, String>> personalDetail = personalDetailTable.asMaps(String.class, String.class);
        Assert.assertEquals(personalDetailsPage.getTextboxAttributeByText("License Number"), personalDetail.get(0).get("licenseNumber"), "License Number mismatch");
        Assert.assertEquals(personalDetailsPage.getTextboxAttributeByText("License Expiry Date"), personalDetail.get(0).get("licenseExpiryDate"), "License Expiry Date mismatch");
        Assert.assertEquals(personalDetailsPage.getItemTextSelectedInDropdownByText("Nationality"), personalDetail.get(0).get("nationality"), "Nationality mismatch");
        Assert.assertEquals(personalDetailsPage.getItemTextSelectedInDropdownByText("Marital Status"), personalDetail.get(0).get("maritalStatus"), "Marital Status mismatch");
        Assert.assertEquals(personalDetailsPage.getTextboxAttributeByText("Date of Birth"), personalDetail.get(0).get("dateOfBirth"), "Date of Birth mismatch");
        Assert.assertTrue(personalDetailsPage.isRadioButtonItemSelectedByLabel(personalDetail.get(0).get("gender")), "Gender selection mismatch");
    }

    @When("Click to Avatar picture")
    public void clickToAvatarPicture() {
        personalDetailsPage.clickToAvatarImg();
    }
}
