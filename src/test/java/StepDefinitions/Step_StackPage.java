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
import PageObjectModel.StackPom;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.LoginPom;
import PageObjectModel.RegisterPom;
import PageObjectModel.TryEditorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_StackPage {
	StackPom StackPage = new StackPom();

	
TryEditorPage tryEditor = new TryEditorPage();
public HomePom hp = new HomePom();
public LoginPom login = new LoginPom();
public IntroductionPagePom ip = new IntroductionPagePom();
public RegisterPom regPage = new RegisterPom();
public DataStructureIntroPom dsintropage = new DataStructureIntroPom();

	public WebDriver driver = Driver_SetUp.getDriver();
	
	
	@Given("the user is in the Home page after signing in for Stack")
	public void the_user_is_in_the_home_page_after_signing_in() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		hp.openURL();
        hp.ClickHomePageGetStartedButton();
        ip.clickOnSignInlink();
        login.enterLoginFormFields("login", 6);
	     login.clickloginBtn();
	     
	}
	

	@When("the user clicks the Get Started button in the Stack Panel")
	public void the_user_clicks_the_get_started_button_in_the_Stack_panel() throws InterruptedException {
	    
		StackPage.getStartedStack();
	   
	}

	@Then("the user must be redirected to the Stack data structure page")
	public void the_user_must_be_redirected_to_the_Stack_data_structure_page() {

		Assert.assertEquals(ip.getPageTitle(), "Stack");
	    
	}
	
	@Given("the user is in the home page of DS Algo portal after signing in for Stack")
	public void the_user_is_in_the_home_page_of_ds_algo_portal_after_signing_in() throws InterruptedException {
	    hp.openHomeURL();
		
	}

	@When("The user selects Stack item from the drop down menu")
	
	public void the_user_selects_Stack_item_from_the_drop_down_menu() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ip.clickDropdownToggle();
		ip.clickDropdownItemStack();
	    
	}
	
	//topics covered - link1
	
		@Given("the user is on the Stack page after signing in")
		public void the_user_is_on_the_Stack_page_after_signing_in() throws InterruptedException {
		    
			hp.openUrlStack();
		    
		}

		@When("the user clicks the operations in Stack link")
		public void the_user_clicks_the_Stack_link() throws InterruptedException {
		    
			StackPage.operationsinStack();
		  
		}

		@Then("the user should be redirected to the operations in Stack page")
		public void the_user_should_be_redirected_to_the_operations_Stack_page() throws InterruptedException {
		    		
			Assert.assertEquals(ip.getPageTitle(), "Operations in Stack");	
		}
		
		@Given("The user is on the operations in Stack page in the DS Algo portal") //drill down Stack
		public void the_user_is_on_the_operationsInStack_page_in_the_ds_algo_portal() {
			Assert.assertEquals(ip.getPageTitle(), "Operations in Stack");
		    
		}

		@When("The user clicks Try Here button on the Stack page")
		public void the_user_clicks_try_here_button_on_the_Stackpage() throws InterruptedException {
		    
			StackPage.clickTryhere();
			
		    
		}

		@Then("The user is redirected to a page having Editor with run button of Stack")
		public void the_user_is_redirected_to_a_Stackpage_having_editor_with_run_button() {
			Assert.assertEquals(ip.getPageTitle(), "Assessment");
			Assert.assertTrue(ip.validateElementDisplayed(tryEditor.runButton));
		    
		}
		
		//scenario - Write empty code in try editor
		
		
				@Given("the user is on the tryEditor page of Stack with an empty code editor")
				public void the_user_is_on_the_try_editor_page_of_Stack_with_an_empty_code_editor() {
					Assert.assertEquals(ip.getPageTitle(), "Assessment");
					Assert.assertTrue(ip.validateElementDisplayed(tryEditor.runButton));
				}

				@When("the user clicks on the Run button without entering any code of Stack")
				public void the_user_clicks_on_the_Stack_run_button_without_entering_any_code() {
				    
					tryEditor.clickRunButton();
				   
				}

				@Then("nothing happens and no error message is displayed for Stack")
				public void Stack_nothing_happens_and_no_error_message_is_displayed() {
				   
					
					 boolean isOutputDisplayed = tryEditor.isConsoleOutputDisplayed();
					 
					 assertFalse(isOutputDisplayed, "Console output is not displayed");
		         }

				//scenario - Write invalid code in try editor
				
				@When("the user writes invalid Python code in the editor of Stack and clicks the Run button")
				public void the_user_writes_invalid_python_code_in_the_Stackeditor_and_clicks_the_run_button() throws IOException, InterruptedException {
				    // Write code here that turns the phrase above into concrete actions
					System.out.println("testcase when");
					tryEditor.testInvalidCodeExecution();
				
						    }
				    
				
				@Then("the user should see an error message in an alert window of Stack")
				public void the_user_should_see_an_error_message_in_anStack_alert_window() throws IOException, InterruptedException {
				 	
					System.out.println("testcase then");
					tryEditor.testInvalidCodeExecution();
					
				}
				
				//secnario - write valid code in the try editor
				
				@When("the user writes valid Python code for Stack in the editor and clicks the Run button")
				public void the_user_writes_valid_python_code_in_the_editorSatck_and_clicks_the_run_button() throws IOException, InterruptedException {
				 
					tryEditor.testValidCodeExecution();
				   
				}

				@Then("the user should be able to see output in the console for Stack")
				public void the_Stackuser_should_be_able_to_see_output_in_the_console() {
				   
					boolean isOutputDisplayed = tryEditor.isConsoleOutputDisplayed();
					 
					 assertTrue(isOutputDisplayed, "Console output is displayed");
				    
				}
				
				@When("the user clicks the  implementations using collections Stack link")
				public void the_user_clicks_the_collectionsStack_link() throws InterruptedException {
					
				//	System.out.println("ddddddddddddd");
					
				//	Thread.sleep(10000);
				
				    
					StackPage.StackRepresent();
				  
				}

				@Then("the user should be redirected to the  implementations using collections in Stack page")
				public void the_user_should_be_redirected_to_the_implementations_Stack_page() throws InterruptedException {
				    		
					Assert.assertEquals(ip.getPageTitle(), "Implementation");	
				}
					
				
				//Stack redirect to try here page Scenario 2

						@Given("The user is on the implementations in Stack page in the DS Algo portal") //drill down Stack
						public void the_user_is_on_the_implenetationsInStack_page_in_the_ds_algo_portal() {
							Assert.assertEquals(ip.getPageTitle(), "Implementation");
						    
						}
						@When("the user clicks the Stack applications link")
						public void the_user_clicks_the_Stackoperations_link() throws InterruptedException {
							
						//	System.out.println("ddddddddddddd");
							
						//	Thread.sleep(10000);
						
						    
							StackPage.StackApplications();
						  
						}

						@Then("the user should be redirected to the Stack applications page")
						public void the_user_should_be_redirected_to_the_Stackoperations_page() throws InterruptedException {
						    		
							Assert.assertEquals(ip.getPageTitle(), "Applications");	
						}
							
						
						//Stack redirect to try here page Scenario 2

								@Given("The user is on the Stack applications page in the DS Algo portal") //drill down Stack
								public void the_user_is_on_the_Stackoperations_page_in_the_ds_algo_portal() {
									Assert.assertEquals(ip.getPageTitle(), "Applications");
								    
								}

								//link -3 Practice questions
								
								@Given("The user is on the Stack opeartions page for practice questions in the DS Algo portal") //drill down Stack
								public void the_user_is_on_the_Stackoperations_practicepage_in_the_ds_algo_portal() throws InterruptedException{
									hp.openUrlStack();
									StackPage.StackApplications();
															    
															}



								@When("The user clicks Practice Questions link for Stack")
								public void the_user_clicks_practice_questions_link_for_Stack() throws InterruptedException {
								    
									StackPage.StackPractice();
									
								}

								@Then("The user is redirected to Practice Questions page for Stack.")
								public void the_user_is_redirected_to_practice_questions_page_for_Stack() {
								   
							System.out.println("end");
								}

	

				

				
}
