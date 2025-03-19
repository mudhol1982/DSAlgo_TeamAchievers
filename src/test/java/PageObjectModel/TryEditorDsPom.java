package PageObjectModel;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import DriverManager.Driver_SetUp;
import Utilities.ConfigReader;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;

public class TryEditorDsPom {
	
	////////////////
	
//	private WebDriver driver; // WebDriver instance
//    private Properties prop;
//    
// //  Constructor of the Page Class
//    public TryEditorDsPom(WebDriver driver) {
//        if (driver == null) {
//            throw new IllegalArgumentException("WebDriver instance cannot be null.");
//        }
//        this.driver = driver; // Assign the passed driver to the class-level variable
//
//        // Initialize all the elements in this page class
//        this.prop = ConfigReader.initializeprop();
//    }
	
	/////////////////////

	WebDriver driver = Driver_SetUp.getDriver(); // Initialize WebDriver
	ExcelReader excelReader = new ExcelReader(); // Initialize ExcelReader utility

	// Web Elements from Text Editor
	public By tryHereButton = By.xpath("//a[@href='/tryEditor']");
	public By textAreaForCode = By.xpath("//textarea[@tabindex='0']");
	// public By textAreaForCode = By.xpath("//textarea[@tabindex='0' and
	// @spellcheck='false']");
	public By runButton = By.xpath("//button[text()='Run']");
	public By consoleOutputMsg = By.xpath("//pre[@id='output']");

	// Method to click the "Try Here" button
	public void clickTryHereBtn() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(tryHereButton)).click().perform();
		LoggerLoad.info("Clicked the Try Here button.");
	}

	// Method to enter code directly into the text area
	public void enterTryHereCode(String pCode) {
		System.out.println("driver--->"+driver);
		Actions actions=new Actions(driver);
		WebElement textArea = driver.findElement(textAreaForCode);
		System.out.println("textArea--->"+textArea);
		
		
		   // Clear the text area before entering new code (Windows specific)
	    Keys ctrlKey = Keys.CONTROL;  // Use Ctrl for Windows
	    actions.moveToElement(textArea)
	           .click()
	           .keyDown(ctrlKey)                    // Hold the CONTROL key
	           .sendKeys("a")                       // Select all text (Ctrl+A)
	           .keyUp(ctrlKey)                      // Release CONTROL
	           .sendKeys(Keys.BACK_SPACE)           // Press BACKSPACE to delete the selected text
	           .perform();  
		
		//enter new code 
		actions.moveToElement(textArea).click().sendKeys(pCode).build().perform(); 
		LoggerLoad.info("Entered code into the text area: " + pCode);
	}

	// Overloaded method to read code from Excel and enter it into the text area
	public void enterTryHereCode(String sheetName, int row)
			throws InvalidFormatException, IOException, OpenXML4JException {
		LoggerLoad.info("Reading code from Excel sheet: " + sheetName + ", Row: " + row);
		List<Map<String, String>> testData = excelReader.readFromExcel("src/test/resources/Excel/TestData.xlsx",
				sheetName);

		System.out.println("testData--->" + testData.size()+"-->"+testData);
		String pCode = "";
		if (row <= testData.size()) {
			System.out.println("Inside if loop---->");
			System.out.println("row--->" + row);
			pCode = testData.get(row).get("pCode");
			System.out.println("pCode-->" + pCode);
		} else {
			LoggerLoad.error("Specified row " + row + " is out of bounds for the Excel sheet.");
			throw new IllegalArgumentException("Row index out of bounds.");
		}
		if (pCode != null && !pCode.isEmpty()) {
			LoggerLoad.info("Fetched code from Excel: " + pCode);
			enterTryHereCode(pCode);
		} else {
			LoggerLoad.error("No code found for the specified row in the Excel sheet.");
		}
	}

	// Method to click the "Run" button
	public void clickRunButton() {
		driver.findElement(runButton).click();
		LoggerLoad.info("Clicked the Run button.");
	}

	// Method to check if an alert is present
	public boolean isAlertPresent() {
		try {
			System.out.println("Inside isAlertPresent driver--->" + driver);
			Alert alert = driver.switchTo().alert();
			String alertMessage = alert.getText();
			LoggerLoad.info("Alert message----> " + alertMessage);
			LoggerLoad.info("Alert is present.");
			alert.accept();
			if (alertMessage != null && !alertMessage.isEmpty())  {
				return true;
			}else {
				return false;
			}
		} catch (NoAlertPresentException e) {
			LoggerLoad.info("No alert is present.");
			return false;
		}
	}

	// Method to handle and log the alert message
	public boolean handleAlert() {
		//if (isAlertPresent()) {
		System.out.println("driver.switchTo().alert()--->"+driver);
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		LoggerLoad.info("Alert message: " + alertMessage);
		alert.accept();
		if (alertMessage != null && !alertMessage.isEmpty())  {
		System.out.println("Inside if --->");
		return true;
	}else {
		System.out.println("Inside else --->");
		return false;
	}
	//	} else {
	//	LoggerLoad.warn("No alert to handle.");
		// }
	}

//	// Method to check if console output is displayed
//    public boolean isConsoleOutputDisplayed() {
//    	
//    	WebElement consoleElement = driver.findElement(consoleOutputMsg);
//        String outputText = consoleElement.getText();
//        LoggerLoad.info("Console output text: " + outputText);
//        return consoleElement.isDisplayed();
//    }
//     
//    // Method to get the console output text
//    public String getOutputText() {
//        String consoleOutput = driver.findElement(consoleOutputMsg).getText();
//        LoggerLoad.info("Console output text retrieved: " + consoleOutput);
//        return consoleOutput;
//    }
    
    
    public String getOutputText() {
        try {
            // Wait for the console output element to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement consoleOutputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(consoleOutputMsg));
            
            // Retrieve the text from the element
            String consoleOutput = consoleOutputElement.getText();
            
            // Log and return the output
            LoggerLoad.info("Console output text retrieved: " + consoleOutput);
            return consoleOutput;
        } catch (Exception e) {
            LoggerLoad.error("Error retrieving console output: " + e.getMessage());
            return ""; // Return an empty string if an error occurs
        }
    }
}
