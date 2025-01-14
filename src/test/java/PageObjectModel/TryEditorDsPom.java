package PageObjectModel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import DriverManager.Driver_SetUp;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;

public class TryEditorDsPom {

	WebDriver driver = Driver_SetUp.getDriver(); // Initialize WebDriver
	ExcelReader excelReader = new ExcelReader(); // Initialize ExcelReader utility

	// Web Elements from Text Editor
	public By tryHereButton = By.xpath("//a[@href='/tryEditor']");
	public By textAreaForCode = By.xpath("//textarea[@tabindex='0']");
	public By runButton = By.xpath("//button[text()='Run']");
	public By consoleOutputMsg = By.xpath("//pre[@id='output']");

	// Method to click the "Try Here" button

	public void clickTryHereBtn() {
		// No need to redeclare tryHereButton; we already have it as a class member
		Actions act = new Actions(driver);

		// Move to the Try Here button and click it
		act.moveToElement(driver.findElement(tryHereButton)).click().perform();

		// Log the action
		LoggerLoad.info("Clicking the try here link of DS Introduction page");
	}
	
	// Method to enter code into the text editor
	public void enterCode(String code) {
		Actions actions = new Actions(driver);
		WebElement textEditor = driver.findElement(textAreaForCode);

		// Click and clear the text area (optional), then send the new code
		textEditor.clear(); // Ensure text area is cleared before entering new code
		actions.moveToElement(textEditor).click().sendKeys(code).build().perform();
	}

	// Method to click the "Run" button
	public void clickRunButton() {
		driver.findElement(runButton).click(); // Click the Run button
	}

	// Method to check if an alert is present
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert(); // Switch to the alert
			return true; // Alert is present
		} catch (NoAlertPresentException e) {
			return false; // No alert found
		}
	}

	// Method to display the alert message
	public void displayAlert() {
		// Switch to alert and capture the message
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();

		// Print the alert message to the console
		System.out.println(alertMsg);
	}

	// Method to get the console output text
	public String get_outputText() {
		String consoleOutput = driver.findElement(consoleOutputMsg).getText();
		return consoleOutput; // Return the console output text
	}
}
