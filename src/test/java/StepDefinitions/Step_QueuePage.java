package StepDefinitions;

import static org.testng.Assert.assertFalse;
import org.testng.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.Driver_SetUp;
import PageObjectModel.DataStructureIntroPom;
import PageObjectModel.QueuePom;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.LoginPom;
import PageObjectModel.RegisterPom;
import PageObjectModel.TryEditorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_QueuePage {
	QueuePom QueuePage = new QueuePom();

	
TryEditorPage tryEditor = new TryEditorPage();
public HomePom hp = new HomePom();
public LoginPom login = new LoginPom();
public IntroductionPagePom ip = new IntroductionPagePom();
public RegisterPom regPage = new RegisterPom();
public DataStructureIntroPom dsintropage = new DataStructureIntroPom();

	public WebDriver driver = Driver_SetUp.getDriver();
	
	
	@Given("the user is in the Home page after signing in for Queue")
	public void the_user_is_in_the_home_page_after_signing_in() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		hp.openURL();
        hp.ClickHomePageGetStartedButton();
        ip.clickOnSignInlink();
        login.enterLoginFormFields("login", 6);
	     login.clickloginBtn();

	     
	}

	@When("the user clicks the Get Started button in the Queue Panel")
	public void the_user_clicks_the_get_started_button_in_the_Queue_panel() throws InterruptedException {
	    
		QueuePage.getStartedQueue();
	   
	}

	@Then("the user must be redirected to the Queue data structure page")
	public void the_user_must_be_redirected_to_the_Queue_data_structure_page() {

		Assert.assertEquals(ip.getPageTitle(), "Queue");
	    
	}
	//drop down
	
	 @Given("the user is in the home page of DS Algo portal after signing in for Queue")
	public void the_user_is_in_the_home_page_of_ds_algo_portal_after_signing_in() throws InterruptedException {
	    hp.openHomeURL();
		
	}

	@When("The user selects Queue item from the drop down menu")
	
	public void the_user_selects_Queue_item_from_the_drop_down_menu() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ip.clickDropdownToggle();
		ip.clickDropdownItemQueue();
	    
	}

	//topics covered - link1
	
	@Given("the user is on the Queue page after signing in")
	public void the_user_is_on_the_Queue_page_after_signing_in() throws InterruptedException {
	    
		hp.openUrlQueue();
	    
	}

	@When("the user clicks the operations in Queue link")
	public void the_user_clicks_the_Queue_link() throws InterruptedException {
	    
		QueuePage.operationsinQueue();
	  
	}

	@Then("the user should be redirected to the operations in Queue page")
	public void the_user_should_be_redirected_to_the_operations_Queue_page() throws InterruptedException {
	    		
		Assert.assertEquals(ip.getPageTitle(), "Implementation of Queue in Python");	
	}
		
	//Queue redirect to try here page Scenario

		@Given("The user is on the operations in Queue page in the DS Algo portal") //drill down Queue
		public void the_user_is_on_the_operationsInQueue_page_in_the_ds_algo_portal() {
			Assert.assertEquals(ip.getPageTitle(), "Implementation of Queue in Python");
		    
		}

		@When("The user clicks Try Here button on the Queue page")
		public void the_user_clicks_try_here_button_on_the_Queuepage() throws InterruptedException {
		    
			QueuePage.clickTryhere();
			
		    
		}

		@Then("The user is redirected to a page having Editor with run button of Queue")
		public void the_user_is_redirected_to_a_Queuepage_having_editor_with_run_button() {
			Assert.assertEquals(ip.getPageTitle(), "Assessment");
			Assert.assertTrue(ip.validateElementDisplayed(tryEditor.runButton));
		    
		}
	
		//scenario - Write empty code in try editor
		
		
		@Given("the user is on the tryEditor page of Queue with an empty code editor")
		public void the_user_is_on_the_try_editor_page_of_Queue_with_an_empty_code_editor() {
			Assert.assertEquals(ip.getPageTitle(), "Assessment");
			Assert.assertTrue(ip.validateElementDisplayed(tryEditor.runButton));
		}

		@When("the user clicks on the Run button without entering any code of Queue")
		public void the_user_clicks_on_the_Queue_run_button_without_entering_any_code() {
		    
			tryEditor.clickRunButton();
		   
		}

		@Then("nothing happens and no error message is displayed for Queue")
		public void Queue_nothing_happens_and_no_error_message_is_displayed() {
		   
			
			 boolean isOutputDisplayed = tryEditor.isConsoleOutputDisplayed();
			 
			 assertFalse(isOutputDisplayed, "Console output is not displayed");
         }

		//scenario - Write invalid code in try editor
		
		@When("the user writes invalid Python code in the editor of Queue and clicks the Run button")
		public void the_user_writes_invalid_python_code_in_the_Queueeditor_and_clicks_the_run_button() throws IOException, InterruptedException {
		    // Write code here that turns the phrase above into concrete actions
			System.out.println("testcase when");
			tryEditor.testInvalidCodeExecution();
		
				    }
		    
		
		@Then("the user should see an error message in an alert window of Queue")
		public void the_user_should_see_an_error_message_in_anQueue_alert_window() throws IOException, InterruptedException {
		 	
			System.out.println("testcase then");
			tryEditor.testInvalidCodeExecution();
			
		}
		
		//secnario - write valid code in the try editor
		
		@When("the user writes valid Python code for Queue in the editor and clicks the Run button")
		public void the_user_writes_valid_python_code_in_the_editorSatck_and_clicks_the_run_button() throws IOException, InterruptedException {
		 
			tryEditor.testValidCodeExecution();
		   
		}

		@Then("the user should be able to see output in the console for Queue")
		public void the_Queueuser_should_be_able_to_see_output_in_the_console() {
		   
			boolean isOutputDisplayed = tryEditor.isConsoleOutputDisplayed();
			 
			 assertTrue(isOutputDisplayed, "Console output is displayed");
		    
		}
		

		
	//link-3 Queue array
		

		@When("the user clicks the  implementations using array Queue link")
		public void the_user_clicks_the_arrayQueue_link() throws InterruptedException {
			
		//	System.out.println("ddddddddddddd");
			
		//	Thread.sleep(10000);
		
		    
			QueuePage.queueArray();
		  
		}

		@Then("the user should be redirected to the  implementations using array in Queue page")
		public void the_user_should_be_redirected_to_the_implementationsArray_Queue_page() throws InterruptedException {
		    		
			Assert.assertEquals(ip.getPageTitle(), "Implementation using array");	
		}
			
		
		//Queue redirect to try here page Scenario 3

				@Given("The user is on the implementations in array Queue page in the DS Algo portal") //drill down Queue
				public void the_user_is_on_the_implenetationsInarrayQueue_page_in_the_ds_algo_portal() {
					Assert.assertEquals(ip.getPageTitle(), "Implementation using array");
				    
				}
				//link-2 Queue Representations
				

				@When("the user clicks the  implementations using collections Queue link")
				public void the_user_clicks_the_collectionsQueue_link() throws InterruptedException {
					
				//	System.out.println("ddddddddddddd");
					
				//	Thread.sleep(10000);
				
				    
					QueuePage.queueRepresent();
				  
				}

				@Then("the user should be redirected to the  implementations using collections in Queue page")
				public void the_user_should_be_redirected_to_the_implementations_Queue_page() throws InterruptedException {
				    		
					Assert.assertEquals(ip.getPageTitle(), "Implementation using collections.deque");	
				}
					
				
				//Queue redirect to try here page Scenario 2

						@Given("The user is on the implementations in Queue page in the DS Algo portal") //drill down Queue
						public void the_user_is_on_the_implenetationsInQueue_page_in_the_ds_algo_portal() {
							Assert.assertEquals(ip.getPageTitle(), "Implementation using collections.deque");
						    
						}
						
						//link-3 Queue Representations
						

						@When("the user clicks the Queue operations link")
						public void the_user_clicks_the_Queueoperations_link() throws InterruptedException {
							
						//	System.out.println("ddddddddddddd");
							
						//	Thread.sleep(10000);
						
						    
							QueuePage.queueOperations();
						  
						}

						@Then("the user should be redirected to the Queue operations page")
						public void the_user_should_be_redirected_to_the_Queueoperations_page() throws InterruptedException {
						    		
							Assert.assertEquals(ip.getPageTitle(), "Queue Operations");	
						}
							
						
						//Queue redirect to try here page Scenario 2

								@Given("The user is on the Queue opeartions page in the DS Algo portal") //drill down Queue
								public void the_user_is_on_the_Queueoperations_page_in_the_ds_algo_portal() {
									Assert.assertEquals(ip.getPageTitle(), "Queue Operations");
								    
								}


	


	//link -3 Practice questions
	
	@Given("The user is on the Queue opeartions page for practice questions in the DS Algo portal") //drill down Queue
	public void the_user_is_on_the_Queueoperations_practicepage_in_the_ds_algo_portal() throws InterruptedException{
		hp.openUrlQueue();
		QueuePage.queueOperations();
								    
								}



	@When("The user clicks Practice Questions link for Queue")
	public void the_user_clicks_practice_questions_link_for_Queue() throws InterruptedException {
	    
		QueuePage.QueuePractice();
		
	}

	@Then("The user is redirected to Practice Questions page for Queue.")
	public void the_user_is_redirected_to_practice_questions_page_for_Queue() {
	   
System.out.println("end");
	
	}
}

