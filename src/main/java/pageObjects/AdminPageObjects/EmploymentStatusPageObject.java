package pageObjects.AdminPageObjects;

import pageObjects.CommonPageObject;
import org.openqa.selenium.WebDriver;

public class EmploymentStatusPageObject extends CommonPageObject {
    private WebDriver driver;

    public EmploymentStatusPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
