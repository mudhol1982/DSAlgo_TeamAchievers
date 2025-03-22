package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utilities.ConfigReader;

@CucumberOptions(
	features =   "src/test/resources/features/UC04_dataStructureIntro.feature", 
		  
        glue = {"StepDefinitions", "AppHooks"}, // Package containing step definitions
               monochrome = true, 
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
	

	    @Override
    @DataProvider(parallel = true) // Run tests in parallel with true 
    public Object[][] scenarios() {
        return super.scenarios(); // Get the scenarios from Cucumber
    }
    
   

	}
    