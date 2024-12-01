package pageObjects.PIMPageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject extends BaseElement {
    private WebDriver driver;

    public DashboardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
