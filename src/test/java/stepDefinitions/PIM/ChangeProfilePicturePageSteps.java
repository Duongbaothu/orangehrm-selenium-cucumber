package stepDefinitions.PIM;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.PIMPageObjects.ChangeProfilePicturePageObject;

public class ChangeProfilePicturePageSteps {
    WebDriver driver;
    ChangeProfilePicturePageObject changeProfilePicturePage;

    public ChangeProfilePicturePageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        changeProfilePicturePage = PageGeneratorManager.getChangeProfilePicturePage(driver);
    }

    @When("Upload Avatar picture {string}")
    public void uploadAvatarPicture(String avatar) {
        changeProfilePicturePage.uploadAvatar(driver, avatar);
    }

    @When("Avatar picture {string} loaded successfully")
    public void AvatarLoadedSuccess(String avatar) {
        Assert.assertTrue(changeProfilePicturePage.isAvatarLoadedSuccess(avatar));
    }
}
