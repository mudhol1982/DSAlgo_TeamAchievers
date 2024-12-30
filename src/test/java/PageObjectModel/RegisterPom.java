package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import DriverManager.Driver_SetUp;
import Utilities.ExcelReader;

public class RegisterPom {
	
	public WebDriver driver = Driver_SetUp.getDriver();
	ExcelReader excelReader = new ExcelReader();

	//Web Locators using By class
	
	private By getStartedBtn = By.className("btn");
	private By registerLink_getStartedBtn = By.xpath("//div[2]/ul/a[2]");
}
