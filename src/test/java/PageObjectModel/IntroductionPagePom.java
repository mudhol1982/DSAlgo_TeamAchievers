package PageObjectModel;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.LoggerLoad;

public class IntroductionPagePom {
    
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor for parallel testing
    public IntroductionPagePom(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Web Elements (Locators)
    private final By numpyNinja = By.cssSelector("a[href='/home']");
    private final By dataStructure = By.cssSelector("a.dropdown-toggle");
    public final By dsDropdown = By.xpath("//a[contains(@class, 'dropdown-item')]");

    // Dropdown Items
    private final By dropDownLinkedListItem = By.cssSelector("a[href='/linked-list']");
    public final By dropDownArrayItem = By.cssSelector("a[href='/array']");
    private final By dropDownStackItem = By.cssSelector("a[href='/stack']");
    private final By dropDownQueueItem = By.cssSelector("a[href='/queue']");
    private final By dropDownTreeItem = By.cssSelector("a[href='/tree']");
    private final By dropDownGraphItem = By.cssSelector("a[href='/graph']");
    By authenticationMsg = By.id("authMessage");  

    // Get Started Buttons
    private final By dsIntroductionGetStartedBtn = By.cssSelector("a[href='/data-structures-introduction']");
    private final By arrayGetStartedBtn = By.cssSelector("a[href='/array']");
    private final By linkedListGetStartedBtn = By.cssSelector("a[href='/linked-list']");
    private final By stackGetStartedBtn = By.cssSelector("a[href='/stack']");
    private final By queueGetStartedBtn = By.cssSelector("a[href='/queue']");
    private final By treeGetStartedBtn = By.cssSelector("a[href='/tree']");
    private final By graphGetStartedBtn = By.cssSelector("a[href='/graph']");

    // Authentication Elements
    public final By signInLink = By.cssSelector("a[href='/login']");
    public final By registerLink = By.cssSelector("a[href='/register']");

    // Open a page
    public void openPage(String url) {
        driver.get(url);
        LoggerLoad.info("Navigated to URL: " + url);
    }

    // Click Dropdown Toggle
    public void clickDropdownToggle() {
        clickElement(dataStructure);
    }

    // Click on Dropdown Items
    public void clickDropdownItem(By dropdownItem) { clickElement(dropdownItem); }

    // Click on Get Started Buttons
    public void clickOnDataStructuresGetStartedBtn() { clickElement(dsIntroductionGetStartedBtn); }
    public void clickOnArrayGetStartedBtn() { clickElement(arrayGetStartedBtn); }
    public void clickOnLinkedListGetStartedBtn() { clickElement(linkedListGetStartedBtn); }
    public void clickOnStackGetStartedBtn() { clickElement(stackGetStartedBtn); }
    public void clickOnQueueGetStartedBtn() { clickElement(queueGetStartedBtn); }
    public void clickOnTreeGetStartedBtn() { clickElement(treeGetStartedBtn); }
    public void clickOnGraphGetStartedBtn() { clickElement(graphGetStartedBtn); }

    // Click on Register or Sign-In Link
    public void clickOnRegisterLink() { clickElement(registerLink); }
    public void clickOnSignInLink() { clickElement(signInLink); }

    // Generic Click Method with Retry Logic (Handles StaleElementException)
    public void clickElement(By locator) {
        for (int i = 0; i < 3; i++) { // Retry mechanism (max 3 attempts)
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();
                LoggerLoad.info("Clicked on: " + locator);
                return;
            } catch (StaleElementReferenceException e) {
                LoggerLoad.warn("Retrying click due to stale element: " + locator);
            } catch (TimeoutException e) {
                LoggerLoad.error("[" + driver.getTitle() + "] Element not clickable: " + locator);
                break;
            }
        }
    }

    // Get Text from an Element
    public String getText(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText().trim();
        } catch (TimeoutException e) {
            LoggerLoad.error("Text not found for locator: " + locator);
            return null;
        }
    }
    
    public boolean isAuthenticationMsgDisplayed() {
        return driver.findElement(authenticationMsg).isDisplayed();
    }

    // Check if an Element is Displayed
    public boolean isElementDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    // Get Count of Elements
    public int getElementCount(By locator) {
        return driver.findElements(locator).size();
    }
    
    public String getPageTitle() {
        return driver.getTitle(); 
    }
    
    public void clickDropdownItem() {
        driver.findElement(dropDownArrayItem).click();
    }
    
    

    // Get Text for Dropdown Items
//    public String getDropdownItemText(By locator, int index) {
//        List<WebElement> elements = driver.findElements(locator);
//        if (index >= 0 && index < elements.size()) {
//            return elements.get(index).getText().trim();
//        } else {
//            LoggerLoad.error("Invalid index: " + index);
//            return null;
//        }
//    }
//    
    public String getDropdownItemText(int index) {
        List<WebElement> dropdownItems = driver.findElements(dsDropdown);
        return dropdownItems.get(index).getText();
    }
}
