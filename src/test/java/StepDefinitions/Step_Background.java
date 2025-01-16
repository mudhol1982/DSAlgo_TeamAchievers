package StepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import DriverManager.Driver_SetUp;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.LoginPom;
import io.cucumber.java.en.Given;

public class Step_Background {
	
	WebDriver driver = Driver_SetUp.getDriver();
	HomePom hp = new HomePom();	
	LoginPom login = new LoginPom();
	IntroductionPagePom ip = new IntroductionPagePom();
	
	@Given("The user is landed on the home page after sign-in")
	public void the_user_is_landed_on_the_home_page_after_sign_in() 
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		hp.openURL();
		hp.ClickHomePageGetStartedButton();
		ip.clickOnSignInlink();
		login.enterLoginFormFields("login", 6);
		login.clickloginBtn();
	}


}
