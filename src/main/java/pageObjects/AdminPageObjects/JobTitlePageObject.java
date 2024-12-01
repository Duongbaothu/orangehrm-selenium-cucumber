package pageObjects.AdminPageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;

public class JobTitlePageObject extends BaseElement {
    private WebDriver driver;

    public JobTitlePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
