package StepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import DriverManager.Driver_SetUp;
import PageObjectModel.DataStructureIntroPom;
import PageObjectModel.HomePom;
import PageObjectModel.LoginPom;
import PageObjectModel.TryEditorDsPom;
import Utilities.ExcelReader;
import io.cucumber.java.en.*;

public class Step_DataStructurePage {

	WebDriver driver = Driver_SetUp.getDriver();

	// TC01
	@When("The user clicks the Get Started button of Data Structure Introduction section")
	public void the_user_clicks_the_get_started_button_of_data_structure_introduction_section() {
		DataStructureIntroPom dsIntro = new DataStructureIntroPom();
		dsIntro.clickGetStartedBtn(); // Navigates to Data Structure Introduction Page
	}

	@Then("The user should be directed to  Data Structure introduction Page")
	public void the_user_should_be_directed_to_data_structure_introduction_page() {

		DataStructureIntroPom dsIntro = new DataStructureIntroPom();

		Assert.assertTrue(dsIntro.validateElementDisplayed(dsIntro.dsPageTitle));
		Assert.assertEquals(dsIntro.getTextForElement(dsIntro.dsPageTitle), "Data Structures-Introduction");
	}

    //TC02
	@Given("The user is in the Data Structures-Introduction page")
	public void the_user_is_in_the_data_structures_introduction_page() {
		DataStructureIntroPom dsIntro = new DataStructureIntroPom();
		dsIntro.clickGetStartedBtn();
		
		//try with assert
	}

	@When("The user clicks Time Complexity link")
	public void the_user_clicks_time_complexity_link() {
		DataStructureIntroPom dsIntro = new DataStructureIntroPom();
		dsIntro.clickTimeComplexityLink();
	}

	@Then("The user should be redirected to Time Complexity page of  Data Structure introduction")
	public void the_user_should_be_redirected_to_time_complexity_page_of_data_structure_introduction() {
		
		DataStructureIntroPom dsIntro = new DataStructureIntroPom();
		Assert.assertTrue(dsIntro.validateElementDisplayed(dsIntro.timeComplexityLink));
	    Assert.assertEquals(dsIntro.getTextForElement(dsIntro.timeComplexityLink), "Time Complexity");
	}
	
	//TC03
	@Given("The user is in the Time Complexity page")
	public void the_user_is_in_the_time_complexity_page() {

		DataStructureIntroPom dsIntro = new DataStructureIntroPom();
		dsIntro.clickGetStartedBtn();
		dsIntro.clickTimeComplexityLink();
	}

	@When("The user clicks Try Here button in Time Complexity page")
	public void the_user_clicks_try_here_button_in_time_complexity_page() {
		TryEditorDsPom tp = new TryEditorDsPom();
		tp.clickTryHereBtn();
		
	}

	@Then("The user should be redirected to a page having an try Editor with a Run button")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button() {
		
		TryEditorDsPom tp = new TryEditorDsPom();
		DataStructureIntroPom dsIntro = new DataStructureIntroPom();
		
		Assert.assertTrue(dsIntro.validateElementDisplayed(tp.textAreaForCode));
		
		Assert.assertTrue(dsIntro.validateElementDisplayed(tp.runButton));
		Assert.assertEquals(dsIntro.getTextForElement(tp.runButton), "Run");
	}
	
	//TC04
	@Given("The user is in the tryEditor page of Time Complexity page")
	public void the_user_is_in_the_try_editor_page_of_time_complexity_page() {
		DataStructureIntroPom dsIntro = new DataStructureIntroPom();
		TryEditorDsPom tp = new TryEditorDsPom();
		
		dsIntro.clickGetStartedBtn();
		dsIntro.clickTimeComplexityLink();
		tp.clickTryHereBtn();
		
	}

	@When("The user clicks the Run button without entering the code in the text area editor from sheetname {string} and row {int}")
	public void the_user_clicks_the_run_button_without_entering_the_code_in_the_text_area_editor_from_sheetname_and_row(String string, Integer int1) {
		
		//WebDriver driver = Driver_SetUp.getDriver(); // Initialize WebDriver
	    TryEditorDsPom tp = new TryEditorDsPom(); // Initialize the POM class
	   
	    // Clears the editor before clicking the Run button
        tp.clearEditorCode(); // Clears the code from the editor
        tp.clickRunButton();  // Clicks the "Run" button
		
	}

	@Then("The user should not get any error message in alert window")
	public void the_user_should_not_get_any_error_message_in_alert_window() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // WebDriverWait to wait for elements
		
		 try {
	            // Wait for an alert to be present (if any) and check if it appears
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	            // If an alert appears unexpectedly, print its message and throw an exception
	            System.out.println("Unexpected alert displayed: " + alert.getText());
	            alert.accept(); // Close the alert
	            throw new AssertionError("Unexpected alert displayed.");
	            
	        } catch (Exception e) {
	            // If no alert appears, log the expected behavior (no alert)
	            System.out.println("No alert displayed as expected.");
	        }
	    }
	
	
	//TC05
	@When("The user clicks run button by entering invalid code from sheetname {string} and row {int}")
	public void the_user_clicks_run_button_by_entering_invalid_code_from_sheetname_and_row(String string, Integer int1) {
		TryEditorDsPom tp = new TryEditorDsPom(); // Initialize your POM
		  ExcelReader excelReader = new ExcelReader(); // Initialize the custom Excel reader
       
		  try {
		        // Get the data from Excel file
		        List<Map<String, String>> excelData = excelReader.getData("src/test/resources/Excel/TestData.xlsx", sheetname);
        
		        // Get the code (assuming the code is stored in a column named "pcode")
		        String pythonCode = excelData.get(2).get("pcode"); //  "pcode" is the column name for the code
		     // Clear existing code in the editor
		        tp.clearEditorCode();
		        
		        // Click the "Run" button to execute the code
		        
		        tp.clickRunButton();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
    }       
           
	
	// Step Definition for verifying the presence of an error message in the alert window

	@Then("The user should able to see an error message in alert window")
	public void the_user_should_able_to_see_an_error_message_in_alert_window() {
		
		TryEditorDsPom tp = new TryEditorDsPom(); // Initialize your POM
		
		// Check if an alert is present
		        boolean alertPresent = tp.isAlertPresent();
		        
		        // Assert that an alert is present (condition first, message second)
		        assertTrue(alertPresent, "Expected an error alert to be displayed, but it was not.");
		        		        
		        // If an alert is present, display the error message
		        if (alertPresent) {
		        	tp.displayAlert();// Print out the error message to the console
		        }
	} 
	

	//TC06
	@When("The user clicks run button by entering valid code from sheetname {string} and row {int}")
	public void the_user_clicks_run_button_by_entering_valid_code_from_sheetname_and_row(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user should able to see console output for valid code from sheetname {string} and row {int}")
	public void the_user_should_able_to_see_console_output_for_valid_code_from_sheetname_and_row(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	//TC07
	@When("The user clicks Practice Questions link")
	public void the_user_clicks_practice_questions_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user should be redirected to Practice Questions page of Data structures Introduction")
	public void the_user_should_be_redirected_to_practice_questions_page_of_data_structures_introduction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}
