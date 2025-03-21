package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		features = {
		        "src/test/resources/features/UC01_homePage.feature/",
		        "src/test/resources/features/UC02_registerPage.feature"
		    }, 
    glue = {"StepDefinitions", "AppHooks"}, // Package containing step definitions
    monochrome = true, // Makes the console output more readable
    dryRun = false,
    tags = "@HomeTest02 or @RegisterTest02", // Run only these scenarios
    plugin = {
        "pretty", // Pretty print for console output
        "html:target/cucumber-reports/parallel/cucumber.html", // Cucumber HTML report
        "json:target/cucumber-reports/parallel/cucumber.json", // JSON report
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", // Allure report
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // Extent report
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    
    @Override
    @DataProvider(parallel = true) // Run tests in parallel
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
