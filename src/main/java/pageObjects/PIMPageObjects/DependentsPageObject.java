package pageObjects.PIMPageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;

public class DependentsPageObject extends BaseElement {
    private WebDriver driver;

    public DependentsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
