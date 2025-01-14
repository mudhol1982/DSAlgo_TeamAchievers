package PageObjectModel;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import DriverManager.Driver_SetUp;
import Utilities.ExcelReader;
import Utilities.ExcelReader1;

public class RegisterPom {

	WebDriver driver = Driver_SetUp.getDriver();
	ExcelReader1 excelReader1 = new ExcelReader1();
	ExcelReader excelReader = new ExcelReader();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //

	// Web Locators using By class
	private By getStartedButton = By.className("btn"); // Get Started Button
	private By registerLink_getStartedPage = By.xpath("//div[2]/ul/a[2]");// register link from get started page

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
	//private By registerErrorMsg = By.xpath("//div[contains(@class,'alert-danger')]");
	private By passwordMismatchOnRegPage = By.xpath("//div[@class='alert alert-primary']");
	//private By registrationSuccessMsg = By.xpath("//div[@class='alert alert-primary']");

	// Methods used on Web Elements
	public void openURL() {
		driver.get("https://dsportalapp.herokuapp.com/");
	}

	public void clickGetStartedBtn() {
		driver.findElement(getStartedButton).click();
	}

	public void clickRegisterLink_getStartedPage() {
		driver.findElement(registerLink_getStartedPage).click();
	}

	public void clickRegisterBtn_RegisterPage() {
		driver.findElement(registerBtn_RegPage).click();
	}

	// Fill out Registration Form input fields
	public void enterUsername(String username) throws IOException {
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

		//List<Map<String, String>> testdata = excelReader1.getData("src/test/resources/Excel/TestData.xlsx", sheetname);
		List<Map<String, String>> testdata = excelReader.readFromExcel("src/test/resources/Excel/TestData.xlsx", sheetname);
		System.out.println("registertestdata ---------> "+testdata);
		String username = testdata.get(row).get("username");
		enterUsername(username);
		String password = testdata.get(row).get("password");
		enterPassword(password);
		String passwordConfirm = testdata.get(row).get("password confirmation");
		enterPasswordConfirmation(passwordConfirm);
	}

    //Methods to invoke login process
	public void clickLoginLink() {
		driver.findElement(loginLink).click();
	}
//method that is used to click on signin link after successful registration from Registration page 
	public void clickSignInLink() {
		driver.findElement(signInLink).click();
		System.out.println("sign in link clicked ---------> "+signInLink);
	}

	//method to verify PasswordDonotmatch Error
	public String displayPasswordMismatchError() {
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

    //validate error message returned in the browser for invalid or missing fields 
	public String switchToElementAndGetValidationMessage() {
		WebElement activeElement = driver.switchTo().activeElement();
		
//		//adding null check before printing active element 
//		if (activeElement != null) {
//		    System.out.println("Active element: " + activeElement);
//		} else {
//		    System.out.println("Active element is null.");
//		}
//		
		//System.out.println("Active element: " + activeElement);
		
		String actualAlertMsg = activeElement.getAttribute("validationMessage");
		 System.out.println("ValidationMessage" + actualAlertMsg);
		return actualAlertMsg;
	}

}
