package PageObjectModel;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.Driver_SetUp;

public class IntroductionPagePom {

	public WebDriver driver = Driver_SetUp.getDriver();

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(50000)); // Timeout in second

	// Web elements of the Introduction page
	public By numpyNinja = By.cssSelector("a[href='/home']");
	public By dataStructure = By.cssSelector("a.dropdown-toggle");
	public By dsDropdown = By.cssSelector("a.dropdown-item");

	// Web Elements for each drop down items
	public By dropDownLinkedListItem = By.cssSelector("a.dropdown-item[href='/linked-list']");
	public By dropDownArrayItem = By.cssSelector("a.dropdown-item[href='/array']");
	public By dropDownStackItem = By.cssSelector("a.dropdown-item[href='/stack']");
	public By dropDownQueueItem = By.cssSelector("a.dropdown-item[href='/queue']");
	public By dropDownTreeItem = By.cssSelector("a.dropdown-item[href='/tree']");
	public By dropDownGraphItem = By.cssSelector("a.dropdown-item[href='/graph']");

	public By cardBody = By.cssSelector("div.card-body");
	public By cardTitle = By.cssSelector("h5.card-title");
	public By cardText = By.cssSelector("p.card-text");
	
	//All card title after login in 
	public By dsCardTitle = By.xpath("//h5[text()='Data Structures-Introduction']");
	public By arrayCardTitle = By.xpath("//h5[text()='Array']");
	public By linkedListCardTitle = By.xpath("//h5[text()='Linked List']");
	public By stackCardTitle = By.xpath("//h5[text()='Stack']");
	public By queueCardTitle = By.xpath("//h5[text()='Queue']");
	public By treeCardTitle = By.xpath("//h5[text()='Tree']");

//////
	public By getStartedButtonOnCard = By.cssSelector("a.btn-primary");
	public By signInLink = By.cssSelector("a[href='/login']");
	public By registerLink = By.cssSelector("a[href='/register']");

	// Get Started button of all the data structures on the Introduction page / Home
	// page
	public By dsIntroductionGetStartedBtn = By.cssSelector("a[href='data-structures-introduction']");
	public By arrayGetStartedBtn = By.cssSelector("a[href='array']");
	public By linkedListGetStartedBtn = By.cssSelector("a[href='linked-list']");
	public By stackGetStartedBtn = By.cssSelector("a[href='stack']");
	public By queueGetStartedBtn = By.cssSelector("a[href='queue']");
	public By treeGetStartedBtn = By.cssSelector("a[href='tree']");
	public By graphGetStartedBtn = By.cssSelector("a[href='graph']");

	// Authentication page on Introduction Home page before log in
	public By authenticationmsg = By.cssSelector("div.alert.alert-primary");

	// Method to click on the dropdown toggle
	public void clickDropdownToggle() {
		WebElement toggle = driver.findElement(dataStructure);
		toggle.click();
	}

	// Method to click on the 'Array' dropdown item
	public void clickDropdownItemArray() {
		driver.findElement(dropDownArrayItem).click();
		System.out.println("Dropdown selected -->" + driver.findElement(dropDownArrayItem));
		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(dropDownArrayItem)));
	}

	// Method to click on the 'Linked List' dropdown item
	public void clickDropdownItemLinkedList() {
		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(dropDownLinkedListItem)));
		wait.until(ExpectedConditions.elementToBeClickable(dropDownLinkedListItem));
		driver.findElement(dropDownLinkedListItem).click();
		System.out.println("Dropdown selected1 -->" + driver.findElement(dropDownLinkedListItem));
	}

	// Method to click on the 'Stack' drop down item
	public void clickDropdownItemStack() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownStackItem));
		driver.findElement(dropDownStackItem).click();
		System.out.println("Dropdown selected1 -->" + driver.findElement(dropDownStackItem));
	}

	// public void clickDropdownItemStack() {
	// WebElement stackItem = driver.findElement(dropDownStackItem);
//        stackItem.click();
//        System.out.println("Dropdown selected1 -->"+driver.findElement(dropDownStackItem));
//    }

	// Method to click on the 'Queue' drop down item
	public void clickDropdownItemQueue() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownQueueItem));
		driver.findElement(dropDownQueueItem).click();
		System.out.println("Dropdown selected1 -->" + driver.findElement(dropDownQueueItem));
	}

	// Method to click on the 'Tree' drop down item
	public void clickDropdownItemTree() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownTreeItem));
		driver.findElement(dropDownTreeItem).click();
		System.out.println("Dropdown selected1 -->" + driver.findElement(dropDownTreeItem));
	}

	// Method to click on the 'Graph' drop down item
	public void clickDropdownItemGraph() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownGraphItem));
		driver.findElement(dropDownGraphItem).click();
		System.out.println("Dropdown selected1 -->" + driver.findElement(dropDownGraphItem));
	}

	// get count of drop down elements
	public Integer getElementCnt(By locator) {
		Integer elementCount = driver.findElements(locator).size();
		return elementCount;
	}

	// get the text for Array Elements
	public String getTextForArrayElements(By locator, Integer posInteger) {
		String elementText = driver.findElements(locator).get(posInteger).getText();
		return elementText;
	}

	//AlertMessage on login page (Eg: Invalid Username and Password) 
	public String getTextForElement(By locator) {
		String elementText = driver.findElement(locator).getText();
		return elementText;
	}

	public Integer getElementSize(By locator) {
		Integer elementCount = driver.findElements(locator).size();
		return elementCount;
	}

	// Element Displayed
	public Boolean validateElementDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

//	public void authenticationMsgDisplay(){
//		WebElement authMessage = driver.findElement(authenticationmsg);

	// Methods to click on Get Started button for all 6 elements on the Introduction
	// or Home page
	public void clickOnDataStructuresGetStartedBtn() {
		driver.findElement(dsIntroductionGetStartedBtn).click();
		System.out.println("GetStartedButtonOfDS selected1 -->" + driver.findElement(dsIntroductionGetStartedBtn));
	}

	public void clickOnArrayGetStartedBtn() {
		driver.findElement(arrayGetStartedBtn).click();
		System.out.println("GetStartedButtonOfArray selected1 -->" + driver.findElement(arrayGetStartedBtn));
	}

	public void clickOnLinkedListGetStartedBtn() {
		driver.findElement(linkedListGetStartedBtn).click();
		System.out.println("GetStartedButtonOfLinkedList selected1 -->" + driver.findElement(linkedListGetStartedBtn));
	}

	public void clickOnStackGetStartedBtn() {
		driver.findElement(stackGetStartedBtn).click();
		System.out.println("GetStartedButtonOfStack selected1 -->" + driver.findElement(stackGetStartedBtn));
	}

	public void clickOnQueueGetStartedBtn() {
		driver.findElement(queueGetStartedBtn).click();
		System.out.println("GetStartedButtonOfQueue selected1 -->" + driver.findElement(queueGetStartedBtn));
	}

	public void clickOnTreeGetStartedBtn() {
		driver.findElement(treeGetStartedBtn).click();
		System.out.println("GetStartedButtonOfTree selected1 -->" + driver.findElement(treeGetStartedBtn));

	}

	public void clickOnGraphGetStartedBtn() {
		driver.findElement(graphGetStartedBtn).click();
		System.out.println("GetStartedButtonOfGraph selected1 -->" + driver.findElement(graphGetStartedBtn));

	}

	public void clickOnRegisterlink() {
		driver.findElement(registerLink).click();
	}

	public void clickOnSignInlink() {
		driver.findElement(signInLink).click();
	}

//	public void clickDropdownOptionByText(String optionText) {
//	    List<WebElement> dropdownOptions = dsDropdown.findElements(By.tagName("li")); // Adjust locator if needed
//	    for (WebElement option : dropdownOptions) {
//	        if (option.getText().trim().equals(optionText)) {
//	            option.click(); // Click the matching option
//	            return;
//	        }
//	    }
//	    throw new NoSuchElementException("Option '" + optionText + "' not found in the dropdown.");
//	}

	
	//get title
	public String getPageTitle() {
		String elementText = driver.getTitle();
		return elementText;
	}
//	

}
