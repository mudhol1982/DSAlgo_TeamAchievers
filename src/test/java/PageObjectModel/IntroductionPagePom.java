package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import DriverManager.Driver_SetUp;

public class IntroductionPagePom {
	
	public WebDriver driver = Driver_SetUp.getDriver();
	
	//Web elements of the Introduction page 	
	public By numpyNinja = By.cssSelector("a[href='/home']");
	public By dataStructure = By.cssSelector("a.dropdown-toggle");
	public By dsDropdown = By.cssSelector("a.dropdown-item");
	
	//Drop Down values of Data Structures Web Element 
	public By dsDropdownItem1 = By.cssSelector("a.dropdown-item[href='/array']");
	public By dsDropdownItem2 = By.cssSelector("a.dropdown-item[href='/linked-list']");
	public By dsDropdownItem3 = By.cssSelector("a.dropdown-item[href='/stack']");
	public By dsDropdownItem4 = By.cssSelector("a.dropdown-item[href='/queue']");
	public By dsDropdownItem5 = By.cssSelector("a.dropdown-item[href='/tree']");
	public By dsDropdownItem6 = By.cssSelector("a.dropdown-item[href='/graph']");
	
	//Other Web Elements of the Introduction Page  (how to use this in method?)
	
	//public By arrayCard = By.cssSelector("div.card-body:has(h5.card-title:contains('Array'))");
	public By cardBody = By.cssSelector("div.card-body");
	public By cardTitle = By.cssSelector("h5.card-title");
	public By cardText = By.cssSelector("p.card-text");
	
	//we can have specific get started buttons for each -> purpose of having this >? 
	public By getStartedButtonOnCard = By.cssSelector("a.btn-primary");
	public By signInLink = By.cssSelector("a[href='/login']");
	public By registerLink = By.cssSelector("a[href='/register']");
	
	//Get Started button of all the data structures on the Introduction page 
    public By dsIntroductionGetStartedBtn = By.cssSelector("a[href='data-structures-introduction']");
	public By arrayGetStartedBtn = By.cssSelector("a[href='array']");
	public By linkedListGetStartedBtn = By.cssSelector("a[href='linked-list']");
	public By stackGetStartedBtn = By.cssSelector("a[href='stack']");
	public By queueGetStartedBtn = By.cssSelector("a[href='queue']");
	public By treeGetStartedBtn = By.cssSelector("a[href='tree']");
	public By graphGetStartedBtn = By.cssSelector("a[href='graph']");
	
	//Authentication page on Introduction Home page before log in 
	public By authenticationmsg  =  By.cssSelector("div.alert.alert-primary");
	
	//Different Methods for the Actions performed on the Introduction Home Page
	public void clickDataStructuredropdown() {
	driver.findElement(dataStructure).click();
		
			}
	public void clickDataStructureItem1dropdown() {
	driver.findElement(dsDropdownItem1).click();
	}
	
	public void clickDataStructureItem2dropdown() {
	driver.findElement(dsDropdownItem2).click();
	}
	
	public void clickDataStructureItem3dropdown() {
		driver.findElement(dsDropdownItem3).click();
	}
	
	public void clickDataStructureItem4dropdown() {
		driver.findElement(dsDropdownItem4).click();
	}
	
	public void clickDataStructureItem5dropdown() {
		driver.findElement(dsDropdownItem5).click();
	}
	
	public void clickDataStructureItem6dropdown() {
		driver.findElement(dsDropdownItem6).click();
	}
	
	public void authenticationMsgDisplay(){
		System.out.println("authenticationmsg");
	}
	
	public void clickOnDataStructuresGetStartedBtn() {
		driver.findElement(dsIntroductionGetStartedBtn).click();
	}
	
	public void clickOnArrayGetStartedBtn() {
		driver.findElement(arrayGetStartedBtn).click();
	}
	
	public void clickOnLinkedListGetStartedBtn() {
		driver.findElement(linkedListGetStartedBtn).click();
	}

	public void clickOnStackGetStartedBtn() {
		driver.findElement(stackGetStartedBtn).click();
	}

	public void clickOnQueueGetStartedBtn() {
		driver.findElement(queueGetStartedBtn).click();
	}
	public void clickOnTreeGetStartedBtn() {
		driver.findElement(treeGetStartedBtn).click();
	}
	
	public void clickOnGraphGetStartedBtn() {
		driver.findElement(graphGetStartedBtn).click();
	}
	
	public void clickOnRegisterlink() {
		driver.findElement(registerLink).click();
	}
	
	public void clickOnSignInlink() {
		driver.findElement(signInLink).click();
	}
	
	public Boolean validateElementDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
		
}
	
	
	


