package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Utilities.ConfigReader;

@CucumberOptions(
	features =   "src/test/resources/features/UC06_linkedListPage.feature", 
		   //"src/test/resources/features/UC02_registerPage.feature",
           //"src/test/resources/features/UC03_loginPage.feature"},      // Specify multiple features
 
        //features = "src/test/resources/features/UC06_linkedListPage.feature", // Path to your feature files
        //glue = "StepDefinitions", // Path to your step definition classes
        glue = {"StepDefinitions", "AppHooks"}, // Package containing step definitions
        //glue = {"com.yourproject.StepDefinitions"},
        monochrome = true, // Makes the console output more readable
        dryRun=false,
        plugin = {
                "pretty", // Pretty print for console output
                "html:target/cucumber-reports/cucumber.html", // cucumber HTML report
                "json:target/cucumber-reports/cucumber.json", // JSON report
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",//allure report
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}//extent report
                //"com.aventstack.chaintest.plugins.ChainTestCucumberListener:"} //chain test report
        
)
public class TestRunner extends AbstractTestNGCucumberTests {

	///////////////////////
	//use this code for cross browser testing
	
//	@BeforeTest
//	@Parameters("browser")
//	public void defineBrowser(String browser) {		
//	   ConfigReader.setBrowserType(browser);
//	}
/////////////////////
	
    @Override
    @DataProvider(parallel = false) // Run tests in parallel with true 
    public Object[][] scenarios() {
        return super.scenarios(); // Get the scenarios from Cucumber
    }
}


