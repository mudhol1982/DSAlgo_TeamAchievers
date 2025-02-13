package DriverManager;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver_SetUp {

	private static WebDriver driver; // WebDriver instance
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

	// Method to initialize the WebDriver based on the browser name
	public static WebDriver initializeBrowser(String browser) throws Exception {

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
		threadDriver.set(driver);
		return threadDriver.get();
	}

	// Method to close the WebDriver instance (close the browser)
	public static void closeDriver() {
		System.out.println("driver-->"+driver);
		if (driver != null) {
		//	driver.quit(); // Close the browser window
			System.out.println("driver.quit()-->");
		}
	}

	public static synchronized WebDriver getDriver() {
		return threadDriver.get();
	}
}
