package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import DriverManager.Driver_SetUp;

public class IntroductionPagePom {
	
	public WebDriver driver = Driver_SetUp.getDriver();
	
	//Web elements of the Introduction page 	
	public By numpyNinja = By.cssSelector("a[href='/home']");
	public By dataStructure = By.cssSelector("a.dropdown-toggle");
	public By dsDropdown = By.cssSelector("a.dropdown-item");
	
	public By dropDownArrayItem = By.cssSelector("a.dropdown-item[href='/array']");
	public By dropDownLinkedListItem = By.cssSelector("a.dropdown-item[href='/linked-list']");
	public By dropDownStackItem = By.cssSelector("a.dropdown-item[href='/stack']");
	public By dropDownQueueItem = By.cssSelector("a.dropdown-item[href='/queue']");
	public By dropDownTreeItem = By.cssSelector("a.dropdown-item[href='/tree']");
	public By dropDownGraphItem = By.cssSelector("a.dropdown-item[href='/graph']");
	
	public By cardBody = By.cssSelector("div.card-body");
	public By cardTitle = By.cssSelector("h5.card-title");
	public By cardText = By.cssSelector("p.card-text");
	

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
	//public void clickDataStructuredropdown() {
	//driver.findElement(dataStructure).click();
		
			//}
	//methods to click different drop down options - Array 
//	public void dropDownArrayItem() {
//	 WebElement arraysOption = driver.findElement(dropDownArrayItem));  
//	 arraysOption.click();
//	 
//	}
//	 
	// Method to click on the dropdown toggle
    public void clickDropdownToggle() {
        WebElement toggle = driver.findElement(dataStructure);
        toggle.click();
    }

    // Method to click on the 'Array' dropdown item
    public void clickDropdownItemArray() {
        WebElement arrayItem = driver.findElement(dropDownArrayItem);
        arrayItem.click();
    }
      
 // Method to click on the 'Linked List' dropdown item
    public void clickDropdownItemLinkedList() {
        WebElement linkedListItem = driver.findElement(dropDownLinkedListItem);
        linkedListItem.click();
    }
    
 // Method to click on the 'Stack' dropdown item
    public void clickDropdownItemStack() {
        WebElement stackItem = driver.findElement(dropDownStackItem);
        stackItem.click();
    }
 // Method to click on the 'Queue' dropdown item
    public void clickDropdownItemQueue() {
        WebElement queueItem = driver.findElement(dropDownQueueItem);
        queueItem.click();
    }
    
    
 // Method to click on the 'Tree' dropdown item
    public void clickDropdownItemTree() {
        WebElement treeItem = driver.findElement(dropDownTreeItem);
        treeItem.click();
    }
    
 // Method to click on the 'Graph' dropdown item
    public void clickDropdownItemGraph() {
        WebElement graphItem = driver.findElement(dropDownGraphItem);
        graphItem.click();
    }
    
	
	//get count of drop down elements
	public Integer getElementCnt(By locator) {
		Integer elementCount = driver.findElements(locator).size();
		return elementCount;
	}
	
	//get the text for Array Elements 
	public String getTextForArrayElements(By locator, Integer posInteger) {
		String elementText = driver.findElements(locator).get(posInteger).getText();
		return elementText;
	}
	
	//get the text after each item selected - for authentication error 
	public String getTextForElement(By locator) {
		String elementText = driver.findElement(locator).getText();
		return elementText;
	}
	
	public Integer getElementSize(By locator) {
		Integer elementCount = driver.findElements(locator).size();
		return elementCount;
	}
	
	//Element Displayed 
	public Boolean validateElementDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

//	public void authenticationMsgDisplay(){
//		WebElement authMessage = driver.findElement(authenticationmsg);
	
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
//	
	
}
	
	
	


