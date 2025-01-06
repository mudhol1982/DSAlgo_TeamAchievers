package PageObjectModel;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import DriverManager.Driver_SetUp;
import Utilities.ExcelReader;

public class RegisterPom {

	public WebDriver driver = Driver_SetUp.getDriver();
	ExcelReader excelReader = new ExcelReader();

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //
	// Timeout in second

	// Web Locators using By class
	private By getStartedButton = By.className("btn"); // Get Started Button
	private By registerLink_getStartedPage = By.xpath("//div[2]/ul/a[2]");// register link from get started page

	// private By registerLink_getStartedPage = By.xpath("//a[@href='/register']");
	// //Register link from Get Started page

	// user name text field
	private By usernameTextBox = By.xpath("//div[@class='col-sm']/form/input[2][@name='username']"); 
	// password text field
	private By passwordTextBox = By.xpath("//div[@class='col-sm']/form/input[3][@name='password1']");
	// confirm password text field
	private By confirmPasswordTextBox = By.xpath("//div[@class='col-sm']/form/input[4][@name='password2']"); 
	// Register Button inside Register page
	private By registerBtn_RegPage = By.xpath("//input[@value='Register']"); 
	// login link beneath Register page
	private By loginLink = By.xpath("//div[2]/a[@href='/login']"); 

	private By signInLink = By.xpath("//div[@class='navbar-nav']/ul/a[@href='/login']");// link for login
	private By registerSuccessMsg = By.xpath("//div[contains(@class,'alert alert-primary')]");
	private By registerErrorMsg = By.xpath("//div[contains(@class,'alert-danger')]");
	private By passwordMismatchOnRegPage = By.xpath("//div[@class='alert alert-primary']");
	private By registrationSuccessMsg = By.xpath("//div[@class='alert alert-primary']");

	// Methods used on Web Elements
	public void openURL() {
		System.out.println("Inside openURL");
		driver.get("https://dsportalapp.herokuapp.com/");
	}

	public void clickGetStartedBtn() {
		System.out.println("Inside clickGetStartedBtn");
		driver.findElement(getStartedButton).click();
	}

	public void clickRegisterLink_getStartedPage() {
		System.out.println("Inside clickRegisterLink_getStartedPage");
		driver.findElement(registerLink_getStartedPage).click();
	}

	public void clickRegisterBtn_RegisterPage() {
		driver.findElement(registerBtn_RegPage).click();
	}

	// Fill out Registration Form input fields
	public void enterUsername(String username) throws IOException {
//		wait.until(ExpectedConditions.presenceOfElementLocated(usernameTextBox));
		driver.findElement(usernameTextBox).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);
	}

	public void enterPasswordConfirmation(String confirmPswd) {
		driver.findElement(confirmPasswordTextBox).sendKeys(confirmPswd);
	}

	public void fillRegistrationForm(String sheetname, int row)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData("src/test/resources/Excel/TestData.xlsx", sheetname);

		System.out.println("testdata --->" + testdata);

		String username = testdata.get(row).get("username");
		System.out.println("username------->" + username);
		enterUsername(username);

		String password = testdata.get(row).get("password");
		enterPassword(password);

		String passwordConfirm = testdata.get(row).get("password confirmation");
		enterPasswordConfirmation(passwordConfirm);
	}

    //Fill Login Form 
	public void fillLoginFormDataDriven(String sheetname, int row)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData("/src/test/resources/Excel/TestData.xlsx", sheetname);
		String username = testdata.get(row).get("username");
		enterUsername(username);
		String password = testdata.get(row).get("password");
		enterPassword(password);
	}

    //Methods to invoke login process
	public void clickLoginLink() {
		driver.findElement(loginLink).click();
	}

	public void clickLoginBtn() {
		driver.findElement(signInLink).click();
	}

	public String showErrorMsg_PswdDoNotMatch() {
		return driver.findElement(passwordMismatchOnRegPage).getText();
	}

	public boolean checkIfRegisterSuccessMsgIsDisplayed() {
		return driver.findElement(registerSuccessMsg).isDisplayed();
	}

	public String successMsg() {
		return driver.findElement(registerSuccessMsg).getText();
	}

	public String activeElementBrowserValidation() // Capture error - Please fill out this field
	{
		return driver.findElement(usernameTextBox).getAttribute("validationMessage");
	}

	public void Land_On_RegistrationPage() {
		this.openURL();
		this.clickGetStartedBtn();
		this.clickRegisterLink_getStartedPage();
	}

    //validate browser message
	public String switchToElementAndGetValidationMessage() {
		WebElement activeElement = driver.switchTo().activeElement();
		String browserValidationmsg = activeElement.getAttribute("validationMessage");
		return browserValidationmsg;
	}

}
