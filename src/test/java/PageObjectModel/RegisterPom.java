package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import DriverManager.Driver_SetUp;
import Utilities.ConfigReader;
import Utilities.ExcelReader;

public class RegisterPom {
	
	public WebDriver driver = Driver_SetUp.getDriver();
	ExcelReader excelReader = new ExcelReader();

	//Web Locators using By class
	private By getStartedButton = By.className("btn"); //Get Started Button
	private By registerLink_getStartedPage = By.xpath("//a[@href='/register']"); //Register link from Get Started page
	private By usernameTextBox = By.xpath("//input[@name='username']"); // username text field 
	private By passwordTextBox = By.xpath("//input[@name='password1']"); // password text field 
	private By confirmPasswordTextBox = By.xpath("//input[@name='password2']"); // confirm password text field
	
	private By registerBtn_RegPage = By.xpath("//input[@value='Register']"); // Register Button inside Register page
	private By loginLink = By.xpath("//div[2]/a[@href='/login']"); // login link beneath Register page 
	
	private By signInLink = By.xpath("//div[@class='navbar-nav']/ul/a[@href='/login']");
	
    private By registerSuccessMsg = By.xpath("//div[contains(@class,'alert alert-primary')]");
    
    private By registerErrorMsg = By.xpath("//div[contains(@class,'alert-danger')]");
    
    private By passwordMismatchOnRegPage = By.xpath("//div[@class='alert alert-primary']");
    
    private By registrationSuccessMsg = By.xpath("//div[@class='alert alert-primary']");
    
    //Methods used on Web Elements
    public void openURL() {
    	
    	driver.get(ConfigReader.getUrl());
    	   	
    }
    
    //method to click on GetStarted Button
    public void clickGetStartedBtn() {
    	
    	driver.findElement(getStartedButton).click();
    }
    
    
    public void clickRegisterLink_getStartedPage() {
		driver.findElement(registerLink_getStartedPage).click();
    }
    
     
	public void clickRegisterBtn_RegisterPage() {
		driver.findElement(registerBtn_RegPage).click();
	}
    
    
    
    
	
	
	
}

