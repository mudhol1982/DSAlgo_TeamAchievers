package StepDefinitions;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.LoginPom;
import PageObjectModel.RegisterPom;
import io.cucumber.java.en.*;

public class Step_LoginPage {
    
    private LoginPom login;
    private HomePom hp;
    private IntroductionPagePom ip;
    private RegisterPom regPage;

    public Step_LoginPage() {
        WebDriver driver = DriverManager.Driver_SetUp.getDriver();
        this.login = new LoginPom(driver);
        this.hp = new HomePom(driver);
        this.ip = new IntroductionPagePom(driver);
        this.regPage = new RegisterPom(driver);
    }

    @Given("The user is on the DS Algo Sign in Page")
    public void user_on_sign_in_page() {
        hp.openURL();
        hp.clickHomePageGetStartedButton();
        ip.clickOnSignInLink();
    }

    @When("The user clicks login button after leaving the Username and Password empty from sheet {string} row {int}")
    public void user_clicks_login_with_empty_fields(String sheetName, int rowNum) throws InvalidFormatException, IOException, OpenXML4JException {
        login.enterLoginFormFields(sheetName, rowNum);
        login.clickLoginBtn();
    }

    @Then("The error message {string} appears below Username textbox")
    public void verify_username_error_message(String expectedMessage) {
        String actualMessage = regPage.switchToElementAndGetValidationMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    
    @When("The user clicks login button after entering only Password from sheet {string} row {int}")
    public void user_clicks_login_with_password_only(String sheetName, int rowNum) throws InvalidFormatException, IOException, OpenXML4JException {
        login.enterLoginFormFields(sheetName, rowNum);
        login.clickLoginBtn();
    }

    @When("The user clicks login button after entering only Username from sheet {string} row {int}")
    public void user_clicks_login_with_username_only(String sheetName, int rowNum) throws InvalidFormatException, IOException, OpenXML4JException {
        login.enterLoginFormFields(sheetName, rowNum);
        login.clickLoginBtn();
    }

    @Then("The error message {string} appears below Password textbox")
    public void verify_password_error_message(String expectedMessage) {
        String actualMessage = regPage.switchToElementAndGetValidationMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @When("The user clicks login button after entering invalid Username and Password from sheet {string} row {int}")
    public void user_clicks_login_with_invalid_credentials(String sheetName, int rowNum) throws InvalidFormatException, IOException, OpenXML4JException {
        login.enterLoginFormFields(sheetName, rowNum);
        login.clickLoginBtn();
    }

    @Then("The user should see an error message {string}")
    public void verify_login_error_message(String expectedMessage) {
        Assert.assertEquals(ip.getTextForElement(login.alertMsg), expectedMessage);
    }

    @When("The user clicks login button after entering invalid Username and valid Password from sheet {string} row {int}")
    public void user_clicks_login_with_invalid_username(String sheetName, int rowNum) throws InvalidFormatException, IOException, OpenXML4JException {
        login.enterLoginFormFields(sheetName, rowNum);
        login.clickLoginBtn();
    }

    @When("The user clicks login button after entering valid Username and invalid Password from sheet {string} row {int}")
    public void user_clicks_login_with_invalid_password(String sheetName, int rowNum) throws InvalidFormatException, IOException, OpenXML4JException {
        login.enterLoginFormFields(sheetName, rowNum);
        login.clickLoginBtn();
    }

    @When("The user clicks login button after entering valid Username and Password from sheet {string} row {int}")
    public void user_clicks_login_with_valid_credentials(String sheetName, int rowNum) throws InvalidFormatException, IOException, OpenXML4JException {
        login.enterLoginFormFields(sheetName, rowNum);
        login.clickLoginBtn();
    }

    @Then("The user should land on the Data Structure Home Page with message {string}")
    public void verify_login_success_message(String expectedMessage) {
        Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationMsg));
        Assert.assertEquals(ip.getTextForElement(ip.authenticationMsg), expectedMessage);
    }

    @When("The user selects {string} from the dropdown after signing in")
    public void user_selects_dropdown_option(String option) {
        switch (option) {
            case "Array": ip.clickDropdownItemArray(); break;
            case "Linked List": ip.clickDropdownItemLinkedList(); break;
            case "Stack": ip.clickDropdownItemStack(); break;
            case "Queue": ip.clickDropdownItemQueue(); break;
            case "Tree": ip.clickDropdownItemTree(); break;
            case "Graph": ip.clickDropdownItemGraph(); break;
            default: throw new IllegalArgumentException("Invalid dropdown option: " + option);
        }
    }

    @Then("The user should see the {string} details page")
    public void verify_details_page(String expectedTitle) {
        Assert.assertEquals(ip.getPageTitle(), expectedTitle);
    }

    @When("The user clicks the Sign Out link")
    public void user_clicks_sign_out() {
        hp.clickSignOutLink();
    }

    @Then("The user should sign out successfully with message {string}")
    public void verify_logout_message(String expectedMessage) {
        Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationMsg));
        Assert.assertEquals(ip.getTextForElement(ip.authenticationMsg), expectedMessage);
    }
}
