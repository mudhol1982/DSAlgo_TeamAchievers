package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.Driver_SetUp;
import Utilities.ConfigReader;


public class HomePom {
	
	public WebDriver driver = Driver_SetUp.getDriver();
	// Create a WebDriverWait instance with Duration

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Timeout in second
	
	public By getStartedButton = By.cssSelector("button.btn");
	public By contentHeader = By.cssSelector(".content h1");
	public By contentText = By.cssSelector("div.content p");
	
	
    public void openURL() {
    	System.out.println("Inside openURL");
    	driver.get(ConfigReader.getUrl());
    	   	
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
    public void ClickHomePageGetStartedButton() {
    	
    	System.out.println("Inside ClickHomePageGetStartedButton");
    	driver.findElement(getStartedButton).click();
    }
    
    public WebElement linkClickable(By locator) {

		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}
    
    public String getTextForElement(By locator) {
    	String elementText = driver.findElement(locator).getText();
    	return elementText;
    }
	
}
	
	
	


