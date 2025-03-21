package StepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.RegisterPom;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_RegisterPage {
	
	 WebDriver driver;

	RegisterPom regPage = new RegisterPom();
	IntroductionPagePom ip = new IntroductionPagePom(driver);
    HomePom hp = new HomePom(driver);

	String actualErrorMsg;
	String expectedErrorMsg;
	String actualSuccessMsg;
	String expectedSuccessMsg;

	// TC01 - Empty registration form
	@Given("The user is on the new user registration page")
	public void the_user_is_on_the_new_user_registration_page() {
		regPage.openURL();
		regPage.clickGetStartedBtn();
		regPage.clickRegisterLink_getStartedPage();
	}

	@When("The user clicks Register button with all fields empty on registration form from sheetname {string} and row {int}")
	public void the_user_clicks_register_button_with_all_fields_empty(String sheetName, int rowNum)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		regPage.fillRegistrationForm(sheetName, rowNum);
		regPage.clickRegisterBtn_RegisterPage();
	}

	@Then("The error Please fill out this field. appears below Username textbox")
	public void verify_username_field_empty_error() {
		String actualMessage = regPage.switchToElementAndGetValidationMessage();
		Assert.assertEquals(actualMessage, "Please fill out this field.");
	}

	// TC02 - Empty Password field
	@When("The user clicks Register button after entering Username with other fields empty from sheetname {string} and row {int}")
	public void the_user_clicks_register_button_after_entering_username_only(String sheetName, int rowNum)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		regPage.fillRegistrationForm(sheetName, rowNum);
		regPage.clickRegisterBtn_RegisterPage();
	}

	@Then("The error message Please fill out this field. appears below Password textbox")
	public void verify_password_field_empty_error() {
		String actualMessage = regPage.switchToElementAndGetValidationMessage();
		Assert.assertEquals(actualMessage, "Please fill out this field.");
	}

	// TC03 - Password Confirmation empty
	@When("The user clicks Register button after entering Username and Password leaving Password Confirmation field empty from sheetname {string} and row {int}")
	public void the_user_clicks_register_button_after_entering_username_and_password(String sheetName, int rowNum)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		regPage.fillRegistrationForm(sheetName, rowNum);
		regPage.clickRegisterBtn_RegisterPage();
	}

	@Then("The error message Please fill out this field. appears below Password Confirmation textbox")
	public void verify_password_confirmation_field_empty_error() {
		String actualMessage = regPage.switchToElementAndGetValidationMessage();
		Assert.assertEquals(actualMessage, "Please fill out this field.");
	}

	// TC04 - Invalid Username
	@When("The user clicks Register button after entering an invalid username from sheetname {string} and row {int}")
	public void the_user_clicks_register_button_with_invalid_username(String sheetName, int rowNum)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		regPage.fillRegistrationForm(sheetName, rowNum);
		regPage.clickRegisterBtn_RegisterPage();
	}

	@Then("The user should see an error message for invalid username")
	public void verify_invalid_username_error() {
		expectedErrorMsg = "Invalid Username Entered";
		actualErrorMsg = regPage.displayPasswordMismatchError();
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}

	// TC07 - Password mismatch error
	@Then("The user should see a password mismatch warning message")
	public void verify_password_mismatch_error() {
		expectedErrorMsg = "password_mismatch:The two password fields didn’t match.";
		actualErrorMsg = regPage.displayPasswordMismatchError();
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}

	// TC08 - Successful Registration
	@When("The user registers with valid credentials from sheetname {string} and row {int}")
	public void the_user_registers_successfully(String sheetName, int rowNum)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		regPage.fillRegistrationForm(sheetName, rowNum);
		regPage.clickRegisterBtn_RegisterPage();
	}

	@Then("The user should be redirected to Home Page with success message")
	public void verify_successful_registration() {
		expectedSuccessMsg = "New Account Created. You are logged in as username";
		actualSuccessMsg = regPage.getSuccessMessage();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
	}

	// TC09 - Navigation to Login Page
	@When("The user clicks login link from Registration page")
	public void the_user_clicks_login_link() {
		regPage.clickLoginLink();
	}

	@Then("The user should be landed on login page")
	public void verify_login_page_navigation() {
		
		
		WebDriver driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleIs("Login"));
		Assert.assertEquals(ip.getPageTitle(), "Login");
		System.out.println("Actual Page Title: " + ip.getPageTitle());
		Assert.assertEquals(ip.getPageTitle(), "Login");
	}

	// TC10 - Navigation to Sign In Page
	@When("The user clicks Sign in link from Registration page")
	public void the_user_clicks_sign_in_link() {
		regPage.clickSignInLink();
	}
}
