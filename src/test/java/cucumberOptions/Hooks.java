package cucumberOptions;

import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import stepDefinitions.TestContext;
import utilities.PropertiesConfig;

import java.util.concurrent.TimeUnit;

public class Hooks {
    // Run for many thread
    private static WebDriver driver;
    private static final Logger log = LogManager.getLogger(Hooks.class);
    private static TestContext testContext;

    @Before
    public synchronized static WebDriver openAndQuitBrowser() {
        String browser = System.getProperty("BROWSER");
        System.out.println("Browser name run by command line = " + browser);

        String url = "";

        if (testContext == null) {
            testContext = new TestContext();
            log.info("TestContext initialized");
        }

        if (browser == null) {
            browser = System.getenv("BROWSER");
            if (browser == null) {
                browser = "chrome";
            }
        }

        if (driver == null) {
            try {
                switch (browser) {
                    case "chrome":
                        driver = new ChromeDriver();
                        break;
                    case "hchrome":
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("headless");
                        chromeOptions.addArguments("window-size=1920x1080");
                        driver = new ChromeDriver(chromeOptions);
                        break;
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                    case "hfirefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--headless");
                        driver = new FirefoxDriver(firefoxOptions);
                        break;
                    case "edge":
                        driver = new EdgeDriver();
                        break;
                    default:
                        driver = new ChromeDriver();
                        break;
                }
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }

            try {
                String environment = System.getProperty("environment", "local"); // Default là "local"
                PropertiesConfig propertiesConfig = new PropertiesConfig(environment);
                String applicationUrl = propertiesConfig.getApplicationUrl();
                driver.get(applicationUrl);
                log.info("Opened URL for environment [" + environment + "]: " + applicationUrl);
            } catch (Exception e) {
                log.error("Failed to load URL from properties file for the specified environment.", e);
            }

            driver.manage().window().setPosition(new Point(0, 0));
            driver.manage().window().setSize(new Dimension(1920, 1080));
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            log.info("------------- Started the browser -------------");
        }
        return driver;
    }

    public static TestContext getTestContext() {
        if (testContext == null) {
            testContext = new TestContext();
        }
        return testContext;
    }

    public static void close() {
        try {
            if (driver != null) {
                openAndQuitBrowser().quit();
                log.info("------------- Closed the browser -------------");
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("Can not close the browser");
        }
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }

}
