package pageObjects.PIMPageObjects;

import pageObjects.CommonPageObject;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.PIMPageUIs.ChangeProfilePicturePageUI;

public class ChangeProfilePicturePageObject extends CommonPageObject {
    private WebDriver driver;

    public ChangeProfilePicturePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void uploadAvatar(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.getGlobalConstants().getUploadPath();
        String fullFileName = "";
        for (String file: fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getWebElement(driver, ChangeProfilePicturePageUI.UPLOAD_AVATAR_BUTTON).sendKeys(fullFileName);
        sleepInSeconds(2);
    }

    public boolean isAvatarLoadedSuccess(String fileName) {
        waitForElementVisible(driver, ChangeProfilePicturePageUI.AVATAR_LOADED, fileName);
        return isElementDisplayed(driver, ChangeProfilePicturePageUI.AVATAR_LOADED, fileName);
    }
}

