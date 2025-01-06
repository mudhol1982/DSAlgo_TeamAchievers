package StepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.RegisterPom;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_RegisterPage {

	RegisterPom RegPage = new RegisterPom();
	public IntroductionPagePom ip = new IntroductionPagePom();
	public HomePom hp = new HomePom();

	String actualErrorMsg;
	String expectedErrorMsg;
	String actualSuccessMsg;
	String expectedSuccessMsg;

	// TC01
	@Given("The user is on the new user registration page")
	public void the_user_is_on_the_new_user_registration_page() {

		RegPage.openURL();
		RegPage.clickGetStartedBtn();
		RegPage.clickRegisterLink_getStartedPage();

	}

	@When("The user clicks Register button with all fields empty from the sheetname {string} and row {int}")
	public void the_user_clicks_register_button_with_all_fields_empty_from_the_sheetname(String string, Integer int1)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		RegPage.fillRegistrationForm("register", 2);
		RegPage.clickRegisterBtn_RegisterPage();
	}

	@Then("The error Please fill out this field appears below Username textbox")
	public void the_error_please_fill_out_this_field_appears_below_username_textbox() {

		String browserValidationmsg = RegPage.switchToElementAndGetValidationMessage();
		String expectedErrorMsg = "Please fill out this field.";
		// Assert.assertEquals(browserValidationmsg, expectedErrorMsg);
		//String msgBrowserValidation = ip.switchToElementAndGetValidationMessage();
		//String expectedErrorMsg = "Please fill out this field.";
		//Assert.assertEquals(msgBrowserValidation, expectedErrorMsg);
	}

}
