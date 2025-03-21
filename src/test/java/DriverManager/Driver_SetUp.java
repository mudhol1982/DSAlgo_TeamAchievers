package DriverManager;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver_SetUp {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    // Method to initialize the WebDriver based on the browser name
    public static synchronized void initializeBrowser(String browser) throws Exception {
        if (threadDriver.get() == null) { // Prevent reinitialization
            WebDriver driver;
            
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new Exception("Unsupported browser: " + browser);
            }
            
            // WebDriver configurations
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            
            threadDriver.set(driver); // Store WebDriver instance in ThreadLocal
        }
    }

    // Method to get WebDriver instance
    public static synchronized WebDriver getDriver() {
        if (threadDriver.get() == null) {
            throw new IllegalStateException("WebDriver is not initialized. Call initializeBrowser() first.");
        }
        return threadDriver.get();
    }

    // Method to close the WebDriver instance
    public static synchronized void closeDriver() {
        WebDriver driver = threadDriver.get();
        if (driver != null) {
            driver.quit(); // Close browser
            threadDriver.remove();
        }
    }
}