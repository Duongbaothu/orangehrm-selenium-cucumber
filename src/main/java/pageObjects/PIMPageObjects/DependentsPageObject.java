package pageObjects.PIMPageObjects;

import pageObjects.CommonPageObject;
import org.openqa.selenium.WebDriver;

public class DependentsPageObject extends CommonPageObject {
    private WebDriver driver;

    public DependentsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
