package StepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import DriverManager.Driver_SetUp;
import PageObjectModel.DataStructureIntroPom;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.LoginPom;
import PageObjectModel.RegisterPom;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;

public class Step_DataStructPage {
	
	WebDriver driver = Driver_SetUp.getDriver();
	
	public LoginPom login = new LoginPom();
	public HomePom hp = new HomePom();
	public IntroductionPagePom ip = new IntroductionPagePom();
	public RegisterPom regPage = new RegisterPom();
	public DataStructureIntroPom dsintropage = new DataStructureIntroPom();
	
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
		dsintropage.clickDSIntroGetStartedBtn();
	}

	@Then("The user should be directed to  Data Structure introduction Page")
	public void the_user_should_be_directed_to_data_structure_introduction_page() {
		
		
	Assert.assertTrue(dsintropage.validateElementDisplayed(dsintropage.dsIntroductionPageHeader));
	Assert.assertEquals(dsintropage.getTextForElement(dsintropage.dsIntroductionPageHeader), "Data Structures-Introduction");

	Assert.assertEquals(dsintropage.getCurrentUrl(), "https://dsportalapp.herokuapp.com/data-structures-introduction/");
	
	Assert.assertTrue(dsintropage.validateElementDisplayed(dsintropage.timeComplexityLink));
    Assert.assertEquals(dsintropage.getTextForElement(dsintropage.timeComplexityLink), "Time Complexity");
	}
	
	//TC02
	@When("The user clicks Time Complexity button")
	public void the_user_clicks_time_complexity_button() {
		
		    dsintropage.clickTimeComplexityLink();
	}

	@Then("The user should be redirected to Time Complexity section of Data Structures Introduction page")
	public void the_user_should_be_redirected_to_time_complexity_section_of_data_structures_introduction_page() {
		
		Assert.assertTrue(dsintropage.validateElementDisplayed(dsintropage.timeComplexityTopicLink));
		Assert.assertEquals(dsintropage.getTextForElement(dsintropage.timeComplexityTopicLink), "Time Complexity");
		
		Assert.assertTrue(dsintropage.validateElementDisplayed(dsintropage.practiceQuestionsLink));
		Assert.assertEquals(dsintropage.getTextForElement(dsintropage.practiceQuestionsLink), "Practice Questions");
		
		Assert.assertTrue(dsintropage.validateElementDisplayed(dsintropage.tryHereBtn));
		Assert.assertEquals(dsintropage.getTextForElement(dsintropage.tryHereBtn), "Try here>>>");
	}

	//TC03
	@When("The user clicks Try Here button")
	public void the_user_clicks_try_here_button() {
		dsintropage.clickTryHereBtn();
	}

	@Then("The user should be redirected to a page having a try Editor and  Run button")
	public void the_user_should_be_redirected_to_a_page_having_a_try_editor_and_run_button() {
		
		Assert.assertTrue(dsintropage.validateElementDisplayed(dsintropage.textAreaForCode));
		
		Assert.assertTrue(dsintropage.validateElementDisplayed(dsintropage.runButton));
		Assert.assertEquals(dsintropage.getTextForElement(dsintropage.runButton), "Run");
	
	}

	//TC04
	@When("The user clicks the Run Button without entering the code in the Editor")
	public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor() {
		dsintropage.clickRunBtn();
	}

	@Then("The user should not see an error message")
	public void the_user_should_not_see_an_error_message() {
		
		Assert.assertFalse(dsintropage.validateElementDisplayed(dsintropage.consoleOutput));
	}
	
	//TC05
	@When("The user write the invalid code in Editor and click the Run Button")
	public void the_user_write_the_invalid_code_in_editor_and_click_the_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user should able to see an error message in alert window")
	public void the_user_should_able_to_see_an_error_message_in_alert_window() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	}
	

	


