package PageObjectModel;

import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import DriverManager.Driver_SetUp;
import Utilities.ConfigReader;
import Utilities.ExcelReader;

public class DataStructureIntroPom {
	
//    private WebDriver driver; // WebDriver instance
//  // Constructor or method where WebDriver is initialized
//    public DataStructureIntroPom(WebDriver driver) {
//        this.driver = driver;
//    }

	WebDriver driver = Driver_SetUp.getDriver();
	ExcelReader excelReader = new ExcelReader();
	
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	//Web Elements in the DataStructures page 
	public By dsGetStartedBtn = By.xpath("//a[text()='Get Started' and contains(@href, 'data-structures-introduction')]");
	public By timeComplexityLink = By.xpath("//a[contains(@href, 'time-complexity')]");
	public By practiceQuestionsLink = By.xpath("//a[contains(text(),'Practice Questions')]");
	public By dsPageTitle = By.xpath("//h4[text()='Data Structures-Introduction']");//Data Structures-Introduction - title of the page
	
	String actualAlertText;
	String expectedAlertText;
	String actualSuccessMsg;
	String expectedSuccessMsg;
	String expectedTitle;
	String actualTitle;
	
	
	//Methods used on the web elements 
	public void clickGetStartedBtn() 
	{
		driver.findElement(dsGetStartedBtn).click();
//		System.out.println("Inside clickGetStartedBtn--->  +": "dsGetStartedBtn");
		System.out.println("Inside clickGetStartedBtn--->  +"  + driver.getTitle());
	}
	
	public void clickTimeComplexityLink()
	{
		driver.findElement(timeComplexityLink).click();
		
	}
	
	public void clickPracticeQuestionsLink()
	{
		driver.findElement(practiceQuestionsLink).click();
	}
		
	//validate element displayed 
	
	public Boolean validateElementDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	//getpage title 
//	public String getPageTitle() {
//		return driver.getTitle();
//	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	//	public boolean validateElementDisplayed(WebElement element) {
//	    try {
//	        // Check if the element is displayed
//	        return element.isDisplayed();
//	    } catch (NoSuchElementException e) {
//	        // If the element is not found, return false
//	        return false;
//	    }
//	}
	
	//Text for the element that is displayed
//	 public String getTextForElement(By locator) {
//	    	String elementText = driver.findElement(locator).getText();
//	    	return elementText;
//	    }
	
		public String getTextForElement(By locator) {
		String elementText = driver.findElement(locator).getText();
		return elementText;
	}
	 //get element size
	 public Integer getElementSize(By locator) {
			Integer elementCount = driver.findElements(locator).size();
			return elementCount;
		}
	 


}

