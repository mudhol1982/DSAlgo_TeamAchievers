package StepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;  // For TestNG assertions like assertTrue, assertEquals, etc.


import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import DriverManager.Driver_SetUp;
import PageObjectModel.DataStructureIntroPom;
import PageObjectModel.GraphPom;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.LoginPom;
import PageObjectModel.RegisterPom;
import PageObjectModel.TreePom;
import PageObjectModel.TryEditorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_TreePage {
	
	
		TryEditorPage tryEditor = new TryEditorPage();
	public HomePom hp = new HomePom();
	public LoginPom login = new LoginPom();
	public IntroductionPagePom ip = new IntroductionPagePom();
	public RegisterPom regPage = new RegisterPom();
	public DataStructureIntroPom dsintropage = new DataStructureIntroPom();

	
	TreePom treePage = new TreePom();
	
	public WebDriver driver = Driver_SetUp.getDriver();

	
	    
	@Given("the user is in the DS Algo portal after signing in")
	public void the_user_is_in_the_ds_algo_portal_after_signing_in() throws InterruptedException, InvalidFormatException, IOException, OpenXML4JException {
		hp.openURL();
        hp.ClickHomePageGetStartedButton();
        ip.clickOnSignInlink();
        login.enterLoginFormFields("login", 6);
	     login.clickloginBtn();
		
	}

	@When("the user clicks the Get Started button in the Tree panel")
	public void the_user_clicks_the_button_in_the_tree_panel() throws InterruptedException {
		System.out.println("trying tree stepdef");
		treePage.getStartedTree();
	  
	}

	@Then("the user should be redirected to the Tree data structure page")
	public void the_user_should_be_redirected_to_the_data_structure_page() {
	    
		System.out.println("redirected to tree DS");
		
		Assert.assertEquals(ip.getPageTitle(), "Tree");
	}
	  
	// testcase 2  - overview of trees
	@Given("the user is on the Tree page after signing in")
	public void the_user_is_on_the_tree_page_after_signing_in() throws InterruptedException {
		hp.openUrlTree();
	}
	
	@When("the user clicks the Overview of Trees button")
	public void the_user_clicks_the_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete act//driver.findElement(By.xpath("//a[@href='overview-of-trees']"));
		treePage.overviewofTreesLink();
		
	   	}
		
	
	@Then("the user should be redirected to the Overview of Trees data structure page")
	public void the_user_should_be_redirected_to_the_overview_of_trees_data_structure_page() throws InterruptedException {
	    
		String pageTitle = driver.getTitle();
		System.out.println("title is+"+pageTitle);
		Assert.assertTrue(pageTitle.toLowerCase().contains("Overview of Trees".toLowerCase()), 
                "Page title does not contain 'Tree' . Found: " + pageTitle);
  
	}


	//overview of trees - try here
	
	@Given("The user is on the Overview of Trees page in the DS Algo portal")
	public void the_user_is_on_the_overview_of_trees_page_in_the_ds_algo_portal() {
	    
		String pageTitle = driver.getTitle();
		System.out.println("title is+"+pageTitle);
		Assert.assertTrue(pageTitle.toLowerCase().contains("Overview of Trees".toLowerCase()), 
                "Page title does not contain 'Tree' . Found: " + pageTitle);
	}

	@When("The user clicks Try Here button on the  page")
	public void the_user_clicks_try_here_button_on_the_page() {
	  
		treePage.clickTryhere();	    
	}
	
	@Then("The user is redirected to a page having Editor with run button for Tree")
	public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_tree() {
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tryEditor.runButton));
	    
	}
//empty code
	
	@Given("the user is on the tryEditor page of Trees with an empty code editor")
	public void the_user_is_on_the_try_editor_page_of_trees_with_an_empty_code_editor() {
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tryEditor.runButton));
	    
	}

	@When("the user clicks on the Run button without entering any code for Tree")
	public void the_user_clicks_on_the_run_button_without_entering_any_code() {
	    tryEditor.clickRunButton();
	   
	}
	@Then("nothing happens and no error message is displayed for Tree")
	public void nothing_happens_and_no_error_message_is_displayed_for_tree() {
		 boolean isOutputDisplayed = tryEditor.isConsoleOutputDisplayed();
		 
		 assertFalse(isOutputDisplayed, "Console output is displayed");
	}


//invalid code -1
	
	@When("the user writes invalid Python code in the editor and clicks the Run button for Trees")
	public void the_user_writes_invalid_python_code_in_the_editor_and_clicks_the_run_button_for_trees() throws IOException, InterruptedException {
		System.out.println("testcase when");
		tryEditor.testInvalidCodeExecution();
	   
	}

	@Then("the user should see an error message in an alert window for Trees")
	public void the_user_should_see_an_error_message_in_an_alert_window_for_trees() throws IOException, InterruptedException {
		
		System.out.println("testcase then");
		tryEditor.testInvalidCodeExecution();
	    
	}

	
	//valid code
	
	@When("the user writes valid Python code in the editor and clicks the Run button for Trees")
	public void the_user_writes_valid_python_code_in_the_editor_and_clicks_the_run_button_for_trees() throws IOException, InterruptedException {
		tryEditor.testValidCodeExecution();
	}

	@Then("the user should be able to see output in the console for Trees")
	public void the_user_should_be_able_to_see_output_in_the_console_for_trees() {
		boolean isOutputDisplayed = tryEditor.isConsoleOutputDisplayed();
		 
		 assertTrue(isOutputDisplayed, "Console output is not displayed");
	   
	}
			
		//testcase 3 - terminologies
		
			
	@When("the user clicks the Terminologies button")
	public void the_user_clicks_the_Terminologies_button() {
	    
		treePage.terminologiesLink();
	   
	}
	
		@Then("the user should be redirected to the Terminologies data structure page")
		public void the_user_should_be_redirected_to_terminologies_page() {

			Assert.assertEquals(ip.getPageTitle(), "Terminologies");
		}
		
		//try editor - terminologies
		@Given("The user is on the Terminologies page in the DS Algo portal")
		public void the_user_is_on_the_terminologies_page_in_the_ds_algo_portal() {
			Assert.assertEquals(ip.getPageTitle(), "Terminologies");
		}
		
		//testcase -4  Types of Trees
	
	@When("the user clicks the Types of Trees link")
	public void the_user_clicks_the_types_of_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
		treePage.typesofTrees();
		
	}

	@Then("the user should be redirected to the Types of Trees page")
	public void the_user_should_be_redirected_to_the_types_of_trees_page() {
		Assert.assertEquals(ip.getPageTitle(), "Types of Trees");
	}
	
	@Given("The user is on the Types of Trees page in the DS Algo portal")
	public void the_user_is_on_the_types_of_trees_page_in_the_ds_algo_portal() {
		Assert.assertEquals(ip.getPageTitle(), "Types of Trees");
	   
	}

	//testcase-5 - Tree Traversals
	
		
	@When("the user clicks the Tree Traversals link")
	public void the_user_clicks_the_tree_traversals_link() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		treePage.treeTraversals();
			   
	}

	@Then("the user should be redirected to the Tree Traversals page")
	public void the_user_should_be_redirected_to_the_tree_traversals_page() {
		Assert.assertEquals(ip.getPageTitle(), "Tree Traversals");
	    
	}
	
	@Given("The user is on the Tree Traversals page in the DS Algo portal")
	public void the_user_is_on_the_tree_traversals_page_in_the_ds_algo_portal() {
		Assert.assertEquals(ip.getPageTitle(), "Tree Traversals");
	  
	}




		//testcase -6 Traversals Illustration
		
	
	
	@When("the user clicks the Traversals Illustration link")
	public void the_user_clicks_the_traversals_illustration_link() {
	    // Write code here that turns the phrase above into concrete actions
		treePage.traversalsIllustration();
	}

	@Then("the user should be redirected to the Traversals Illustration page")
	public void the_user_should_be_redirected_to_the_traversals_illustration_page() {
		Assert.assertEquals(ip.getPageTitle(), "Traversals-Illustration");
	    
	}
	
	@Given("The user is on the Traversals Illustration page in the DS Algo portal")
	public void the_user_is_on_the_traversals_illustration_page_in_the_ds_algo_portal() {
	    
		Assert.assertEquals(ip.getPageTitle(), "Traversals-Illustration");
	    
	}
	
	
	
	//testcase-7  Binary Trees
	@When("the user clicks the Binary Trees link")
	public void the_user_clicks_the_binary_trees_link() {
	  
		treePage.binaryTrees();
	   
	}

	@Then("the user should be redirected to the Binary Trees page")
	public void the_user_should_be_redirected_to_the_binary_trees_page() {
		Assert.assertEquals(ip.getPageTitle(), "Binary Trees");
	   	}
	
	@Given("The user is on the Binary Trees page in the DS Algo portal")
	public void the_user_is_on_the_binary_trees_page_in_the_ds_algo_portal() {
		Assert.assertEquals(ip.getPageTitle(), "Binary Trees");
	    
	}

	
	//testcase-8 types of binary trees
	
	@When("the user clicks the Types of Binary Trees link")
	public void the_user_clicks_the_types_of_binary_trees_link() {
	    treePage.typesofBinaryTrees();
	   
	}

	@Then("the user should be redirected to the Types of Binary Trees page")
	public void the_user_should_be_redirected_to_the_types_of_binary_trees_page() {
		Assert.assertEquals(ip.getPageTitle(), "Types of Binary Trees");
	}
	
	@Given("The user is on the Types of Binary Trees page in the DS Algo portal")
	public void the_user_is_on_the_types_of_binary_trees_page_in_the_ds_algo_portal() {
		Assert.assertEquals(ip.getPageTitle(), "Types of Binary Trees");
	    
	}
	//testcase-9 implementation in python
	@When("the user clicks the Implementation In Python link")
	public void the_user_clicks_the_implementation_in_python_link() {
	    
		treePage.implementationInPython();
	  
	}

	@Then("the user should be redirected to the Implementation In Python page")
	public void the_user_should_be_redirected_to_the_implementation_in_python_page() {
		Assert.assertEquals(ip.getPageTitle(), "Implementation in Python");
	   
	}
	@Given("The user is on the Implementation in Python page in the DS Algo portal")
	public void the_user_is_on_the_implementation_in_python_page_in_the_ds_algo_portal() {
		Assert.assertEquals(ip.getPageTitle(), "Implementation in Python");
	    
	}

	
	//testcase-10  Binary Tree Traversals
	
	@When("the user clicks the Binary Tree Traversals link")
	public void the_user_clicks_the_binary_tree_traversals_link() {
	    
		treePage.binaryTreeTraversals();
	    
	}

	@Then("the user should be redirected to the Binary Tree Traversals page")
	public void the_user_should_be_redirected_to_the_binary_tree_traversals_page() {
		Assert.assertEquals(ip.getPageTitle(), "Binary Tree Traversals");
	   
	}
	@Given("The user is on the Binary Tree Traversals page in the DS Algo portal")
	public void the_user_is_on_the_binary_tree_traversals_page_in_the_ds_algo_portal() {
		Assert.assertEquals(ip.getPageTitle(), "Binary Tree Traversals");
	}
	
	//testcase-11 Implementation of Binary Trees
	
	@When("the user clicks the Implementation Of Binary Trees link")
	public void the_user_clicks_the_implementation_of_binary_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
		treePage.implementationofBinaryTrees();
		
	}

	@Then("the user should be redirected to the Implementation Of Binary Trees page")
	public void the_user_should_be_redirected_to_the_implementation_of_binary_trees_page() {
		Assert.assertEquals(ip.getPageTitle(), "Implementation of Binary Trees");
	}
	
	
	@Given("The user is on the Implementation of Binary Trees page in the DS Algo portal")
	public void the_user_is_on_the_implementation_of_binary_trees_page_in_the_ds_algo_portal() {
		Assert.assertEquals(ip.getPageTitle(), "Implementation of Binary Trees");
	}
	

	//testcase -12 Applications of Binary Trees
	
	@When("the user clicks the Applications Of Binary Trees link")
	public void the_user_clicks_the_applications_of_binary_trees_link() {
	    treePage.applicationsofBinaryTrees();
	   }

	@Then("the user should be redirected to the Applications Of Binary Trees page")
	public void the_user_should_be_redirected_to_the_applications_of_binary_trees_page() {
		Assert.assertEquals(ip.getPageTitle(), "Applications of Binary trees");
	    
	}
	
	@Given("The user is on the Applications of Binary Trees page in the DS Algo portal")
	public void the_user_is_on_the_applications_of_binary_trees_page_in_the_ds_algo_portal() {
		Assert.assertEquals(ip.getPageTitle(), "Applications of Binary trees");
	}
	//testcase-13  Binary Search Trees
	@When("the user clicks the Binary Search Trees link")
	public void the_user_clicks_the_binary_search_trees_link() {
		treePage.binarySearchTrees();
	}

	@Then("the user should be redirected to the Binary Search Trees page")
	public void the_user_should_be_redirected_to_the_binary_search_trees_page() {
		Assert.assertEquals(ip.getPageTitle(), "Binary Search Trees");
	}
	
	@Given("The user is on the Binary Search Trees page in the DS Algo portal")
	public void the_user_is_on_the_binary_search_trees_page_in_the_ds_algo_portal() {
		Assert.assertEquals(ip.getPageTitle(), "Binary Search Trees");
	}

	//testcase-14 Implementation of BST 

@When("the user clicks the Implementation of Binary Search Trees link")
public void the_user_clicks_the_implementation_of_binary_search_trees_link() {
   treePage.implementationOfbst();   
}

@Then("the user should be redirected to the Implementation of Binary Search Trees page")
public void the_user_should_be_redirected_to_the_implementation_of_binary_search_trees_page() {
	Assert.assertEquals(ip.getPageTitle(), "Implementation Of BST");
}
//testcase -15 -- Practice Questions

@Given("The user is on the Implementation of BST page in the DS Algo portal")
public void the_user_is_on_the_implementation_of_bst_page_in_the_ds_algo_portal() throws InterruptedException {
	
	 hp.openUrlTree();
	 treePage.implementationOfbst(); 
 }

@When("The user clicks Practice Questions link")
public void the_user_clicks_practice_questions_link() {
	treePage.practiceQuestions();
}

@Then("The user is redirected to Practice Questions page.")
public void the_user_is_redirected_to_practice_questions_page() {
	
}}

			
			
	    
		
		
		
		
		
		




