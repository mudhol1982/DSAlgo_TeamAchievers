package PageObjectModel;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverManager.Driver_SetUp;
import Utilities.ConfigReader;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;

public class LinkedListPom {
	
	private WebDriver driver; // WebDriver instance
    private Properties prop;
    
 //  Constructor of the Page Class
    public LinkedListPom(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance cannot be null.");
        }
        this.driver = driver; // Assign the passed driver to the class-level variable

        // Initialize all the elements in this page class
        this.prop = ConfigReader.initializeprop();

       
    }
	
	
	//WebDriver driver = Driver_SetUp.getDriver();
	ExcelReader excelReader = new ExcelReader();
	
	//Web Elements in the DataStructures page 
	//public By lsGetStartedBtn = By.xpath("//a[text()='Get Started' and contains(@href, 'linked-list')]");
	public By lsGetStartedBtn = By.cssSelector("a[href='linked-list']");
	public By lsIntroductionLink = By.xpath("//a[@href='introduction']");
	//public By lsIntroductionLink = By.xpath("//a[text()='Introduction']");
	public By lsCreatingLinkedLIst = By.xpath("//a[@href='creating-linked-list']");
	public By lsTypesOfLinkedList = By.xpath("//a[@href='types-of-linked-list']");
	public By lsImplementLinkedListInPython = By.xpath("//a[@href='implement-linked-list-in-python']");
	public By lsTraversal = By.xpath("//a[@href='traversal']");
	public By lsInsertion = By.xpath("//a[@href='insertion-in-linked-list']");
	public By lsDeletion = By.xpath("//a[@href='deletion-in-linked-list']");

			
	// Methods used on the web elements
	public void clicklsGetStartedBtn() {
		driver.findElement(lsGetStartedBtn).click();
		//System.out.println("Inside clicklsGetStartedBtn--->  +" + driver.getTitle());
		LoggerLoad.info("Clicking the Linked List Get Started link");
		
	}

	public void clicklsIntroductionLink() {
		driver.findElement(lsIntroductionLink).click();
		LoggerLoad.info("Clicking the LinkedList-Introduction page link");
	}

	 public void clicklsCreatingLinkedLIstLink() {
	    	driver.findElement(lsCreatingLinkedLIst).click();
	    	LoggerLoad.info("Clicking the LinkedList-Creating Linked LIst page link");
			
		}
	 
	 public void clicklsTypesOfLinkedListLink() {
	    	driver.findElement(lsTypesOfLinkedList).click();
	    	LoggerLoad.info("Clicking the LinkedList-Types Of Linked List page link");
			
		}
	 
	 public void clicklsImplementLinkedListInPythonLink() {
		 driver.findElement(lsImplementLinkedListInPython).click();
	    	LoggerLoad.info("Clicking the LinkedList-Implement Linked List in Python page link");
	 }
	 
	 public void clicklsTraversalLink() {
		 driver.findElement(lsTraversal).click();
	    	LoggerLoad.info("Clicking the LinkedList-Traversal page link");
	 }
	 
	 public void clicklsInsertionLink() {
		 driver.findElement(lsInsertion).click();
	    	LoggerLoad.info("Clicking the LinkedList-Insertion page link");
	 }
	 
	 public void clicklsDeletionLink() {
		 driver.findElement(lsDeletion).click();
	    	LoggerLoad.info("Clicking the LinkedList-Deletion page link");
	 }
}
