package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import DriverManager.Driver_SetUp;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_HomePage {
	
    private IntroductionPagePom ip;
    private HomePom hp;

    public Step_HomePage() {
        WebDriver driver = Driver_SetUp.getDriver();
        this.ip = new IntroductionPagePom(driver);
        this.hp = new HomePom(driver);  // Ensure hp is initialized properly
    }

    // TC01
    @When("The user enter correct dsAlgo portal URL")
    public void the_user_enter_correct_ds_algo_portal_url() {
        hp.openURL();
    }

    @Then("The user should be able to land on dsAlgo portal with Get Started button")
    public void the_user_should_be_able_to_land_on_ds_algo_portal_with_get_started_button() {
        Assert.assertEquals(hp.getTextForElement(hp.contentHeader), "Preparing for the Interviews");
        Assert.assertEquals(hp.getTextForElement(hp.contentText), "You are at the right place");
        Assert.assertEquals(hp.getTextForElement(hp.getStartedButton), "Get Started");
    }

    // TC02
    @When("The user clicks the Get Started button")
    public void the_user_clicks_the_get_started_button() {
        hp.ClickHomePageGetStartedButton();
    }

    @Then("The user should land in Data Structure Introduction Page with register and Sign in links")
    public void the_user_should_land_in_data_structure_introduction_page_with_register_and_sign_in_links() {
        Assert.assertTrue(ip.isElementDisplayed(ip.registerLink), "Register link is not displayed.");
        Assert.assertTrue(ip.isElementDisplayed(ip.signInLink), "Sign In link is not displayed.");
    }

    // TC03
    @When("The user clicks the Data Structures dropdown")
    public void the_user_clicks_the_data_structures_dropdown() {
        ip.clickDropdownToggle();
    }

    @Then("The user should be able to see six options like Arrays, Linked List, Stack, Queue, Tree, Graph in dropdown menu")
    public void the_user_should_be_able_to_see_six_options_in_dropdown_menu() {
        Assert.assertEquals(ip.getElementCount(ip.dsDropdown), 6, "Dropdown count mismatch.");

        String[] expectedTexts = {"Arrays", "Linked List", "Stack", "Queue", "Tree", "Graph"};
        for (int i = 0; i < expectedTexts.length; i++) {
            Assert.assertEquals(ip.getTextForArrayElements(ip.dsDropdown, i), expectedTexts[i], "Text mismatch at index: " + i);
        }
    }

    // TC04 - Array
    @When("The user selects Arrays from the drop down without Sign in")
    public void the_user_selects_arrays_from_the_drop_down_without_sign_in() {
        ip.clickDropdownItem(ip.dropDownArrayItem);
    }

    @Then("The user should see a warning message You are not logged in for Array")
    public void the_user_should_see_a_warning_message_for_array() {
        Assert.assertTrue(ip.isElementDisplayed(ip.authenticationMsg), "Authentication message is not displayed.");
        Assert.assertEquals(ip.getText(ip.authenticationMsg), "You are not logged in", "Authentication message text mismatch.");
    }

    // TC05 - Linked List
    @When("The user selects Linked List from the drop down without Sign in")
    public void the_user_selects_linked_list_from_the_drop_down_without_sign_in() {
        ip.clickDropdownItem(ip.dropDownLinkedListItem);
    }

    @Then("The user should see a warning message You are not logged in for Linked List")
    public void the_user_should_see_a_warning_message_for_linked_list() {
        Assert.assertTrue(ip.isElementDisplayed(ip.authenticationMsg), "Authentication message is not displayed.");
        Assert.assertEquals(ip.getText(ip.authenticationMsg), "You are not logged in", "Authentication message text mismatch.");
    }

    // TC06 - Stack
    @When("The user selects Stack from the drop down without Sign in")
    public void the_user_selects_stack_from_the_drop_down_without_sign_in() {
        ip.clickDropdownItem(ip.dropDownStackItem);
    }

    @Then("The user should see a warning message You are not logged in for Stack")
    public void the_user_should_see_a_warning_message_for_stack() {
        Assert.assertTrue(ip.isElementDisplayed(ip.authenticationMsg), "Authentication message is not displayed.");
        Assert.assertEquals(ip.getText(ip.authenticationMsg), "You are not logged in", "Authentication message text mismatch.");
    }

    // TC07 - Queue
    @When("The user selects Queue from the drop down without Sign in")
    public void the_user_selects_queue_from_the_drop_down_without_sign_in() {
        ip.clickDropdownItem(ip.dropDownQueueItem);
    }

    @Then("The user should see a warning message You are not logged in for Queue")
    public void the_user_should_see_a_warning_message_for_queue() {
        Assert.assertTrue(ip.isElementDisplayed(ip.authenticationMsg), "Authentication message is not displayed.");
        Assert.assertEquals(ip.getText(ip.authenticationMsg), "You are not logged in", "Authentication message text mismatch.");
    }

    // TC08 - Tree
    @When("The user selects Tree from the drop down without Sign in")
    public void the_user_selects_tree_from_the_drop_down_without_sign_in() {
        ip.clickDropdownItem(ip.dropDownTreeItem);
    }

    @Then("The user should see a warning message You are not logged in for Tree")
    public void the_user_should_see_a_warning_message_for_tree() {
        Assert.assertTrue(ip.isElementDisplayed(ip.authenticationMsg), "Authentication message is not displayed.");
        Assert.assertEquals(ip.getText(ip.authenticationMsg), "You are not logged in", "Authentication message text mismatch.");
    }

    // TC09 - Graph
    @When("The user selects Graph from the drop down without Sign in")
    public void the_user_selects_graph_from_the_drop_down_without_sign_in() {
        ip.clickDropdownItem(ip.dropDownGraphItem);
    }

    @Then("The user should see a warning message You are not logged in for Graph")
    public void the_user_should_see_a_warning_message_for_graph() {
        Assert.assertTrue(ip.isElementDisplayed(ip.authenticationMsg), "Authentication message is not displayed.");
        Assert.assertEquals(ip.getText(ip.authenticationMsg), "You are not logged in", "Authentication message text mismatch.");
    }
}
