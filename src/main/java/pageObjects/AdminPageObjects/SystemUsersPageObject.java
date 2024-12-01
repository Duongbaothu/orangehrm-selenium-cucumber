package pageObjects.AdminPageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;

public class SystemUsersPageObject extends BaseElement {
    private WebDriver driver;

    public SystemUsersPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
