package pageObjects.AdminPageObjects;

import pageObjects.CommonPageObject;
import org.openqa.selenium.WebDriver;

public class SystemUsersPageObject extends CommonPageObject {
    private WebDriver driver;

    public SystemUsersPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
