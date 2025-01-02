package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 


public class Step_HomePage {

	public HomePom hp = new HomePom();
	public IntroductionPagePom ip = new IntroductionPagePom();


	//TC01
	@When("The user enter correct dsAlgo portal URL <URL>")
	public void the_user_enter_correct_ds_algo_portal_url_url() {
		//launch the DS Portal url<https://dsportalapp.herokuapp.com/>
		hp.openURL();
	}

	@Then("The user should be able to land on dsAlgo portal with Get Started button")
	public void the_user_should_be_able_to_land_on_ds_algo_portal_with_get_started_button() {
		// Assert that the page contents are correct

		Assert.assertEquals(hp.getTextForElement(hp.contentHeader), "Preparing for the Interviews");
		Assert.assertEquals(hp.getTextForElement(hp.contentText), "You are at the right place");
		Assert.assertEquals(hp.getTextForElement(hp.getStartedButton), "Get Started");

	}

	//TC02
	@When("The user clicks the Get Started button")
	public void the_user_clicks_the_get_started_button() {
		hp.ClickHomePageGetStartedButton();
	}

	@Then("The user should land in Data Structure Introduction Page with register and Sign in links")
	public void the_user_should_land_in_data_structure_introduction_page_with_register_and_sign_in_links() {

		// On the Introduction Page - validate Register and Sign in links are clickable and enabled

		Assert.assertTrue(hp.linkClickable(ip.registerLink).isEnabled());
		Assert.assertTrue(hp.linkClickable(ip.signInLink).isEnabled());

		/*
		 * hp.linkClickable(ip.registerLink).click();
		 * 
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		//hp.linkClickable(ip.signInLink).click();
	}

	//TC03
	@When("The user clicks the Data Structures dropdown")
	public void the_user_clicks_the_data_structures_dropdown() {
		ip.clickDropdownToggle();

	}

	@Then("The user should be able to see six options like Arrays Linked List Stack Queue Tree Graph in dropdown menu")
	public void the_user_should_be_able_to_see_six_options_like_arrays_linked_list_stack_queue_tree_graph_in_dropdown_menu() {

		Assert.assertEquals(ip.getElementCnt(ip.dsDropdown),6);
		Assert.assertEquals(ip.getTextForArrayElements(ip.dsDropdown,0), "Arrays");
		Assert.assertEquals(ip.getTextForArrayElements(ip.dsDropdown,1), "Linked List");
		Assert.assertEquals(ip.getTextForArrayElements(ip.dsDropdown,2), "Stack");
		Assert.assertEquals(ip.getTextForArrayElements(ip.dsDropdown,3), "Queue");
		Assert.assertEquals(ip.getTextForArrayElements(ip.dsDropdown,4), "Tree");
		Assert.assertEquals(ip.getTextForArrayElements(ip.dsDropdown,5), "Graph");

	}
	//TC04

	@When("The user selects Arrays from the drop down without Sign in")
	public void the_user_selects_arrays_from_the_drop_down_without_sign_in(){

		ip.clickDropdownItemArray();
	}


	@Then("The user should able to see an warning message You are not logged in for Array drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_array_drop_down_option() {
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);

	}

	//TC05

	@Given("The user clicks Data Structures drop down")
	public void the_user_clicks_data_structures_drop_down() {
		ip.clickDropdownToggle();

	}

	@When("The user selects Linked List from the drop down without Sign in")
	public void the_user_selects_linked_list_from_the_drop_down_without_sign_in() {
		ip.clickDropdownItemLinkedList();
	}

	@Then("The user should able to see an warning message You are not logged in for Linked List drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_linked_list_drop_down_option() {
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);

	}

	//TC06

	@When("The user selects Stack from the drop down without Sign in")
	public void the_user_selects_stack_from_the_drop_down_without_sign_in() {
		ip.clickDropdownItemStack();
	}

	@Then("The user should able to see an warning message You are not logged in for Stack drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_stack_drop_down_option() {
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
	}
//TC07
	
	@When("The user selects Queue from the drop down without Sign in")
	public void the_user_selects_queue_from_the_drop_down_without_sign_in() {
	    // Write code here that turns the phrase above into concrete actions
		ip.clickDropdownItemQueue();
	}

	@Then("The user should able to see an warning message You are not logged in for Queue drop down option")
	public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_queue_drop_down_option() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
	}
	
//TC08

@When("The user selects Tree from the drop down without Sign in")
public void the_user_selects_tree_from_the_drop_down_without_sign_in() {
    // Write code here that turns the phrase above into concrete actions
	ip.clickDropdownItemTree();
}

@Then("The user should able to see an warning message You are not logged in for Tree drop down option")
public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_tree_drop_down_option() {
	Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
	Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
	Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
}

//TC09
@When("The user selects Graph from the drop down without Sign in")
public void the_user_selects_graph_from_the_drop_down_without_sign_in() {
    ip.clickDropdownItemGraph();
}

@Then("The user should able to see an warning message You are not logged in for Graph drop down option")
public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_graph_drop_down_option() {
	Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
	Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
	Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
}

//TC10

@When("The user clicks Get Started buttons of Data Structures-Introduction on the homepage without Sign in")
public void the_user_clicks_get_started_buttons_of_data_structures_introduction_on_the_homepage_without_sign_in() {
	// On the Introduction Page - validate Register and Sign in links are clickable and enabled
	ip.clickOnDataStructuresGetStartedBtn();
			
}

@Then("The user should able to see an warning message You are not logged in for DS Introduction")
public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_ds_introduction() {
	Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
	Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
	Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
}
//TC11
@When("The user clicks Get Started buttons of Array on the homepage without Sign in")
public void the_user_clicks_get_started_buttons_of_array_on_the_homepage_without_sign_in() {
	ip.clickOnArrayGetStartedBtn();
}

@Then("The user should able to see an warning message You are not logged in for Array")
public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_array() {
	Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
	Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
	Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
}

//TC12
@When("The user clicks Get Started buttons of Linked List on the homepage without Sign in")
public void the_user_clicks_get_started_buttons_of_linked_list_on_the_homepage_without_sign_in() {
	ip.clickOnLinkedListGetStartedBtn();
}

@Then("The user should able to see an warning message You are not logged in for Linked List")
public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_linked_list() {
	Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
	Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
	Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
}

//TC13
@When("The user clicks Get Started buttons of Stack on the homepage without Sign in")
public void the_user_clicks_get_started_buttons_of_stack_on_the_homepage_without_sign_in() {
	ip.clickOnStackGetStartedBtn();
}

@Then("The user should able to see an warning message You are not logged in for Stack")
public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_stack() {
	Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
	Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
	Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
}
//TC14
@When("The user clicks Get Started buttons of Queue on the homepage without Sign in")
public void the_user_clicks_get_started_buttons_of_queue_on_the_homepage_without_sign_in() {
	ip.clickOnQueueGetStartedBtn();
}

@Then("The user should able to see an warning message You are not logged in for Queue")
public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_queue() {
	Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
	Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
	Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
}

//TC15
@When("The user clicks Get Started buttons of Tree on the homepage without Sign in")
public void the_user_clicks_get_started_buttons_of_tree_on_the_homepage_without_sign_in() {
	ip.clickOnTreeGetStartedBtn();
}

@Then("The user should able to see an warning message You are not logged in for Tree")
public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_tree() {
	Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
	Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
	Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
}

//TC16
@When("The user clicks Get Started buttons of Graph on the homepage without Sign in")
public void the_user_clicks_get_started_buttons_of_graph_on_the_homepage_without_sign_in() {
	ip.clickOnGraphGetStartedBtn();
}

@Then("The user should able to see an warning message You are not logged in for Graph")
public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in_for_graph() {
    // Write code here that turns the phrase above into concrete actions
	Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
	Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
	Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
}

}