package AppHooks;

import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import DriverManager.Driver_SetUp;
import Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {

    private WebDriver driver;

    // Runs before each scenario
    @Before
    public void setUp() throws Exception {
        // Load configuration file
        ConfigReader.loadConfig();

        // Get browser type from config file with a default fallback
        String browser = ConfigReader.getBrowserType();
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser type not specified in config.properties");
        }

        // Initialize the WebDriver
        Driver_SetUp.initializeBrowser(browser);
        driver = Driver_SetUp.getDriver(); // Store driver instance

        // Validate and navigate to base URL
        String url = ConfigReader.getUrl();
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL not specified in config.properties");
        }
        driver.get(url);
    }

    // Runs after each scenario
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && driver != null) {
            // Capture screenshot if the scenario failed
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            
            // Attach the screenshot to the Allure report
            Allure.addAttachment(scenario.getName() + " - Screenshot", new ByteArrayInputStream(screenshot));
        }

        // Close the browser after the test
        Driver_SetUp.closeDriver();
    }
}
