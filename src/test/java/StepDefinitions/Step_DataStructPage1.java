package StepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import DriverManager.Driver_SetUp;
import PageObjectModel.DataStructureIntroPom;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.LoginPom;
import PageObjectModel.RegisterPom;
import PageObjectModel.TryEditorDsPom;
import io.cucumber.java.en.*;

public class Step_DataStructPage1 {

	WebDriver driver = Driver_SetUp.getDriver();
	
//	
//	@Given("The user is on the home page after sign in")
//	public void the_user_is_on_the_home_page_after_sign_in()
//			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
//		HomePom home = new HomePom();
//		LoginPom login = new LoginPom();
//		DataStructureIntroPom dsIntro = new DataStructureIntroPom();
//		home.openURL();
//		home.ClickHomePageGetStartedButton();
//		login.enterLoginFormFields("login", 6); // row 6 contains valid credentials
//		login.clickloginBtn();
//
//	}
//
//	@When("The user clicks the Get Started button under Data Structures Introduction section")
//	public void the_user_clicks_the_get_started_button_under_data_structures_introduction_section() {
//		 DataStructureIntroPom dsIntro = new DataStructureIntroPom();
//		 dsIntro.clickGetStartedBtn(); // Navigates to Data Structure Introduction Page
//		 
//	}
//
//	@Then("The user should be directed to  Data Structure introduction Page")
//	public void the_user_should_be_directed_to_data_structure_introduction_page() {
//		
//	DataStructureIntroPom dsIntro = new DataStructureIntroPom();
//    Assert.assertTrue(dsIntro.validateElementDisplayed(dsIntro.dsPageTitle));
//    Assert.assertEquals(dsIntro.getTextForElement(dsIntro.dsPageTitle), "Data Structures-Introduction");
//	
//		
//	}
//
//
////	//1. Background Step
////	@Given("The user is on the DS algo Login page")
////	public void the_user_is_on_the_ds_algo_login_page() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
////		 HomePom home = new HomePom();
////		    LoginPom login = new LoginPom();
////		    DataStructureIntroPom dsIntro = new DataStructureIntroPom();
////		    
////		    home.openURL();
////		    home.ClickHomePageGetStartedButton();
////		    login.enterLoginFormFields("login", 6);  //  row 6 contains valid credentials
////		    login.clickloginBtn();
////	}
////	
////	
////
////	@Given("The user is on the Data Structures Introduction page after sign in")
////	public void the_user_is_on_the_data_structures_introduction_page_after_sign_in() {
////	    // Write code here that turns the phrase above into concrete actions
////	    throw new io.cucumber.java.PendingException();
////	}
////
////
////	
////	@Given("The user is on the Data Structure Introduction Page")
////	public void the_user_is_on_the_data_structure_introduction_page() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
////		   HomePom home = new HomePom();
////		    LoginPom login = new LoginPom();
////		    DataStructureIntroPom dsIntro = new DataStructureIntroPom();
////		    
////		    home.openURL();
////		    home.ClickHomePageGetStartedButton();
////		    login.enterLoginFormFields("login", 6);  //  row 6 contains valid credentials
////		    login.clickloginBtn();
////		   dsIntro.clickGetStartedBtn(); // Navigates to Data Structure Introduction Page
////		
////	}
////
////	
////
////@Given("The user is on the home page after sign in")
////public void the_user_is_on_the_home_page_after_sign_in() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
////	  HomePom home = new HomePom();
////	    LoginPom login = new LoginPom();
////	    DataStructureIntroPom dsIntro = new DataStructureIntroPom();
////	    
////	    home.openURL();
////	    home.ClickHomePageGetStartedButton();
////	    login.enterLoginFormFields("login", 6);  //  row 6 contains valid credentials
////	    login.clickloginBtn();
////}
////
////	
//////	@Given("The user is on the home page after sign in")
//////	public void the_user_is_on_the_home_page_after_sign_in() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
//////		 hp.openURL();
//////         hp.ClickHomePageGetStartedButton();
//////         ip.clickOnSignInlink();
//////         login.enterLoginFormFields("login", 6);
//////	     login.clickloginBtn();
//////	}
////	
////   //2. Scenario-Specific Steps
////	//Scenario 1: Navigate to Data Structures Introduction Page
////	
////	@When("The user clicks the Get Started button under Data Structures Introduction section")
////	public void the_user_clicks_the_get_started_button_under_data_structures_introduction_section() {
////		 DataStructureIntroPom dsIntro = new DataStructureIntroPom();
////		 dsIntro.clickGetStartedBtn();
////	}
////
////	@Then("The user should be directed to  Data Structure introduction Page")
////	public void the_user_should_be_directed_to_data_structure_introduction_page() {
////		
////		DataStructureIntroPom dsIntro = new DataStructureIntroPom();
////	    Assert.assertTrue(dsIntro.validateElementDisplayed(dsIntro.dsPageTitle));
////	    Assert.assertEquals(dsIntro.getTextForElement(dsIntro.dsPageTitle), "Data Structures-Introduction");
////		
//////		Assert.assertTrue(dp.validateElementDisplayed(dp.dsPageTitle));
//////		Assert.assertEquals(dp.getTextForElement(dp.dsPageTitle), "Data Structures-Introduction");
//////		Assert.assertTrue(dp.validateElementDisplayed(dp.timeComplexityLink));
//////	    Assert.assertEquals(dp.getTextForElement(dp.timeComplexityLink), "Time Complexity");
////	}
////	
//////	@Given("The user is in the Data Structures - Introduction page")
//////	public void the_user_is_in_the_data_structures_introduction_page() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
//////		 hp.openURL();
//////         hp.ClickHomePageGetStartedButton();
//////         ip.clickOnSignInlink();
//////        login.enterLoginFormFields("login", 6);
//////     login.clickloginBtn();
//////	 dp.clickGetStartedBtn();
//////		
//////			}
////    //Scenario 2: Navigate to Time Complexity Page
////	
////	@When("The user clicks Time Complexity button")
////	public void the_user_clicks_time_complexity_button() {
////	 DataStructureIntroPom dsIntro = new DataStructureIntroPom();
////      dsIntro.clickTimeComplexityLink();
////	}
////
//////	@Then("The user should be redirected to Time Complexity section of Data Structures Introduction page")
//////	public void the_user_should_be_redirected_to_time_complexity_section_of_data_structures_introduction_page() {
//////		
////////	Assert.assertTrue(dp.validateElementDisplayed(dp.timeComplexityLink));
////////	Assert.assertEquals(dp.getTextForElement(dp.timeComplexityLink), "Time Complexity");
////////	
////////	Assert.assertTrue(dp.validateElementDisplayed(dp.practiceQuestionsLink));
////////	Assert.assertEquals(dp.getTextForElement(dp.practiceQuestionsLink), "Practice Questions");
////////	
////////	Assert.assertTrue(dp.validateElementDisplayed(tp.tryHereButton));
////////	Assert.assertEquals(dp.getTextForElement(tp.tryHereButton), "Try here>>>");
////////	}
////	
////
////	@Then("The user should be redirected to Time Complexity section of Data Structures Introduction page")
////	public void the_user_should_be_redirected_to_time_complexity_section_of_data_structures_introduction_page() {
////	    DataStructureIntroPom dsIntro = new DataStructureIntroPom();
////	    Assert.assertTrue(dsIntro.validateElementDisplayed(dsIntro.timeComplexityLink));
////	    Assert.assertEquals(dsIntro.getTextForElement(dsIntro.timeComplexityLink), "Time Complexity");
////	}
////	
////	//	 //Scenario 3: Navigate to Try Here Page
////	@When("The user clicks Try Here button")
////	public void the_user_clicks_try_here_button() {
////	    TryEditorDsPom tryEditor = new TryEditorDsPom();
////	    tryEditor.clickTryHereBtn();
////	}
////
////	@Then("The user should be redirected to a page having a try Editor and Run button")
////	public void the_user_should_be_redirected_to_a_page_having_a_try_editor_and_run_button() {
//////		    TryEditorDsPom tryEditor = new TryEditorDsPom();
//////		    Assert.assertTrue(tryEditor.validateElementDisplayed(tryEditor.tryEditor));
//////		    Assert.assertTrue(tryEditor.validateElementDisplayed(tryEditor.runButton));
////		
////		TryEditorDsPom tryEditor = new TryEditorDsPom();
////		 DataStructureIntroPom dsIntro = new DataStructureIntroPom();
////		
////        Assert.assertTrue(dsIntro.validateElementDisplayed(tryEditor.textAreaForCode));
////		Assert.assertTrue(dsIntro.validateElementDisplayed(tryEditor.runButton));
////		Assert.assertEquals(dsIntro.getTextForElement(tryEditor.runButton), "Run");
////	}
////	
//		
//}
//
//
//
//
//
//
//
