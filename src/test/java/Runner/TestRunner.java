package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		
		features =   {
		   "src/test/resources/features/UC04_dataStructureIntro.feature"}, 
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
                "html:target/cucumber-reports/cucumber.html", // HTML report
                "json:target/cucumber-reports/cucumber.json", // JSON report
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",//allure report
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} //extent report
        
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false) // Run tests in parallel
    public Object[][] scenarios() {
        return super.scenarios(); // Get the scenarios from Cucumber
    }
}


