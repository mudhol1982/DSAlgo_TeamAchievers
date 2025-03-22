package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import DriverManager.Driver_SetUp;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = {"StepDefinitions", "AppHooks"}, // Package containing step definitions
        monochrome = true, // Makes the console output more readable
        dryRun = false,
        plugin = {
                "pretty", // Pretty print for console output
                "html:target/cucumber-reports/cucumber.html", // HTML report
                "json:target/cucumber-reports/cucumber.json"  // JSON report
        }
)
public class crossbrowserTestRunner extends AbstractTestNGCucumberTests {

    // This will run before any test method in the <test> section of the testng.xml
    @BeforeTest
    @Parameters("browser") // Use the browser parameter from the testng.xml
    public void setUp(String browser) throws Exception {
        System.out.println("Initializing WebDriver for browser: " + browser);
        if (Driver_SetUp.getDriver() == null) {
            Driver_SetUp.initializeBrowser(browser); // Initialize WebDriver for the specified browser
        }
    }

    // Close the driver after each method to ensure resources are freed
    @AfterTest
    public void tearDown() {
        Driver_SetUp.closeDriver(); // Close the driver after each test method
    }

}
