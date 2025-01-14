package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import DriverManager.Driver_SetUp;
import Utilities.ExcelReader;

public class DataStructureIntroPom {

	WebDriver driver = Driver_SetUp.getDriver();
	ExcelReader excelReader = new ExcelReader();
	
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	//Web Elements in the DataStructures page 
	public By dsGetStartedBtn = By.xpath("//a[text()='Get Started' and contains(@href, 'data-structures-introduction')]");
	public By timeComplexityLink = By.xpath("//a[contains(@href, 'time-complexity')]");
	public By practiceQuestionsLink = By.xpath("//a[contains(text(),'Practice Questions')]");
	public By dsPageTitle = By.xpath("//h4[text()='Data Structures-Introduction']");//Data Structures-Introduction - title of the page 
	
	
	//Methods used on the web elements 
	public void clickGetStartedBtn() 
	{
		driver.findElement(dsGetStartedBtn).click();
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
	
	//Text for the element that is displayed
	 public String getTextForElement(By locator) {
	    	String elementText = driver.findElement(locator).getText();
	    	return elementText;
	    }
	 //get element size
	 public Integer getElementSize(By locator) {
			Integer elementCount = driver.findElements(locator).size();
			return elementCount;
		}
	 

	public String getPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	 
	 
}

