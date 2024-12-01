package pageObjects.AdminPageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;

public class PayGradePageObject extends BaseElement {
    private WebDriver driver;

    public PayGradePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
