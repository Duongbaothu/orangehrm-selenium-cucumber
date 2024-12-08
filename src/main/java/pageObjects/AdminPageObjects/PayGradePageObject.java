package pageObjects.AdminPageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.CommonPageObject;
import pageUIs.AdminPageUIs.PayGradePageUI;

public class PayGradePageObject extends CommonPageObject {
    private WebDriver driver;

    public PayGradePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isValueDisplayedAtColumnNameInCurrenciesTable( String columnName, String rowIndex, String rowValue) {
        int columnIndex = getListElementSize(driver, PayGradePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME_IN_CURRENCIES_TABLE, columnName) + 1;
        return isElementDisplayed(driver, PayGradePageUI.DYNAMIC_CURRENCY_VALUE_IN_TABLE, rowIndex, String.valueOf(columnIndex), rowValue);
    }
}
