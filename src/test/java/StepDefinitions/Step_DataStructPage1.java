package StepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import DriverManager.Driver_SetUp;
import PageObjectModel.DataStructureIntroPom;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.LoginPom;
import PageObjectModel.RegisterPom;
import PageObjectModel.TryEditorDsPom;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.*;



public class Step_DataStructPage {
	
	WebDriver driver = Driver_SetUp.getDriver();
	
	
	
    public LoginPom login = new LoginPom();
	public HomePom hp = new HomePom();
	public IntroductionPagePom ip = new IntroductionPagePom();
	public RegisterPom regPage = new RegisterPom();
	public DataStructureIntroPom dp = new DataStructureIntroPom();
	public TryEditorDsPom tp = new TryEditorDsPom();

	//TC01	
	@Given("The user is on the home page after sign in")
public void the_user_is_on_the_home_page_after_sign_in() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		 hp.openURL();
      hp.ClickHomePageGetStartedButton();
       ip.clickOnSignInlink();
        login.enterLoginFormFields("login", 6);
     login.clickloginBtn();
}

	@When("The user clicks the Get Started button under Data Structures Introduction section")
	public void the_user_clicks_the_get_started_button_under_data_structures_introduction_section() {
		dp.clickGetStartedBtn();
	}

	@Then("The user should be directed to  Data Structure introduction Page")
	public void the_user_should_be_directed_to_data_structure_introduction_page() {
				    
		String expectedTitle = "Data Structures-Introduction";
		String actualTitle = dp.getPageTitle(); 
		assertEquals("Page title does not match.", expectedTitle, actualTitle);
			}

//	@Given("The user is in the Data Structures - Introduction page")
//	public void the_user_is_in_the_data_structures_introduction_page() {
//		dp.clickGetStartedBtn();
//	}
//
//	@When("The user clicks Time Complexity link")
//	public void the_user_clicks_time_complexity_link() {
//	   dp.clickTimeComplexityLink();
//	}
//
//	@Then("The user should be redirected to Time Complexity section of Data Structures Introduction page")
//	public void the_user_should_be_redirected_to_time_complexity_section_of_data_structures_introduction_page() {
//   
//		String expectedTitle = "Time Complexity";
//		String actualTitle = dp.getPageTitle(); 
//		assertEquals("Page title does not match.", expectedTitle, actualTitle);
//	}
//
//	@Given("The user is in the Time Complexity page")
//	public void the_user_is_in_the_time_complexity_page() {
//	    dp.clickGetStartedBtn();
//		dp.clickTimeComplexityLink();
//	}
//
//	@When("The user clicks Try Here button in Time Complexity page")
//	public void the_user_clicks_try_here_button_in_time_complexity_page() {
//		tp.clickTryHereBtn();
//	}
//
//	@Then("The user should be redirected to a page having a try Editor with Run button")
//	public void the_user_should_be_redirected_to_a_page_having_a_try_editor_with_run_button() {
//	    Assert.assertTrue(dp.validateElementDisplayed(tp.textAreaForCode));
//		Assert.assertTrue(dp.validateElementDisplayed(tp.runButton));
//		Assert.assertEquals(dp.getTextForElement(tp.runButton), "Run");
//
//
//	}
//
//	@Given("The user is in the tryEditor page of Time Complexity page")
//	public void the_user_is_in_the_try_editor_page_of_time_complexity_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("The user clicks the Run Button without entering the code in the Editor")
//	public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("The user should not see an error message")
//	public void the_user_should_not_see_an_error_message() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("The user is in the tryEditor page of Time Complexity Page")
//	public void the_user_is_in_the_try_editor_page_of_time_complexity_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("The user write the invalid code from sheetname {string} and row {int} and click Run Button")
//	public void the_user_write_the_invalid_code_from_sheetname_and_row_and_click_run_button(String string, Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("The user should be able to see an error message in alert window")
//	public void the_user_should_be_able_to_see_an_error_message_in_alert_window() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("The user write the valid code from sheetname {string} and row {int} and click Run Button")
//	public void the_user_write_the_valid_code_from_sheetname_and_row_and_click_run_button(String string, Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("The user should be able to see output in the console")
//	public void the_user_should_be_able_to_see_output_in_the_console() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("The user clicks the Practice Questions link")
//	public void the_user_clicks_the_practice_questions_link() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("The user should be redirected to Practice Questions of Data structures Introduction")
//	public void the_user_should_be_redirected_to_practice_questions_of_data_structures_introduction() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}



	    }



	


