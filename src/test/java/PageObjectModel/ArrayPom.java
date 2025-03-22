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
import Utilities.ExcelReader;
import Utilities.LoggerLoad;

public class ArrayPom {

	WebDriver driver = Driver_SetUp.getDriver();

//	////////////////////////////
//	private WebDriver driver; // WebDriver instance
//    private Properties prop;
//    
// //  Constructor of the Page Class
//    public ArrayPom(WebDriver driver) {
//        if (driver == null) {
//            throw new IllegalArgumentException("WebDriver instance cannot be null.");
//        }
//        this.driver = driver; // Assign the passed driver to the class-level variable
//
//        // Initialize all the elements in this page class
//        this.prop = ConfigReader.initializeprop();
//
//        }
    
	ExcelReader excelReader = new ExcelReader();
	
	//Web Elements in the DataStructures page 
	public By arrayGetStartedButton = By.xpath("//div[h5[text()='Array']]//a[text()='Get Started']");
	public By arraysInPythonLink = By.xpath("//a[@href='arrays-in-python']");
	public By arraysUsingListLink = By.xpath("//a[@href='arrays-using-list']");
	public By basicOperationsInListsLink = By.xpath("//a[@href='basic-operations-in-lists']");
	public By applicationsOfArrayLink = By.xpath("//a[@href='applications-of-array']");
	
	//Web elements of Array page -> practice Questions page links 
	//public By searchTheArrayLink = By.xpath("//a[text()='Search the array']");
	//public By maxConsecutiveOnes = By.xpath("//a[text()='Max Consecutive Ones']");
	//public By findNumWithEvenNumOfDigits = By.xpath("//a[text()='Find Numbers with Even Number of Digits']");
	
	//Arrays in Python => Practice Question page web elements (four questions)
	public By searchTheArrayLink = By.xpath("//a[@href='/question/1']");
	public By maxConsecutiveOnes = By.xpath("//a[@href='/question/2']");
	public By findNumWithEvenNumOfDigits = By.xpath("//a[@href='/question/3']");
	public By squaresOfAsortedArray = By.xpath("//a[@href='/question/4']");
	
	
	
	// Methods used on the web elements
		public void clickarrayGetStartedBtn() {
			driver.findElement(arrayGetStartedButton).click();
			//System.out.println("Inside clicklsGetStartedBtn--->  +" + driver.getTitle());
			LoggerLoad.info("Clicking the Array Get Started link");
			
		}
		
		public void clickarraysInPythonLink() {
			driver.findElement(arraysInPythonLink).click();
			//System.out.println("Inside clicklsGetStartedBtn--->  +" + driver.getTitle());
			LoggerLoad.info("Clicking Arrays in Python link");
			
		}
		
		public void clickarraysUsingListLink() {
			driver.findElement(arraysUsingListLink).click();
			//System.out.println("Inside clicklsGetStartedBtn--->  +" + driver.getTitle());
			LoggerLoad.info("Clicking Arrays Using List link");
			
		}
		
		public void clickbasicOperationsInListsLink() {
			driver.findElement(basicOperationsInListsLink).click();
			//System.out.println("Inside clicklsGetStartedBtn--->  +" + driver.getTitle());
			LoggerLoad.info("Clicking Basic Operations In Lists link");
		}
			public void clickapplicationsOfArrayLink() {
				driver.findElement(applicationsOfArrayLink).click();
				//System.out.println("Inside clicklsGetStartedBtn--->  +" + driver.getTitle());
				LoggerLoad.info("Clicking Aplications Of Array link");
			
		}
			
		// Methods for Practice Question Links
		    public void clickSearchTheArrayLink() {
		        driver.findElement(searchTheArrayLink).click();
		        LoggerLoad.info("Clicking Search the Array link");
		    }
		    
		    public void clickMaxConsecutiveOnes() {
		        driver.findElement(maxConsecutiveOnes).click();
		        LoggerLoad.info("Clicking Max Consecutive Ones link");
		    }
		    
		    public void clickFindNumWithEvenNumOfDigits() {
		        driver.findElement(findNumWithEvenNumOfDigits).click();
		        LoggerLoad.info("Clicking Find Numbers with Even Number of Digits link");
		    }
		    
		    public void clickSquaresOfASortedArray() {
		        driver.findElement(squaresOfAsortedArray).click();
		        LoggerLoad.info("Clicking Squares of a Sorted Array link");
		    }
		    
			public String getTextForElement(By locator) {
				String elementText = driver.findElement(locator).getText();
				return elementText;
			}
			

}
