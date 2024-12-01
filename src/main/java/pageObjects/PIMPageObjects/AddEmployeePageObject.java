package pageObjects.PIMPageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;

public class AddEmployeePageObject extends BaseElement {
    private WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
