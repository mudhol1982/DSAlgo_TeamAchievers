package DriverManager;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver_SetUp {

    private static WebDriver driver; // WebDriver instance

    // Method to initialize the WebDriver based on the browser name
    public static WebDriver initializeBrowser(String browser) throws Exception {

        // If the browser is Chrome, initialize ChromeDriver
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } 
        // If the browser is Firefox, initialize FirefoxDriver
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } 
        // If the browser is Edge, initialize EdgeDriver
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } 
        // If the browser name is not recognized, throw an exception
        else {
            throw new Exception("Unsupported browser: " + browser);
        }

        // Set WebDriver configurations (timeouts, window size, cookies)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver; // Return the WebDriver instance
    }

    // Method to close the WebDriver instance (close the browser)
    public static void closeDriver() {
        if (driver != null) {
            driver.quit(); // Close the browser window
        }
    }

    // Getter for the WebDriver instance (useful for other classes)
    public static WebDriver getDriver() {
        return driver;
    }
}
