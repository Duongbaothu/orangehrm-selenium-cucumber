package pageObjects.AdminPageObjects;

import pageObjects.CommonPageObject;
import org.openqa.selenium.WebDriver;

public class JobTitlePageObject extends CommonPageObject {
    private WebDriver driver;

    public JobTitlePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
