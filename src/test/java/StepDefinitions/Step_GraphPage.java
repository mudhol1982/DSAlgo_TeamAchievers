package StepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.Driver_SetUp;
import PageObjectModel.GraphPom;
import PageObjectModel.TreePom;
import PageObjectModel.TryEditorPage;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_GraphPage {
	
	
GraphPom graphPage = new GraphPom();
TryEditorPage tryEditor = new TryEditorPage();
	
	public WebDriver driver = Driver_SetUp.getDriver();
	
	
	@Given("the user is in the Home page after signing in")
	public void the_user_is_in_the_home_page_after_signing_in() {
	    // Write code here that turns the phrase above into concrete actions
		

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

           
	   // throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Get Started button in the Graph Panel")
	public void the_user_clicks_the_get_started_button_in_the_graph_panel() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		graphPage.getStartedGraph();
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("the user must be redirected to the Graph data structure page")
	public void the_user_must_be_redirected_to_the_graph_data_structure_page() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	
	//topics covered - link1
	
	@Given("the user is on the Graph page after signing in")
	public void the_user_is_on_the_graph_page_after_signing_in() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Graph link")
	public void the_user_clicks_the_graph_link() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		graphPage.topicsCoveredGraph();
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the topics covered Graph page")
	public void the_user_should_be_redirected_to_the_topics_covered_graph_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
	   // throw new io.cucumber.java.PendingException();
		
		
	}
	
	
	
	//Graph redirect to try here page Scenario
	
		@Given("The user is on the Graph page in the DS Algo portal")
		public void the_user_is_on_the_graph_page_in_the_ds_algo_portal() {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
		}

		@When("The user clicks Try Here button on the Graph page")
		public void the_user_clicks_try_here_button_on_the_graph_page() throws InterruptedException {
		    // Write code here that turns the phrase above into concrete actions
			graphPage.clickTryhere();
			//Thread.sleep(5000);
		    //throw new io.cucumber.java.PendingException();
		}

		@Then("The user is redirected to a page having Editor with run button for Graph")
		public void the_user_is_redirected_to_a_page_having_editor_with_run_button_for_graph() {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
		}
	
		//scenario - Write empty code in try editor
		
		
		@Given("the user is on the tryEditor page of Graph with an empty code editor")
		public void the_user_is_on_the_try_editor_page_of_graph_with_an_empty_code_editor() {
		    // Write code here that turns the phrase above into concrete actions
			
		    //throw new io.cucumber.java.PendingException();
		}

		@When("the user clicks on the Run button without entering any code")
		public void the_user_clicks_on_the_run_button_without_entering_any_code() {
		    // Write code here that turns the phrase above into concrete actions
			tryEditor.clickRunButton();
		   // throw new io.cucumber.java.PendingException();
		}

		@Then("nothing happens and no error message is displayed")
		public void nothing_happens_and_no_error_message_is_displayed() {
		    // Write code here that turns the phrase above into concrete actions
			
			 boolean isOutputDisplayed = tryEditor.isConsoleOutputDisplayed();
			 
			 assertFalse(isOutputDisplayed, "Console output is not displayed");
         }

		//scenario - Write invalid code in try editor
		
		@When("the user writes invalid Python code in the editor and clicks the Run button")
		public void the_user_writes_invalid_python_code_in_the_editor_and_clicks_the_run_button() throws IOException, InterruptedException {
		    // Write code here that turns the phrase above into concrete actions
			System.out.println("testcase when");
			tryEditor.testInvalidCodeExecution();
		
			
	    }
		    //throw new io.cucumber.java.PendingException();
		

		@Then("the user should see an error message in an alert window")
		public void the_user_should_see_an_error_message_in_an_alert_window() throws IOException, InterruptedException {
		    // Write code here that turns the phrase above into concrete actions
			
			
			System.out.println("testcase then");
			tryEditor.testInvalidCodeExecution();
			
		
		
			
		}
		
		//secnario - write valid code in the try editor
		
		@When("the user writes valid Python code in the editor and clicks the Run button")
		public void the_user_writes_valid_python_code_in_the_editor_and_clicks_the_run_button() throws IOException, InterruptedException {
		    // Write code here that turns the phrase above into concrete actions
			tryEditor.testValidCodeExecution();
		   // throw new io.cucumber.java.PendingException();
		}

		@Then("the user should be able to see output in the console")
		public void the_user_should_be_able_to_see_output_in_the_console() {
		    // Write code here that turns the phrase above into concrete actions
			
			boolean isOutputDisplayed = tryEditor.isConsoleOutputDisplayed();
			 
			 assertTrue(isOutputDisplayed, "Console output is displayed");
		    //throw new io.cucumber.java.PendingException();
		}
		
		
	//link-2 Graph Representations
	
	@When("the user clicks the Graph Representationslink")
	public void the_user_clicks_the_graph_representationslink() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		graphPage.graphRepresentations();
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the Graph Representations page")
	public void the_user_should_be_redirected_to_the_graph_representations_page() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	
	
	//link -3 Practice questions
	
	@Given("The user is on the Graph Representations page")
	public void the_user_is_on_the_graph_representations_page() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}

	@When("The user clicks Practice Questions link for Graph")
	public void the_user_clicks_practice_questions_link_for_graph() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		graphPage.graphPractice();
		
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("The user is redirected to Practice Questions page for Graph.")
	public void the_user_is_redirected_to_practice_questions_page_for_graph() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}




	 



}
