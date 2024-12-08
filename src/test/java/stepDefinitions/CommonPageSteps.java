package stepDefinitions;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CommonPageObject;
import testData.EmployeeInfo;
import utilities.CommonUtils;
import utilities.FakerConfig;

import static utilities.CommonUtils.getCurrentDate;
import static utilities.CommonUtils.getEmailRandom;

public class CommonPageSteps {
    WebDriver driver;
    CommonPageObject commonPage;
    FakerConfig fakerConfig;
    static String jobTitle;
    static String employmentStatusName;
    static String payGradeName;
    static String employeeId;
    static String firstName;
    static String lastName;
    static String dependentName;
    EmployeeInfo employeeInfo;
    TestContext testContext;

    public CommonPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        this.testContext = Hooks.getTestContext();
        commonPage = PageGeneratorManager.getCommonPage(driver);

        commonPage = PageGeneratorManager.getCommonPage(driver);
        fakerConfig = FakerConfig.getFaker();
        jobTitle = fakerConfig.getCompanyProfession() + CommonUtils.getNumberRandom();
        employmentStatusName = "Full-time" + CommonUtils.getNumberRandom();
        payGradeName = "Pay Grade" + " " + CommonUtils.getNumberRandom();

        employeeInfo = EmployeeInfo.getEmployee();
        firstName = employeeInfo.getFirstName();
        lastName = employeeInfo.getLastName();

        employeeInfo.setImage("image01.jpg");
        employeeInfo.setWorkEmail(getEmailRandom());
        employeeInfo.setDateAdded(getCurrentDate());

    }

    @And("Open {string} in main menu")
    public void openMainMenu(String mainMenuName) {
        commonPage.openMainMenuPageByName(mainMenuName);
    }

    @Given("Navigate to {string} page in header menu {string}")
    public void openPage(String pageName, String headerMenuName) {
        commonPage.clickToHeaderMenu(headerMenuName);
        commonPage.clickToItemInHeaderMenu(pageName);
    }

    @And("Input to {string} textbox with value {string}")
    public void inputToTextboxWithValue(String fieldName, String inputValue) {
        String currentPage = commonPage.getCurrentPageUrl();
        if (fieldName.equals("Job Title")) {
            inputValue = jobTitle;
        } else if (fieldName.equals("Name")) {
            if (currentPage.contains("payGrade")) {
                inputValue = payGradeName;
            } else if (currentPage.contains("saveEmploymentStatus")) {
                inputValue = employmentStatusName;
            } else if (currentPage.contains("Dependents")) {
            }
        } else if (fieldName.equals("Employee Id")) {
            inputValue = (String) testContext.getDataContext().getContext(Context.EMPLOYEE_ID);
        }
        commonPage.enterToTextboxByText(fieldName, inputValue);
    }

    @And("The column {string} will display value {string}")
    public void verifyTextDisplayedInTable(String columnName, String expectedValue) {
        if (columnName.equals("Job Titles")){
            expectedValue = jobTitle;
        } else if (columnName.equals("Employment Status")) {
            expectedValue = employmentStatusName;
        }
        Assert.assertTrue(commonPage.isRecordPresentInTableByColumnName(columnName, expectedValue));
    }

    @When("Click to {string} radio button")
    public void clickToRadioButton(String radioButtonValue) {
        commonPage.clickToRadioButtonByLabel(radioButtonValue);
    }

    @When("Click to {string} button")
    public void clickToButton(String buttonValue) {
        commonPage.clickToButtonByText(buttonValue);
    }

    @When("Click to Save button of {string}")
    public void clickToSaveButtonWithHeaderName(String headerName) {
        commonPage.clickToSaveButtonWithHeader(headerName);
    }

    @And("Upload a file for {string}")
    public void uploadAFileFor(String uploadFieldLabel) {
        commonPage.uploadFileType(driver, uploadFieldLabel, employeeInfo.getImage());
    }

    @And("Verify file uploaded successfully in {string}")
    public void verifyFileUploadedSuccessfully(String uploadFieldLabel) {
        Assert.assertTrue(commonPage.isFileLoadedSuccess(uploadFieldLabel, employeeInfo.getImage()));
    }

    @Then("Error Message {string} displayed under {string} textbox")
    public void errorMessageDisplayedUnderTextbox(String errorMessage, String textboxLabel) {
        Assert.assertEquals(commonPage.getTextboxErrorMessageByTextboxLabel(textboxLabel), errorMessage);
    }

    @Then("Success message {string} displayed")
    public void successMessageDisplayed(String successMessage) {
        Assert.assertTrue(commonPage.isSuccessMessageDisplayed(successMessage));
    }

    @And("wait a second")
    public void waitForASecond() {
        commonPage.waitForSpinnerIconInvisible();
    }

    @Then("The {string} page will displayed")
    public void thePageWillDisplayed(String pageHeaderName) {
        Assert.assertTrue(commonPage.isPageHeaderDisplayed(pageHeaderName));
    }

    @When("Click to {string} button of label {string}")
    public void clickToButtonOfLabel(String buttonName, String labelName) {
        commonPage.clickToButtonIncludeLabel(labelName, buttonName);
    }

    @And("Select item {string} in dropdown {string}")
    public void selectItemInDropdown(String itemNameInDropdown, String dropwdownName) {
        commonPage.selectInDropdown(dropwdownName, itemNameInDropdown);
    }

    @And("Verify the table {string} - column {string} displays value {string}")
    public void verifyTheValueDisplayedAtTheColumnInTable(String tableName, String columnName, String curencySelected) {
        Assert.assertTrue(commonPage.isValueDisplayedAtColumnNameWithTableName(tableName, columnName, "1", curencySelected));
    }

    @And("Navigate to {string} page in header menu")
    public void navigateToPageInHeaderMenu(String navItemname) {
        commonPage.clickToNavTabItemByText(navItemname);
    }

    @When("Input to {string} textbox name with value {string}")
    public void inputToTextboxNameWithValue(String textboxName, String inputValue) {
        if (textboxName.equals("firstName")) {
            inputValue = employeeInfo.getFirstName();
        } else if (textboxName.equals("lastName")) {
            inputValue = employeeInfo.getLastName();
        }
        commonPage.enterToTextboxByName(textboxName, inputValue);
    }

    @And("Verify {string} textbox name displays {string}")
    public void verifyTextboxNameDisplays(String textboxName, String expectedValue) {
        if (textboxName.equals("firstName")){
            expectedValue =  employeeInfo.getFirstName();
        } else if (textboxName.equals("lastName")) {
            expectedValue = employeeInfo.getLastName();
        }
        Assert.assertEquals(commonPage.getTextboxAttributeByName(textboxName), expectedValue);
    }

    @And("Verify {string} textbox text displays {string}")
    public void verifyTextboxTextDisplays(String textboxText, String expectedValue) {
        if (textboxText.equals("Employee Id")){
            expectedValue = (String) testContext.getDataContext().getContext(Context.EMPLOYEE_ID);
        } else if (textboxText.equals("Name")){
            expectedValue =  payGradeName;
        }
        Assert.assertEquals(commonPage.getTextboxAttributeByText(textboxText), expectedValue);
    }

    @And("Remember {string}")
    public void remember(String textboxText) {
        String employeeId = commonPage.getTextboxAttributeByText(textboxText);
        testContext.getDataContext().setContext(Context.EMPLOYEE_ID, employeeId);
    }


    @Then("Verify the column {string} displays value {string}")
    public void verifyTheValueDisplayedAtTheColumn(String columnName, String rowValue) {
        if (columnName.equals("Id")) {
            rowValue = (String) testContext.getDataContext().getContext(Context.EMPLOYEE_ID);
        }
        Assert.assertTrue(commonPage.isValueDisplayedAtColumnName(columnName, "1", rowValue));
    }
}
