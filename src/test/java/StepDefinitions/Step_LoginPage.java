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
	    
	    
	@Then("The error message Please fill out this field. appears below Username textbox")
	public void the_error_message_please_fill_out_this_field_appears_below_username_textbox() {
		String browserValidationmsg = regPage.switchToElementAndGetValidationMessage();
		String expectedErrorMsg = "Please fill out this field.";
		Assert.assertEquals(browserValidationmsg, expectedErrorMsg);
	}
	
//	//TC02 -> Missing User name on login form 
//	
//	@When("The user clicks login button after entering the Password only from sheetname {string} and row {int}")
//	public void the_user_clicks_login_button_after_entering_the_password_only_from_sheetname_and_row(String string, Integer int1) throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
//		login.enterLoginFormFields("login", 1);
//		login.clickloginBtn();
//	}
//	
////	//TC03 -> Missing Password on login form 
////	@When("The user clicks login button after entering the Username and leaves Password textbox empty {string} and row {int}")
////	public void the_user_clicks_login_button_after_entering_the_username_and_leaves_password_textbox_empty_and_row(String string, Integer int1) throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
////		login.enterLoginFormFields("login", 2);
////		login.clickloginBtn();
////	}
//
//


}
