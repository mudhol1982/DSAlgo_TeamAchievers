package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

public class Step_HomePage {
	
	public HomePom hp = new HomePom();
	public IntroductionPagePom ip = new IntroductionPagePom();
	
	@When("The user enter correct dsAlgo portal URL <URL>")
	public void the_user_enter_correct_ds_algo_portal_url_url() {
		//launch the DS Portal url<https://dsportalapp.herokuapp.com/>
	    hp.openURL();
	}

	@Then("The user should be able to land on dsAlgo portal with Get Started button")
	public void the_user_should_be_able_to_land_on_ds_algo_portal_with_get_started_button() {
	    // Assert that the page contents are correct
		 
			Assert.assertEquals(hp.getTextForElement(hp.contentHeader), "Preparing for the Interviews");
			Assert.assertEquals(hp.getTextForElement(hp.contentText), "You are at the right place");
			Assert.assertEquals(hp.getTextForElement(hp.getStartedButton), "Get Started");

	}
	
	@When("The user clicks the Get Started button")
	public void the_user_clicks_the_get_started_button() {
	    hp.ClickHomePageGetStartedButton();
	}

	@Then("The user should land in Data Structure Introduction Page with register and Sign in links")
	public void the_user_should_land_in_data_structure_introduction_page_with_register_and_sign_in_links() {
	    // On the Introduction Page - validate Register and Sign in links 
		
		
		ip.clickOnSignInlink();
		Assert.assertTrue(ip.validateElementDisplayed(ip.signInLink));
		
		ip.clickOnRegisterlink();
		Assert.assertTrue(ip.validateElementDisplayed(ip.registerLink));
		
			}

}
