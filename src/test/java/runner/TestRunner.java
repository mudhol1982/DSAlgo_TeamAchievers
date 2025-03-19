package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        //glue = "StepDefinitions", // Path to your step definition classes
        glue = {"StepDefinitions", "AppHooks"}, // Package containing step definitions
        //glue = {"com.yourproject.StepDefinitions"},
        monochrome = true, // Makes the console output more readable
        dryRun=false,
        plugin = {
                "pretty", // Pretty print for console output
                "html:target/cucumber-reports/cucumber.html", // HTML report
                "json:target/cucumber-reports/cucumber.json"  // JSON report
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false) // Run tests in parallel
    public Object[][] scenarios() {
        return super.scenarios(); // Get the scenarios from Cucumber
    }
    
   

	}
    