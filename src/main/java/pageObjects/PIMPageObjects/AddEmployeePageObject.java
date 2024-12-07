package pageObjects.PIMPageObjects;

import pageObjects.CommonPageObject;
import org.openqa.selenium.WebDriver;

public class AddEmployeePageObject extends CommonPageObject {
    private WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
