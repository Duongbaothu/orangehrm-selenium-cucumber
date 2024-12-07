package pageObjects.PIMPageObjects;

import pageObjects.CommonPageObject;
import org.openqa.selenium.WebDriver;
import pageUIs.PIMPageUIs.SalaryPageUI;
import org.testng.Assert;
import testData.EmployeeInfo;

public class SalaryPageObject extends CommonPageObject {
    private WebDriver driver;

    public SalaryPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToDirectDepositAmountTextbox(String valueToSendkey) {
        waitForElementVisible(driver, SalaryPageUI.DIRECT_DEPOSIT_AMOUNT_TEXTBOX);
        sendkeyToElement(driver, SalaryPageUI.DIRECT_DEPOSIT_AMOUNT_TEXTBOX, valueToSendkey);
    }

    public void setSalary(EmployeeInfo employeeInfo) {
        enterToTextboxByText("Salary Component", employeeInfo.getSalaryComponent());
        selectInDropdown("Pay Frequency", employeeInfo.getPayFrequency());
        selectInDropdown("Currency", employeeInfo.getCurrency());
        enterToTextboxByText("Amount", employeeInfo.getAmount1());
    }

    public void setDirectDepositDetails(EmployeeInfo employeeInfo) {
        enterToTextboxByText("Account Number", employeeInfo.getAccountNumber());
        selectInDropdown("Account Type", employeeInfo.getAccountType());
        enterToTextboxByText("Routing Number", employeeInfo.getRoutingNumber());
        enterToDirectDepositAmountTextbox(employeeInfo.getAmount2());
    }

    public void verifySalary(EmployeeInfo employeeInfo) {
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Salary Components","Salary Component", "1", employeeInfo.getSalaryComponent()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Salary Components","Amount", "1", employeeInfo.getAmount1()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Salary Components","Currency", "1", employeeInfo.getCurrency()));
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Salary Components","Pay Frequency", "1", employeeInfo.getPayFrequency()));
    }

    public void verifyDirectDepositDetails(EmployeeInfo employeeInfo) {
        Assert.assertTrue(isValueDisplayedAtColumnNameWithTableName("Assigned Salary Components","Direct Deposit Amount", "1", employeeInfo.getAmount2()));
    }
}
