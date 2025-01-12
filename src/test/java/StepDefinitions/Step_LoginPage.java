package StepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.testng.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.LoginPom;
import PageObjectModel.RegisterPom;
import Utilities.ExcelReader;
import io.cucumber.java.en.*;

public class Step_LoginPage {
	
	public LoginPom login = new LoginPom();
	public HomePom hp = new HomePom();
	public IntroductionPagePom ip = new IntroductionPagePom();
	public RegisterPom regPage = new RegisterPom();
	
	
	//TC01 -> Missing User name and Password on login form 
	@Given("The user is on the DS Algo Sign in Page")
	public void the_user_is_on_the_ds_algo_sign_in_page() {
	    hp.openURL();
	    hp.ClickHomePageGetStartedButton();
	    ip.clickOnSignInlink();
	}

	@When("The user clicks login button after leaving the Username textbox and Password textbox empty from sheetname {string} and row {int}")
	public void the_user_clicks_login_button_after_leaving_the_username_textbox_and_password_textbox_empty_from_sheetname_and_row(String string, Integer int1) throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		login.enterLoginFormFields("login", 0);
		login.clickloginBtn();
	}
	    
	    
		@Then("The error message {string} appears below Username textbox")
		public void the_error_message_appears_below_username_textbox(String expectedAlertMessage) {
			String actualAlertMsg = regPage.switchToElementAndGetValidationMessage();
			Assert.assertEquals(actualAlertMsg, expectedAlertMessage);
		}
		
	//TC02 -> Missing User name on login form 
		@When("The user clicks login button after entering the Password only from sheetname {string} and row {int}")
		public void the_user_clicks_login_button_after_entering_the_password_only_from_sheetname_and_row(String string, Integer int1) throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
			login.enterLoginFormFields("login", 1);
			login.clickloginBtn();
		}
	//TC03 -> Missing password on login form 
		
		@When("The user clicks login button after entering the Username and leaves Password textbox empty from sheetname {string} and row {int}")
		public void the_user_clicks_login_button_after_entering_the_username_and_leaves_password_textbox_empty_from_sheetname_and_row(String string, Integer int1) throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
			login.enterLoginFormFields("login", 2);
			login.clickloginBtn();
		}
		
		@Then("The error message {string} appears below Password textbox")
		public void the_error_message_appears_below_password_textbox(String expectedAlertMessage) {
			String actualAlertMsg = regPage.switchToElementAndGetValidationMessage();
			Assert.assertEquals(actualAlertMsg, expectedAlertMessage);
		}

	

//TC04 - invalid user name and invalid password passed to login form 
@When("The user clicks login button after entering invalid username and invalid password from sheetname {string} and row {int}")
public void the_user_clicks_login_button_after_entering_invalid_username_and_invalid_password_from_sheetname_and_row(String string, Integer int1) throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
	login.enterLoginFormFields("login", 3);
	login.clickloginBtn();
}

@Then("The user should able to see an error message {string}")
public void the_user_should_able_to_see_an_error_message(String expectedAlertMessage) {
	Assert.assertEquals(ip.getTextForElement(login.alertMsg), expectedAlertMessage);
	
	}
//TC05 - invalid user name and valid password
@When("The user clicks login button after entering invalid username and valid password {string} and row {int}")
public void the_user_clicks_login_button_after_entering_invalid_username_and_valid_password_and_row(String string, Integer int1) throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
	login.enterLoginFormFields("login", 4);
	login.clickloginBtn();
}

//TC06 - invalid password and valid user name entered

@When("The user clicks login button after entering valid username and invalid password from {string} and row {int}")
public void the_user_clicks_login_button_after_entering_valid_username_and_invalid_password_from_and_row(String string, Integer int1) throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
	login.enterLoginFormFields("login", 5);
	login.clickloginBtn();
}

//TC07 - Login with valid user name and password details 

@When("The user clicks login button after entering valid username and valid password from {string} and row {int}")
public void the_user_clicks_login_button_after_entering_valid_username_and_valid_password_from_and_row(String string, Integer int1) throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
	login.enterLoginFormFields("login", 6);
	login.clickloginBtn();
}

@Then("The user should land in Data Structure Home Page with message {string}")
public void the_user_should_land_in_data_structure_home_page_with_message(String expectedAlertMessage) {
	Assert.assertEquals(ip.getTextForElement(login.alertMsg), expectedAlertMessage);
}

}

