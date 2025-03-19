package PageObjectModel;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.Driver_SetUp;
import Utilities.ConfigReader;

public class HomePom {
	

	//private WebDriver driver; // WebDriver instance
//
//  // Constructor or method where WebDriver is initialized
//    public HomePom(WebDriver driver) {
//        this.driver = driver;
//    }

	public WebDriver driver = Driver_SetUp.getDriver();
    
	// Create a WebDriverWait instance with Duration

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Timeout in second

	public By getStartedButton = By.cssSelector("button.btn");
	public By contentHeader = By.cssSelector(".content h1");
	public By contentText = By.cssSelector("div.content p");
	public By signOutLink = By.xpath("//a[@href='/logout']");

	public void openURL() {
		System.out.println("Inside openURL-->" + driver);
		driver.get(ConfigReader.getUrl());

	}

	// Open Time Complexity url

	public void openDsTimeComplexityUrl() {
		driver.get(ConfigReader.geturlTimeComplexity());
	}

	// Open Data Structure Introduction Page url
	public void openDSIntroductionUrl() {
		driver.get(ConfigReader.geturlDataStructuresIntroduction());
	}
	//Open Practice Questions page 
		public void openPracticeQnsPageUrl() {
			driver.get(ConfigReader.geturlPracticeQnsDSIntroPage());
		}

	public void ClickHomePageGetStartedButton() {
		System.out.println("Before ClickHomePageGetStartedButton");
		driver.findElement(getStartedButton).click();
	}

	public WebElement linkClickable(By locator) {
    	return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

  
    public void openHomeURL() {
    	System.out.println("Inside openURL");
    	driver.get(ConfigReader.getUrlHome());
    		
    }
    public void openUrlTree() {
    	
    	driver.get(ConfigReader.getUrlTree());
    		
    }
    public void openUrlGraph(){
    	
    	driver.get(ConfigReader.getUrlGraph());
    	
    }
    
    public void openLinkedList() {
    	driver.get(ConfigReader.getUrlLinkedList());
    }
    
    public void openArray() {
    	
    	driver.get(ConfigReader.getUrlArray());
    }

	    
 	public String getTextForElement(By locator) {
		String elementText = driver.findElement(locator).getText();
		return elementText;
	}
	
	public void clickSignOutLink() {
		driver.findElement(signOutLink).click();
	}
	

}
