package StepDefinitions;

import java.sql.DriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.Driver_SetUp;
import PageObjectModel.TreePom;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_TreePage {
	
	TreePom treePage = new TreePom();
	
	public WebDriver driver = Driver_SetUp.getDriver();

	
	    
	@Given("the user is in the DS Algo portal after signing in")
	public void the_user_is_in_the_ds_algo_portal_after_signing_in() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
	//	driver.findElement(By.linkText("Get Started")).click();
		
		driver.findElement(By.xpath("//a[@href='/home']")).click();
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		// Wait for the "Sign in" button to be clickable (visible and enabled)
		WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));

		// Click on the "Sign in" button once it is clickable
		signInButton.click();


		driver.findElement(By.id("id_username")).sendKeys("teamachievers");
		driver.findElement(By.id("id_password")).sendKeys("Welcome@1");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
		System.out.println("finished login");

           
		
		//throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Get Started button in the Tree panel")
	public void the_user_clicks_the_button_in_the_tree_panel() throws InterruptedException {
		System.out.println("trying tree stepdef");
		treePage.getStartedTree();
	   //throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Tree data structure page")
	public void the_user_should_be_redirected_to_the_data_structure_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("redirected to tree DS");
	   // throw new io.cucumber.java.PendingException();
	}
	
	
	// testcase 2  - overview of trees
	@Given("the user is on the Tree page after signing in")
	public void the_user_is_on_the_tree_page_after_signing_in() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://dsportalapp.herokuapp.com/tree/");
		//treePage.getStartedTree();
	    //throw new io.cucumber.java.PendingException();
	}
	
	@When("the user clicks the Overview of Trees button")
	public void the_user_clicks_the_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete act//driver.findElement(By.xpath("//a[@href='overview-of-trees']"));
		
		
	    //throw new io.cucumber.java.PendingException();
	}
		
	
	@Then("the user should be redirected to the Overview of Trees data structure page")
	public void the_user_should_be_redirected_to_the_overview_of_trees_data_structure_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		treePage.overviewofTreesLink();
	    //throw new io.cucumber.java.PendingException();
	}

		
		//testcase 3 - teminologies
		
		


	
	@When("the user clicks the Terminologies button")
	public void the_user_clicks_the_Terminologies_button() {
	    // Write code here that turns the phrase above into concrete actions
		treePage.terminologiesLink();
	   // throw new io.cucumber.java.PendingException();
	}
	
		@Then("the user should be redirected to the Terminologies data structure page")
		public void the_user_should_be_redirected_to_terminologies_page() {

			//Assert.assertEquals(ip.getPageTitle(), "Terminologies");
		}
		
		//testcase -4  Types of Trees
	
		
	
	

	@When("the user clicks the Types of Trees link")
	public void the_user_clicks_the_types_of_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
		treePage.typesofTrees();
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Types of Trees page")
	public void the_user_should_be_redirected_to_the_types_of_trees_page() {
	    // Write code here that turns the phrase above into concrete actions
		
	   // throw new io.cucumber.java.PendingException();
	}
	
	//testcase-5 - Tree Traversals
	
	

	
	@When("the user clicks the Tree Traversals link")
	public void the_user_clicks_the_tree_traversals_link() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		treePage.treeTraversals();
	   // throw new io.cucumber.java.PendingException();
		Thread.sleep(10000);
	}

	@Then("the user should be redirected to the Tree Traversals page")
	public void the_user_should_be_redirected_to_the_tree_traversals_page() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}

		//testcase -6 Traversals Illustration
		
	
	
	@When("the user clicks the Traversals Illustration link")
	public void the_user_clicks_the_traversals_illustration_link() {
	    // Write code here that turns the phrase above into concrete actions
		treePage.traversalsIllustration();
		
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Traversals Illustration page")
	public void the_user_should_be_redirected_to_the_traversals_illustration_page() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	
	//testcase-7  Binary Trees
	@When("the user clicks the Binary Trees link")
	public void the_user_clicks_the_binary_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
		treePage.binaryTrees();
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Binary Trees page")
	public void the_user_should_be_redirected_to_the_binary_trees_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	//testcase-8 types of binary trees
	
	@When("the user clicks the Types of Binary Trees link")
	public void the_user_clicks_the_types_of_binary_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
		treePage.typesofBinaryTrees();
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Types of Binary Trees page")
	public void the_user_should_be_redirected_to_the_types_of_binary_trees_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	//testcase-9 implementation in python
	@When("the user clicks the Implementation In Python link")
	public void the_user_clicks_the_implementation_in_python_link() {
	    // Write code here that turns the phrase above into concrete actions
		treePage.implementationInPython();
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Implementation In Python page")
	public void the_user_should_be_redirected_to_the_implementation_in_python_page() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}

	
	//testcase-10
	
	@When("the user clicks the Binary Tree Traversals link")
	public void the_user_clicks_the_binary_tree_traversals_link() {
	    // Write code here that turns the phrase above into concrete actions
		treePage.binaryTreeTraversals();
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Binary Tree Traversals page")
	public void the_user_should_be_redirected_to_the_binary_tree_traversals_page() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	
	//testcase-11
	
	@When("the user clicks the Implementation Of Binary Trees link")
	public void the_user_clicks_the_implementation_of_binary_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
		treePage.implementationofBinaryTrees();
		
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Implementation Of Binary Trees page")
	public void the_user_should_be_redirected_to_the_implementation_of_binary_trees_page() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	
	//testcase -12
	
	@When("the user clicks the Applications Of Binary Trees link")
	public void the_user_clicks_the_applications_of_binary_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
		treePage.applicationsofBinaryTrees();
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Applications Of Binary Trees page")
	public void the_user_should_be_redirected_to_the_applications_of_binary_trees_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	//testcase-13
	@When("the user clicks the Binary Search Trees link")
	public void the_user_clicks_the_binary_search_trees_link() {
	    // Write code here that turns the phrase above into concrete actions
		treePage.binarySearchTrees();
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Binary Search Trees page")
	public void the_user_should_be_redirected_to_the_binary_search_trees_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	//testcase-14

@When("the user clicks the Implementation of Binary Search Trees link")
public void the_user_clicks_the_implementation_of_binary_search_trees_link() {
    // Write code here that turns the phrase above into concrete actions
	treePage.implementationOfbst();
    //throw new io.cucumber.java.PendingException();
}

@Then("the user should be redirected to the Implementation of Binary Search Trees page")
public void the_user_should_be_redirected_to_the_implementation_of_binary_search_trees_page() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
}

// testcase -15

@Given("The user is on the Implementation Of BST page")
public void the_user_is_on_the_implementation_of_bst_page() {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
}

@When("The user clicks Practice Questions link")
public void the_user_clicks_practice_questions_link() {
    // Write code here that turns the phrase above into concrete actions
	treePage.practiceQuestions();
    //throw new io.cucumber.java.PendingException();
}

@Then("The user is redirected to Practice Questions page.")
public void the_user_is_redirected_to_practice_questions_page() {
    // Write code here that turns the phrase above into concrete actions
  //  throw new io.cucumber.java.PendingException();
}



	}

			
			
	    
		
		
		
		
		
		




