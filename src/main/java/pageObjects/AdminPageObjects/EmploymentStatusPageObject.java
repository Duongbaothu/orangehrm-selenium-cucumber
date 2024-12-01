package pageObjects.AdminPageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;

public class EmploymentStatusPageObject extends BaseElement {
    private WebDriver driver;

    public EmploymentStatusPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
