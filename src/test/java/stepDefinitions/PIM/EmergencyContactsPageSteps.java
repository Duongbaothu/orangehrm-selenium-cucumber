package stepDefinitions.PIM;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.PIMPageObjects.EmergencyContactsPageObject;

import java.util.List;
import java.util.Map;

public class EmergencyContactsPageSteps {
    WebDriver driver;
    EmergencyContactsPageObject emergencyContactsPage;

    public EmergencyContactsPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        emergencyContactsPage = PageGeneratorManager.getEmergencyContactsPage(driver);
    }

    @When("Input Emergency Contacts information with data")
    public void inputEmergencyContactInformationWithData(DataTable emergencyContactTable) {
        List<Map<String, String>> emergencyContact = emergencyContactTable.asMaps(String.class, String.class);
        emergencyContactsPage.enterToTextboxByText("Name", emergencyContact.get(0).get("emergencyContactName"));
        emergencyContactsPage.enterToTextboxByText("Relationship", emergencyContact.get(0).get("emergencyRelationship"));
        emergencyContactsPage.enterToTextboxByText("Mobile", emergencyContact.get(0).get("emergencyContactMobile"));
    }

    @And("Emergency Contacts information displayed correct as input")
    public void emergencyContactInformationDisplayedCorrect(DataTable emergencyContactTable) {
        List<Map<String, String>> emergencyContact = emergencyContactTable.asMaps(String.class, String.class);
        Assert.assertTrue(emergencyContactsPage.isValueDisplayedAtColumnNameWithTableName("Assigned Emergency Contacts", "Name", "1", emergencyContact.get(0).get("emergencyContactName")));
        Assert.assertTrue(emergencyContactsPage.isValueDisplayedAtColumnNameWithTableName("Assigned Emergency Contacts","Relationship", "1", emergencyContact.get(0).get("emergencyRelationship")));
        Assert.assertTrue(emergencyContactsPage.isValueDisplayedAtColumnNameWithTableName("Assigned Emergency Contacts","Mobile", "1", emergencyContact.get(0).get("emergencyContactMobile")));
    }
}
