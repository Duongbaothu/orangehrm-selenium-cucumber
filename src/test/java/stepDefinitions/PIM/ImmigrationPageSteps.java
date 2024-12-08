package stepDefinitions.PIM;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.PIMPageObjects.ImmigrationPageObject;

import java.util.List;
import java.util.Map;

public class ImmigrationPageSteps {
    WebDriver driver;
    ImmigrationPageObject immigrationPage;

    public ImmigrationPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        immigrationPage = PageGeneratorManager.getImmigrationPage(driver);
    }

    @When("Input Immigration information with data")
    public void inputImmigrationInformationWithData(DataTable immigrationTable) {
        List<Map<String, String>> immigration = immigrationTable.asMaps(String.class, String.class);
        immigrationPage.clickToRadioButtonByLabel(immigration.get(0).get("documentType"));
        immigrationPage.enterToTextboxByText("Number", immigration.get(0).get("docNumber"));
        immigrationPage.enterToTextboxByText("Issued Date", immigration.get(0).get("issuedDate"));
        immigrationPage.enterToTextboxByText("Expiry Date", immigration.get(0).get("expiryDate"));
        immigrationPage.selectInDropdown("Issued By", immigration.get(0).get("issuedBy"));
        immigrationPage.enterToTextboxByText("Eligible Review Date", immigration.get(0).get("eligibleReviewDate"));
    }

    @And("Immigration information displayed correct as input")
    public void immigrationInformationDisplayedCorrect(DataTable immigrationTable) {
        List<Map<String, String>> immigration = immigrationTable.asMaps(String.class, String.class);
        Assert.assertTrue(immigrationPage.isValueDisplayedAtColumnNameWithTableName("Assigned Immigration Records","Document", "1", immigration.get(0).get("documentType")));
        Assert.assertTrue(immigrationPage.isValueDisplayedAtColumnNameWithTableName("Assigned Immigration Records","Number", "1", immigration.get(0).get("docNumber")));
        Assert.assertTrue(immigrationPage.isValueDisplayedAtColumnNameWithTableName("Assigned Immigration Records","Issued By", "1", immigration.get(0).get("issuedBy")));
        Assert.assertTrue(immigrationPage.isValueDisplayedAtColumnNameWithTableName("Assigned Immigration Records","Issued Date", "1", immigration.get(0).get("issuedDate")));
        Assert.assertTrue(immigrationPage.isValueDisplayedAtColumnNameWithTableName("Assigned Immigration Records","Expiry Date", "1", immigration.get(0).get("expiryDate")));
    }
}
