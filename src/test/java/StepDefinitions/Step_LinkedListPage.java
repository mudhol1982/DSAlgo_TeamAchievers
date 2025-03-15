package StepDefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AppHooks.Hooks;
import DriverManager.Driver_SetUp;
import PageObjectModel.DataStructureIntroPom;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.LinkedListPom;
import PageObjectModel.TryEditorDsPom;
import io.cucumber.java.en.*;

public class Step_LinkedListPage {

	public HomePom hp = new HomePom();
	public IntroductionPagePom ip = new IntroductionPagePom();
	public DataStructureIntroPom dsIntro = new DataStructureIntroPom();
	public LinkedListPom ls = new LinkedListPom();
	public TryEditorDsPom tp = new TryEditorDsPom();
	

	public WebDriver driver = Driver_SetUp.getDriver();

	// TC01
	@When("The user clicks the Get Started button of Linked List section")
	public void the_user_clicks_the_get_started_button_of_linked_list_section() {
		ls.clicklsGetStartedBtn();
		// ip.clickOnLinkedListGetStartedBtn();
	}

	@Then("The user should be directed to Linked List page")
	public void the_user_should_be_directed_to_linked_list_page() {
		Assert.assertEquals("Linked List", dsIntro.validatePageTitle());
	}

	// TC02
	@Given("The user is on the Linked List page")
	public void the_user_is_on_the_linked_list_page() {
		ip.clickDropdownToggle();
		ip.clickDropdownItemLinkedList();
	}

	@When("The user clicks the Introduction link")
	public void the_user_clicks_the_introduction_link() {
		ls.clicklsIntroductionLink();
	}

	@Then("The user should be redirected to Introduction page")
	public void the_user_should_be_redirected_to_introduction_page() {
		Assert.assertEquals("Introduction", dsIntro.validatePageTitle());
	}

	// TC03
	@Given("The user is in the Introduction page")
	public void the_user_is_in_the_introduction_page() {
		ip.clickDropdownToggle();
		ip.clickDropdownItemLinkedList();
		ls.clicklsIntroductionLink();
	}

	@When("The user clicks Try Here button in Introduction page")
	public void the_user_clicks_try_here_button_in_introduction_page() {
		tp.clickTryHereBtn();
	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button() {
		Assert.assertEquals("Assessment", dsIntro.validatePageTitle());
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
	}
	// TC04

	@When("The user clicks the Run button without entering the code in the Editor")
	public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor() {
		tp.clickRunButton();
	}

	@Then("The user should not see any error message as an alert")
	public void the_user_should_not_see_any_error_message_as_an_alert() throws TimeoutException {
		Assert.assertEquals(false, tp.isAlertPresent());
	}

	// TC05 and TC06 --> this is called from already working code from DS page
	// (Step_DataStructurePage.java file)

	// TC07

	@Given("The user is on the Linked List page of DS")
	public void the_user_is_on_the_linked_list_page_of_ds() {
		hp.openLinkedList();
	}

	@When("The user clicks the Creating Linked LIst link")
	public void the_user_clicks_the_creating_linked_l_ist_link() {
		ls.clicklsCreatingLinkedLIstLink();
	}

	@Then("The user should be redirected to  Creating Linked LIst link page")
	public void the_user_should_be_redirected_to_creating_linked_l_ist_link_page() {

		Assert.assertEquals("Creating Linked LIst", dsIntro.validatePageTitle());
	}

//TC08

	@Given("The user is on the Creating Linked LIst page")
	public void the_user_is_on_the_creating_linked_l_ist_page() {
		hp.openLinkedList();
		ls.clicklsCreatingLinkedLIstLink();
	}

	@When("The user clicks Try Here button in Creating Linked LIst page")
	public void the_user_clicks_try_here_button_in_creating_linked_l_ist_page() {

		tp.clickTryHereBtn();

	}
	// TC09 --> this is called from already working code from DS page
	// (Step_DataStructurePage.java file)
	// TC10 --> this is called from already working code from DS page
	// (Step_DataStructurePage.java file)
	// TC11 --> this is called from already working code from DS page
	// (Step_DataStructurePage.java file)

	// TC12
	@When("The user clicks the Types of Linked List link")
	public void the_user_clicks_the_types_of_linked_list_link() {
		ls.clicklsTypesOfLinkedListLink();

	}

	@Then("The user should be redirected to Types of Linked List page")
	public void the_user_should_be_redirected_to_types_of_linked_list_page() {
		Assert.assertEquals("Types of Linked List", dsIntro.validatePageTitle());
	}
	// TC13
	

@Given("The user is on the Types of Linked List page of Linked List")
public void the_user_is_on_the_types_of_linked_list_page_of_linked_list() {
	hp.openLinkedList();
	ls.clicklsTypesOfLinkedListLink();
}

@When("The user clicks Try Here button in Types of Linked List page")
public void the_user_clicks_try_here_button_in_types_of_linked_list_page() {
    tp.clickTryHereBtn();
}
	// TC14, TC15, TC16  --> this is called from already working code from DS page
// (Step_DataStructurePage.java file)

//TC17
@When("The user clicks the Implement Linked List in Python page link")
public void the_user_clicks_the_implement_linked_list_in_python_page_link() {
   ls.clicklsImplementLinkedListInPythonLink();
}

@Then("The user should be redirected to Implement Linked List in Python page")
public void the_user_should_be_redirected_to_implement_linked_list_in_python_page() {
	Assert.assertEquals("Implement Linked List in Python", dsIntro.validatePageTitle());
}
//TC18
@Given("The user is on the Implement Linked List in Python page")
public void the_user_is_on_the_implement_linked_list_in_python_page() {
	hp.openLinkedList();
	ls.clicklsImplementLinkedListInPythonLink();
}

@When("The user clicks Try Here button in Implement Linked List in Python page")
public void the_user_clicks_try_here_button_in_implement_linked_list_in_python_page() {
	tp.clickTryHereBtn();
}

//TC19,TC20,TC21 --> this is called from already working code from DS page
//(Step_DataStructurePage.java file)

//TC22
@When("The user clicks the Traversal page link")
public void the_user_clicks_the_traversal_page_link() {
   ls.clicklsTraversalLink();
}

@Then("The user should be redirected to Traversal page")
public void the_user_should_be_redirected_to_traversal_page() {
	Assert.assertEquals("Traversal", dsIntro.validatePageTitle());
}

//TC23
@Given("The user is on the Traversal page")
public void the_user_is_on_the_traversal_page() {
	hp.openLinkedList();
	ls.clicklsTraversalLink();
}

@When("The user clicks Try Here button in Traversal page")
public void the_user_clicks_try_here_button_in_traversal_page() {
	tp.clickTryHereBtn();
}
//TC24, TC25, TC26 --> this is called from already working code from DS page
//(Step_DataStructurePage.java file)

//TC27
@When("The user clicks the Insertion page link")
public void the_user_clicks_the_insertion_page_link() {
    ls.clicklsInsertionLink();
}

@Then("The user should be redirected to Insertion page")
public void the_user_should_be_redirected_to_insertion_page() {
	Assert.assertEquals("Insertion", dsIntro.validatePageTitle());
}

//TC28
@Given("The user is on the Insertion page")
public void the_user_is_on_the_insertion_page() {
	hp.openLinkedList();
	ls.clicklsInsertionLink();
}

@When("The user clicks Try Here button in Insertion page")
public void the_user_clicks_try_here_button_in_insertion_page() {
	tp.clickTryHereBtn();
}
//TC29, TC30, TC31 --> this is called from already working code from DS page
//(Step_DataStructurePage.java file)

//TC32
@When("The user clicks the Deletion page link")
public void the_user_clicks_the_deletion_page_link() {
   ls.clicklsDeletionLink();
}

@Then("The user should be redirected to Deletion page")
public void the_user_should_be_redirected_to_deletion_page() {
	Assert.assertEquals("Deletion", dsIntro.validatePageTitle());;
}

//TC33

@Given("The user is on the Deletion page")
public void the_user_is_on_the_deletion_page() {
	hp.openLinkedList();
	ls.clicklsDeletionLink();
}

@When("The user clicks Try Here button in Deletion page")
public void the_user_clicks_try_here_button_in_deletion_page() {
   tp.clickTryHereBtn();
}
//TC34, TC35, TC36 --> this is called from already working code from DS page
//(Step_DataStructurePage.java file)

//TC37
//When - reused from Tree step definition 
//Given - reused from same test case -> introduction section (TC03) 

@Then("The user should be redirected to try Editor page with a Run button")
public void the_user_should_be_redirected_to_try_editor_page_with_a_run_button() {
	Assert.assertEquals(dsIntro.validatePageTitle(), "Assessment");
}
//TC38 to TC43 ==> ran using reusable code from existing methods .

}