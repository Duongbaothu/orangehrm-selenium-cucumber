package pageObjects.AdminPageObjects;

import pageObjects.CommonPageObject;
import org.openqa.selenium.WebDriver;

public class PayGradePageObject extends CommonPageObject {
    private WebDriver driver;

    public PayGradePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
