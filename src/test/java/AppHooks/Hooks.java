package AppHooks;

import DriverManager.Driver_SetUp;  // Import Driver_SetUp class
import Utilities.ConfigReader;      // Import ConfigReader
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;

    // This hook runs before each scenario to initialize the WebDriver
    @Before
    public void setUp() throws Exception {
        // Load the configuration values from config.properties
        ConfigReader.loadConfig();

        // Get browser type from config file
        String browser = ConfigReader.getBrowserType();

        // Initialize the WebDriver based on the browser type
        driver = Driver_SetUp.initializeBrowser(browser);

        // Get the URL from the config file and navigate to it
        String url = ConfigReader.getUrl();
        driver.get(url);  // Open the application URL
    }

    // This hook runs after each scenario to quit the WebDriver
   // @After
   // public void tearDown() {
   //     if (driver != null) {
   //         Driver_SetUp.closeDriver();  // Close the browser after the test
   //     }
   // }

    // Getter for WebDriver (useful in step definitions)
    public WebDriver getDriver() {
        return driver;
    }
}
