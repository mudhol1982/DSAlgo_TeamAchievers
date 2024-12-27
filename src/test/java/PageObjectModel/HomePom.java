package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import DriverManager.Driver_SetUp;
import Utilities.ConfigReader;


public class HomePom {
	
	public WebDriver driver = Driver_SetUp.getDriver();
	
	public By getStartedButton = By.cssSelector("button.btn");
	public By contentHeader = By.cssSelector(".content h1");
	public By contentText = By.cssSelector("div.content p");
	
    public void openURL() {
    	
    	driver.get(ConfigReader.getUrl());
    	   	
    }
    
    public void ClickHomePageGetStartedButton() {
    	
    	driver.findElement(getStartedButton).click();
    }
    
	public String getTextForElement(By locator) {
		String elementText = driver.findElement(locator).getText();
		return elementText;
	}

	
}
	
	
	


