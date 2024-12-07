package pageObjects.PIMPageObjects;

import pageObjects.CommonPageObject;
import org.openqa.selenium.WebDriver;
import pageUIs.PIMPageUIs.EmployeeListPageUI;

public class EmployeeListPageObject extends CommonPageObject {
    private WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickEmployeeActionIconByClass(String employeeID, String iconClass) {
        waitForElementClickable(driver, EmployeeListPageUI.DYNAMIC_ACTION_ICON_BY_CLASS, employeeID, iconClass);
        clickToElement(driver, EmployeeListPageUI.DYNAMIC_ACTION_ICON_BY_CLASS, employeeID, iconClass);
        waitForSpinnerIconInvisible();
    }
}
