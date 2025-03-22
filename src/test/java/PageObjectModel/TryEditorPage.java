package PageObjectModel;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;



import java.io.IOException;

import org.openqa.selenium.Alert;

import DriverManager.Driver_SetUp;
import Utilities.ExcelReader;

public class TryEditorPage {

    // Initialize WebDriver at the field level
    public WebDriver driver = Driver_SetUp.getDriver();

    // Locators for elements on the Try Editor page
    private By codeEditorPage= By.xpath("//*[@id=\"answer_form\"]/div/div/div[6]/div[1]/div/div/div/div[5]/div/pre");

    
    
  //div[@class='input']/div[1]/div[6]/div[1]/div/div/div/div[2]
    public By runButton = By.xpath("//button[text()='Run']");
    private By consoleOutput = By.xpath("//pre[@id='output']");

    // Constructor: You can still accept driver as a parameter, but it's optional
    public TryEditorPage() {
        // No need to reinitialize the driver here as it's already initialized above
    }

    // Method to enter code into the editor
    public void enterCode(String code) throws InterruptedException {
    	// Wait for the code editor element to be visible and clickable
    	Actions action = new Actions(driver);
    	System.out.println("hii");

    	WebElement codeEditor = driver.findElement(codeEditorPage);
    	


        codeEditor.click();
        System.out.println("code editor clicked");
//        codeEditor.clear();

        // Enter the new code into the editor
        System.out.println("code is +"+code);
        action.sendKeys(code).perform();
        System.out.println("performed");


        System.out.println("code is "+code);
    }
    
    // Method to click the Run button
    public void clickRunButton() {
    	TryEditorPage tep = new TryEditorPage();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        
        // Wait until the "Run" button is clickable
       WebElement button = wait.until(ExpectedConditions.elementToBeClickable(runButton));
        
        // Click the "Run" button
       button.click();
    	
       
        tep.isAlertPresent();
    }
    
    public String isAlertPresent() {
    	
        try {
    	
        Alert alert = driver.switchTo().alert();
            
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            alert.accept();  
            return alertText;
             } 
        catch (NoAlertPresentException e) {
            // Handle case where no alert is present
            System.out.println("No alert present.");
          return null;
        }
       
    }

    
    // Method to check if console output is displayed
    public boolean isConsoleOutputDisplayed() {
    	//System.out.println(consoleOutput);
    	
    	WebElement consoleElement = driver.findElement(consoleOutput);
        String outputText = consoleElement.getText();

        // Print the actual text content inside the console output element
        System.out.println(outputText);

        return driver.findElement(consoleOutput).isDisplayed();
    }

    // Method to get the text from the console output
    public String getConsoleOutputText() {
        return driver.findElement(consoleOutput).getText();
    }
    
 // Test method for valid Python code execution
    @Test
	public void testValidCodeExecution() throws IOException, InterruptedException {
        // Read valid Python code from Excel
        String validCode = ExcelReader.getCodeFromExcel("src/test/resources/TestData.xlsx", "Sheet1", 1, 0);
        
        Actions action = new Actions(driver);

     // Find the code editor element
     WebElement element2 = driver.findElement(codeEditorPage);

     // Perform actions to clear the code editor
     System.out.println("in the method valid code");
   


     
     Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;
     new Actions(driver)
     .sendKeys(element2, "Selenium!")    // Send some text
     .sendKeys(Keys.ARROW_LEFT)           // Move the cursor to the end of the text
     .keyDown(Keys.SHIFT)                 // Press SHIFT key to select text
     .sendKeys(Keys.ARROW_UP)             // Select text from bottom (assuming multi-line text field)
     .keyUp(Keys.SHIFT)                   // Release SHIFT
     .keyDown(cmdCtrl)                    // Hold the CONTROL (or COMMAND on Mac) key
     .sendKeys("a")                       // Select all text (Ctrl+A or Cmd+A)
     .keyUp(cmdCtrl)                      // Release CONTROL (or COMMAND on Mac)
     .sendKeys(Keys.BACK_SPACE)           // Press BACKSPACE to delete the selected text
     .perform();                          // Execute the actions  Selenium clear — https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/

      
        enterCode(validCode);
        clickRunButton();
        
    }

    // Test method for invalid Python code execution
    @Test
	public void testInvalidCodeExecution() throws IOException, InterruptedException {
        // Read invalid Python code from Excel
        String invalidCode = ExcelReader.getCodeFromExcel("src/test/resources/TestData.xlsx", "Sheet1", 2, 0);
        System.out.println("inalidcode"+invalidCode);
        
        
        // Enter the invalid code into the editor and click Run
        enterCode(invalidCode);
        clickRunButton();
       
    }

    // Main method to run the tests directly inside TryEditorPage
    public static void main(String[] args) throws InterruptedException {
        // Create an instance of the TryEditorPage
    	
    	TryEditorPage tep = new TryEditorPage();
       
    }
}

