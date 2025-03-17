package StepDefinitions;

import static org.testng.Assert.assertFalse;
import org.testng.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.Driver_SetUp;
import PageObjectModel.DataStructureIntroPom;
import PageObjectModel.StackPom;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.LoginPom;
import PageObjectModel.RegisterPom;
import PageObjectModel.TryEditorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_StackPage {
	StackPom StackPage = new StackPom();

	
TryEditorPage tryEditor = new TryEditorPage();
public HomePom hp = new HomePom();
public LoginPom login = new LoginPom();
public IntroductionPagePom ip = new IntroductionPagePom();
public RegisterPom regPage = new RegisterPom();
public DataStructureIntroPom dsintropage = new DataStructureIntroPom();

	public WebDriver driver = Driver_SetUp.getDriver();
	
	
	@Given("the user is in the Home page after signing in for Stack")
	public void the_user_is_in_the_home_page_after_signing_in() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		hp.openURL();
        hp.ClickHomePageGetStartedButton();
        ip.clickOnSignInlink();
        login.enterLoginFormFields("login", 6);
	     login.clickloginBtn();
	     
	}
	

	@When("the user clicks the Get Started button in the Stack Panel")
	public void the_user_clicks_the_get_started_button_in_the_Stack_panel() throws InterruptedException {
	    
		StackPage.getStartedStack();
	   
	}

	@Then("the user must be redirected to the Stack data structure page")
	public void the_user_must_be_redirected_to_the_Stack_data_structure_page() {

		Assert.assertEquals(ip.getPageTitle(), "Stack");
	    
	}
}
