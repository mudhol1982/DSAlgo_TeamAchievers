//package StepDefinitions;
//
//import static org.testng.Assert.assertFalse;
//import org.testng.Assert;
//
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;
//
//import static org.testng.Assert.assertTrue;
//
//import java.io.IOException;
//import java.time.Duration;
//
//import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import DriverManager.Driver_SetUp;
//import PageObjectModel.DataStructureIntroPom;
//import PageObjectModel.GraphPom;
//import PageObjectModel.HomePom;
//import PageObjectModel.IntroductionPagePom;
//import PageObjectModel.LoginPom;
//import PageObjectModel.RegisterPom;
//import PageObjectModel.TryEditorPage;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import Utilities.ConfigReader;
//
//public class Backgroundstep extends Driver_SetUp {
//	 public static WebDriver driver;
//	
//	public IntroductionPagePom ip = new IntroductionPagePom(driver);
//	public HomePom hp = new HomePom(driver);
//	//TryEditorPage tryEditor = new TryEditorPage();
//	
//	
//	ConfigReader configReader=new ConfigReader();
//	//loginPage lp=new loginPage(driver);
//	public LoginPom login = new LoginPom(driver);
//	public Backgroundstep() {
//		this.driver=Driver_SetUp.getDriver();
//		System.out.println("here2"+this.driver);
//
//}
////	@Given("The user is in the home page after sign-in")
////	public void the_user_is_in_the_home_page_after_sign_in() {
////		lp.getStarted();
////		lp.clkSignin();
////		lp.enterLogin(configReader.getUserName(), configReader.getPassword());
////	   }
//
//	
//	
//	@Given("the user is in the Home page after signing in")
//	public void the_user_is_in_the_home_page_after_signing_in() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
//	    // Write code here that turns the phrase above into concrete actions
//		hp.openURL();
//        hp.ClickHomePageGetStartedButton();
//        ip.clickOnSignInlink();
//        login.enterLoginFormFields("login", 6);
//	     login.clickloginBtn();
//
//	}
//	
//}
//




package StepDefinitions;

import static org.testng.Assert.assertFalse;
import org.testng.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.Driver_SetUp;
import PageObjectModel.DataStructureIntroPom;
import PageObjectModel.GraphPom;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.LoginPom;
import PageObjectModel.RegisterPom;
import PageObjectModel.TryEditorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utilities.ConfigReader;

public class Backgroundstep {

    WebDriver driver; // Declare driver as an instance variable
    IntroductionPagePom ip;
    HomePom hp;
    LoginPom login;
    ConfigReader configReader = new ConfigReader();

    // Constructor that initializes the WebDriver
    public Backgroundstep(String browser) throws Exception {
    	 Driver_SetUp.initializeBrowser(browser);

        this.driver = Driver_SetUp.getDriver(); // Ensuring driver is set up here
        ip = new IntroductionPagePom(driver);
        hp = new HomePom(browser);
        login = new LoginPom(driver);
        System.out.println("Driver Initialized: " + this.driver);
    }

    @Given("the user is in the Home page after signing in")
    public void the_user_is_in_the_home_page_after_signing_in() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
        // Navigating to the homepage after logging in
        hp.openURL();
        hp.ClickHomePageGetStartedButton();  // Clicking on 'Get Started' button on Home page
        ip.clickOnSignInlink();              // Clicking on the Sign-In link
        login.enterLoginFormFields("login", 6); // Filling login form fields
        login.clickloginBtn();                // Clicking login button to sign in
    }
}



