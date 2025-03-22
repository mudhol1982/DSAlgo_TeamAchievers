package AppHooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import DriverManager.Driver_SetUp;
import Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {
	
	public static WebDriver driver;
	
	// This hook runs before all scenarios to initialize the WebDriver
   //@BeforeMethod
//@BeforeAll
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
    @AfterMethod
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
}




//package AppHooks;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.BeforeMethod;
//
//import DriverManager.Driver_SetUp;
//import Utilities.ConfigReader;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.BeforeAll;
//
//public class Hooks {
//	
//	public static WebDriver driver;
//	
//	@Before
////	public void beforeScenario() throws Throwable {
////
////		prop = ConfigReader.initializeprop();
////		// String browser = prop.getProperty("browser");
////		String browser = ConfigReader.getBrowserType();
////		driver = driverFactory.initializeBrowser(browser);
////		driver.get(prop.getProperty("URL"));
////	}
//
//    public  void setUp() throws Exception {
//        // Load the configuration values from config.properties
//        ConfigReader.loadConfig();
//
//        // Get browser type from config file with a default fallback
//        String browser = ConfigReader.getBrowserType();
//
//        // Initialize the WebDriver based on the browser type
//        driver = Driver_SetUp.initializeBrowser(browser);
//
//        // Validate URL exists in config file
//        String url = ConfigReader.getUrl();
//       
//
//        // Navigate to the base URL
//        driver.get(url);
//    }
//
//    // This hook runs after each scenario to quit the WebDriver
//    @AfterMethod
//	public void tearDown() {
//        if (driver != null) {
//            // Close the browser after the test
//            Driver_SetUp.closeDriver();
//        }
//    }
//
//    // Getter for WebDriver (useful in step definitions)
//    public static WebDriver getDriver() {
//        return driver;
//    }
//}
//
//
//
//
//
