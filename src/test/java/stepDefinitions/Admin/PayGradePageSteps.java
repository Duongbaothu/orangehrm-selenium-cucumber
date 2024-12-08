package stepDefinitions.Admin;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.AdminPageObjects.PayGradePageObject;

public class PayGradePageSteps {
    WebDriver driver;
    PayGradePageObject payGradePage;

    public PayGradePageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        payGradePage = PageGeneratorManager.getPayGradePage(driver);
    }

    @And("Verify the table Currencies displays value {string} at column {string}")
    public void verifyTheTableCurrenciesDisplaysValue(String currencySelected, String columnName) {
        Assert.assertTrue(payGradePage.isValueDisplayedAtColumnNameInCurrenciesTable(columnName, "1", currencySelected));

    }
}
