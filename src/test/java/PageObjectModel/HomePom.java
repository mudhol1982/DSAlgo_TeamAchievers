package PageObjectModel;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import DriverManager.Driver_SetUp;
import Utilities.ConfigReader;

public class HomePom {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize driver and WebDriverWait
    public HomePom(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Element Locators
    public final By getStartedButton = By.cssSelector("button.btn");
    public final By contentHeader = By.cssSelector(".content h1");
    public final By contentText = By.cssSelector("div.content p");
    private final By signOutLink = By.xpath("//a[@href='/logout']");
    private final By dropdownToggle = By.cssSelector("a.dropdown-toggle");
    private final By registerLink = By.cssSelector("a[href='/register']");
    private final By signInLink = By.cssSelector("a[href='/login']");

    // Open URLs
    public void openURL() {
        driver.get(ConfigReader.getUrl());
    }

    public void openPage(String url) {
        driver.get(url);
    }

    // Click Actions with better handling
    public void clickElement(By locator) {
        for (int i = 0; i < 3; i++) {  // Retry up to 3 times
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying click due to stale element: " + locator);
            } catch (TimeoutException e) {
                System.out.println("Element not clickable: " + locator);
                break;
            }
        }
    }

    public void ClickHomePageGetStartedButton() {
        clickElement(getStartedButton);
    }

    public void clickSignOutLink() {
        clickElement(signOutLink);
    }

    public void clickOnRegisterLink() {
        clickElement(registerLink);
    }

    public void clickOnSignInLink() {
        clickElement(signInLink);
    }

    public void clickDropdownToggle() {
        try {
            WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(dropdownToggle));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toggle);
            toggle.click();
        } catch (TimeoutException e) {
            System.out.println("Dropdown toggle not found");
        }
    }

    // Get Text Methods
    public String getTextForElement(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        } catch (TimeoutException e) {
            return "Element not found: " + locator;
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    
    public boolean isElementClickable(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}
