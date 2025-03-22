package runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import DriverManager.Driver_SetUp;
import Utilities.ConfigReader;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@CucumberOptions(
      // features = "src/test/resources/features/UC01_homePage.feature", // Path to your feature files
        		 features = "src/test/resources/features/UC09_graphPage.feature", // Path to your feature files
        
        glue = {"StepDefinitions","AppHooks"}, // Package containing step definitions
        monochrome = true, // Makes the console output more readable
        dryRun = false,
        plugin = {
                "pretty", // Pretty print for console output
                "html:target/cucumber-reports/cucumber.html", // HTML report
                "json:target/cucumber-reports/cucumber.json"  // JSON report
        }
)
public class crossbrowserTestRunner extends AbstractTestNGCucumberTests {
	
	@BeforeTest
    @Parameters("browser") // Use the browser parameter from the testng.xml
    public void setUp(String browser) throws Exception {
	
        System.out.println("Initializing WebDriver for browser: " + browser);
        if (Driver_SetUp.getDriver() == null) {
            Driver_SetUp.initializeBrowser(browser); // Initialize WebDriver for the specified browser
        }
	}
  	  @Override
	    @DataProvider(parallel = true) // Enable parallel execution
	    public Object[][] scenarios() {
	        return super.scenarios(); // Use the default scenarios provided by Cucumber
	    }
    

    // Close the driver after each method to ensure resources are freed
    
//	@AfterTest
//    public void tearDown() {
//        Driver_SetUp.closeDriver(); // Close the driver after each test method
//    }
    
 

}
