package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefoxDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        FirefoxOptions ffOption = new FirefoxOptions();
        ffOption.addArguments("--headless");
        ffOption.addArguments("window-size=1920x1080");
        return new FirefoxDriver(ffOption);
    }
}
