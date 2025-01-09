package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.Driver_SetUp;
import Utilities.ExcelReader;

public class LoginPom {
	
	WebDriver driver = Driver_SetUp.getDriver();
	ExcelReader excelReader = new ExcelReader();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //
	
	public By usernameTxt = By.xpath("//input[@name='username']");
	public By passwordTxt = By.xpath("//input[@name='password']");
	public By loginBtn = By.xpath("//input[@type='submit' and @value='Login']");
	public By alertMsg = By.xpath("");
}
