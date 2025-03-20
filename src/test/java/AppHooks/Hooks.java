package AppHooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverManager.Driver_SetUp;
import Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private static WebDriver driver;
	
	// This hook runs before all scenarios to initialize the WebDriver
    @BeforeAll
    public static void setUp() throws Exception {
        // Load the configuration values from config.properties
        ConfigReader.loadConfig();

        // Get browser type from config file with a default fallback
        String browser = ConfigReader.getBrowserType();
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser type not specified in config.properties");
        }

        // Initialize the WebDriver based on the browser type
        driver = Driver_SetUp.initializeBrowser(browser);

        // Validate URL exists in config file
        String url = ConfigReader.getUrl();
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL not specified in config.properties");
        }

        // Navigate to the base URL
        driver.get(url);
    }
    
    

    // This hook runs after each scenario to quit the WebDriver
    @After
    public void tearDown() {
        if (driver != null) {
            // Close the browser after the test
            Driver_SetUp.closeDriver();
        }
    }

    // Getter for WebDriver (useful in step definitions)
    public static WebDriver getDriver() {
        return driver;
    }
    
    
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }
        driver.quit();
    }
}

