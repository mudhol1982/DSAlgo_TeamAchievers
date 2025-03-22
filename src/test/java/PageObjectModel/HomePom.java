package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.Driver_SetUp;
import Utilities.ConfigReader;

public class HomePom extends Driver_SetUp{
	

	public static WebDriver driver = Driver_SetUp.getDriver();
	// Create a WebDriverWait instance with Duration

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Timeout in second

	public By getStartedButton = By.cssSelector("button.btn");
	public By contentHeader = By.cssSelector(".content h1");
	
	public By contentText = By.cssSelector("div.content p");
	public By signOutLink = By.xpath("//a[@href='/logout']");

	
//	public HomePom(WebDriver driver)
//	{
//		//this.driver = Driver_SetUp.initializeBrowser(null);
//		
//		this.driver = Driver_SetUp.getDriver();
//		//this.driver = Driver_SetUp.initializeBrowser(browser);
//		System.out.println("here"+driver);
	
		
		 public HomePom(String browser) throws Exception {
		        // Initialize WebDriver based on the passed browser name
		        this.driver = Driver_SetUp.initializeBrowser(browser); // This will call initializeBrowser() method

		        System.out.println("HomePom initialized with driver: " + this.driver);
		    }
	
	
//	if (driver == null) {
//        this.driver = Driver_SetUp.getDriver(); // Initialize driver if not passed
//    } else {
//        this.driver = driver; // Use the passed WebDriver if provided
//    }
//    System.out.println("HomePom driver initialized: " + this.driver);

	
	
	public void openURL() {
		System.out.println("Inside openURL-->" + driver);
		driver.get(ConfigReader.getUrl());
		System.out.println(driver);
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
		System.out.println(driver);
		driver.findElement(getStartedButton).click();
	}

	public WebElement linkClickable(By locator) {
    	return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}


	/*
	 * public void openURL() { System.out.println("Inside openURL");
	 * driver.get(ConfigReader.getUrl());
	 * 
	 * }
	 */
    

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
    

    public void openUrlQueue() {
		// TODO Auto-generated method stub
    	driver.get(ConfigReader.getUrlQueue());
		
	}
    
  
	/*
	 * public void ClickHomePageGetStartedButton() {
	 * 
	 * System.out.println("Inside ClickHomePageGetStartedButton");
	 * driver.findElement(getStartedButton).click(); }
	 */
    
 	public String getTextForElement(By locator) {
		String elementText = driver.findElement(locator).getText();
		return elementText;
	}

    public void openLinkedList() {
    	driver.get(ConfigReader.getUrlLinkedList());
    }
    
    public void openArray() {
    	
    	driver.get(ConfigReader.getUrlArray());
    }


	
	public void clickSignOutLink() {
		driver.findElement(signOutLink).click();
	}


	public void openUrlStack() {
		// TODO Auto-generated method stub
    	driver.get(ConfigReader.getUrlStack());
		
	}
	

}

	



