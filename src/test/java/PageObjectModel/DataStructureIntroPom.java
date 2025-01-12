package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import DriverManager.Driver_SetUp;
import Utilities.ExcelReader;

public class DataStructureIntroPom {

	WebDriver driver = Driver_SetUp.getDriver();
	ExcelReader excelReader = new ExcelReader();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	//x paths for web elements under Data Structures 
	//public By dsGetStartedBtn = By.xpath("a[href='data-structures-introduction']");


	//public By timeComplexityLink = By.xpath("a[href='time-complexity']");
	public By timeComplexityLink = By.xpath("//a[contains(@href, 'time-complexity')]");
	public By timeComplexityTopicLink = By.xpath("//a[text()='Time Complexity']"); // on clicking Time Complexity - this comes as first topic
	
	public By practiceQuestionsLink = By.xpath("//a[contains(text(),'Practice Questions')]");
	//public By tryHereLink = By.xpath("//a[text()='Try here>>>']");
	public By tryHereBtn = By.xpath("//a[@href='/tryEditor']");
	public By runButton = By.xpath("//button[contains(text(),'Run')]");
	//public By runButton = By.xpath("//button[text()='Run']");
	public By textAreaForCode = By.xpath("//div[@class='CodeMirror-lines']");
	public By errorAlertPop = By.xpath("//div[@class='error-message']");

	// Locator for Data Structures Introduction page title
	//public By dsIntroductionPageTitle = By.xpath("//h4[contains(@class, 'bg-secondary')]");
	//public By dsIntroductionPageHeader = By.xpath("h4.bg-secondary");
	
	public By dsIntroductionPageHeader = By.xpath("//h4[contains(@class, 'bg-secondary')]");
	
    //public By consoleOutput = By.cssSelector("'#output'");
    public By consoleOutput = By.xpath("//pre[@id='output']");
	


	public Boolean validateElementDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	//Get Text for the Element on DS Intro page 
	public String getTextForElement(By locator) {
		String elementText = driver.findElement(locator).getText();
		return elementText;
	}
	// Locator for the element you're trying to interact with
	//public By dsGetStartedBtn = By.xpath("a[href='data-structures-introduction']");
	
	public By dsGetStartedBtn = By.xpath("//a[text()='Get Started' and contains(@href, 'data-structures-introduction')]");
	// Method to wait for the element to be visible before click it
	//public void waitForAndClickdsGetStartedBtn(WebDriver driver) {

	//	    public void clickDSIntroGetStartedBtn() {
	//	    	
	//	   
	//	        // Wait for the element to be visible
	//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait time is 10 seconds
	//	        WebElement dsGetStartedBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(dsGetStartedBtnLocator));
	//	        
	//	        // Once the element is visible, click on it
	//	        dsGetStartedBtn.click();
	//	    	System.out.println("Inside clickDSIntroGetStartedBtn");
	//	    }

	public void clickDSIntroGetStartedBtn(){

		System.out.println("Inside clickDSIntroGetStartedBtn");
		driver.findElement(dsGetStartedBtn).click();
	}

	//	    // Sample Test Method
	//	    public void validateDataStructuresIntroLink(WebDriver driver) {
	//	        try {
	//	            waitForAndClickElement(driver);  // Try to locate and click the element
	//	        } catch (org.openqa.selenium.NoSuchElementException e) {
	//	            System.out.println("Element not found: " + dsIntroductionLink);
	//	        }
	//	    }
	//	}

	public void clickTimeComplexityLink() {
		driver.findElement(timeComplexityLink).click();

	}
	
	public void clicktimeComplexityTopicLink() {
		driver.findElement(timeComplexityTopicLink).click();
		
	}

	public void clickPracticeQuestionsLink() {
		driver.findElement(practiceQuestionsLink).click();
	}

	public void clickTryHereBtn() {
		driver.findElement(tryHereBtn).click();
	}

	public void clickRunBtn() {
		driver.findElement(runButton).click();
	}

	public void enterCodeInTextArea(String testCode) {
		driver.findElement(textAreaForCode).sendKeys(testCode);
	}
	
	//check with empty code 
	public void validateWithEmptyCode() {
		Assert.assertFalse(driver.findElement(consoleOutput).isDisplayed());
	}
	
	//check with valid code 
	public void validateWithValidCode(String expectedOutputMsg) {
		Assert.assertEquals(driver.findElement(consoleOutput).getText(), expectedOutputMsg);
	}

	//check with invalid code in text editor 
	public void validateWithInvalidCode(String expectedOutputMsg, String expectedErrorMessage) {
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertEquals(alertText, expectedErrorMessage);
	}
	
	public String getCurrentUrl() {
		String elementText = driver.getCurrentUrl();
		return elementText;
	}


	}
