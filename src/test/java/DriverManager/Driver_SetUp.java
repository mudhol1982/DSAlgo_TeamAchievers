package DriverManager;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver_SetUp {

    // ThreadLocal to store browser instance for each thread (parallel execution)
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    // Method to initialize the WebDriver based on the browser name
    public static WebDriver initializeBrowser(String browser) throws Exception {

        // If the WebDriver is already initialized for the current thread, return it
        if (threadDriver.get() != null) {
            return threadDriver.get();  // Return the already initialized driver if it exists
        }

        WebDriver driver = null;

        // Initialize WebDriver based on the specified browser
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

        // Store the driver in ThreadLocal for the current thread
        threadDriver.set(driver);  // This will ensure it's only set once per thread
        return driver;
    }

    // Method to close the WebDriver instance (close the browser)
    public static void closeDriver() {
        WebDriver driver = threadDriver.get();
        if (driver != null) {
            //driver.quit(); // Close the browser window
            //threadDriver.remove(); // Remove driver from ThreadLocal after quitting
        	System.out.println("close");
        }
    }

    // Method to get the WebDriver instance for the current thread
    public static synchronized WebDriver getDriver() {
        return threadDriver.get();
    }

	
}

