package DriverManager;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver_SetUp {

    // Use ThreadLocal to maintain separate WebDriver instances for each thread
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    // Method to initialize the WebDriver based on the browser name
    public static WebDriver initializeBrowser(String browser) throws Exception {

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new Exception("Unsupported browser: " + browser);
        }

        // Set WebDriver configurations (timeouts, window size, cookies)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Store driver in the current thread's local storage
        threadDriver.set(driver);
        return threadDriver.get();
    }

    // Method to close the WebDriver instance (close the browser)
    public static void closeDriver() {
        WebDriver driver = threadDriver.get();
        if (driver != null) {
            driver.quit(); // Close the browser window
            threadDriver.remove(); // Remove the driver instance from the current thread
            System.out.println("Driver closed successfully.");
        }
    }

    // Method to get the WebDriver instance for the current thread
    public static synchronized WebDriver getDriver() {
        return threadDriver.get();
    }
}
