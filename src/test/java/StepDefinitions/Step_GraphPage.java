package StepDefinitions;

import static org.testng.Assert.assertFalse;
import org.testng.Assert;
import org.testng.annotations.Parameters;

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
import org.picocontainer.annotations.Inject;

import DriverManager.Driver_SetUp;
import PageObjectModel.DataStructureIntroPom;
import PageObjectModel.GraphPom;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.LoginPom;
import PageObjectModel.RegisterPom;
import PageObjectModel.TryEditorPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_GraphPage {
	
	public static WebDriver driver ;
GraphPom graphPage = new GraphPom();
TryEditorPage tryEditor = new TryEditorPage();
//public HomePom hp = new HomePom(browser);
public LoginPom login = new LoginPom(driver);
public IntroductionPagePom ip = new IntroductionPagePom(driver);
public RegisterPom regPage = new RegisterPom();
public DataStructureIntroPom dsintropage = new DataStructureIntroPom();
HomePom hp;
public Step_GraphPage() {
	 
	}

//	@Before
//    public void setUpGraph() throws Exception {
//        String browser = System.getProperty("browser");  // Default browser is Chrome
//        driver = Driver_SetUp.initializeBrowser(browser);  // Initialize the browser
//        hp = new HomePom(browser);  // Initialize HomePom
//        ip = new IntroductionPagePom(driver);  // Initialize IntroductionPagePom
//    }
	
	
//	
//	@Parameters("browser") // This will receive the browser parameter from TestNG
//	@Before
//	public void setUpGraph(String browser) throws Exception {
//	    driver = Driver_SetUp.initializeBrowser(browser);  // Pass it to Driver_SetUp
//	    hp = new HomePom(browser);  // You can initialize HomePom with browser if needed
//	    ip = new IntroductionPagePom(driver);  // Initialize IntroductionPagePom
//	}


@Before
public void setUpGraph() throws Exception {
    // You can log or handle scenario-specific logic if needed
  
    // Now handle the browser initialization as needed
    String browser = System.getProperty("browser"); 
     driver = Driver_SetUp.getDriver();
    System.out.println(driver+"driver is");
   // driver = Driver_SetUp.initializeBrowser(browser);
    hp = new HomePom(browser);
    ip = new IntroductionPagePom(driver);
}

	//this.driver=Driver_SetUp.getDriver();
	//}

	
	
	
//	@Given("the user is in the Home page after signing in")
//	public void the_user_is_in_the_home_page_after_signing_in() throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
//	    // Write code here that turns the phrase above into concrete actions
//		hp.openURL();
//        hp.ClickHomePageGetStartedButton();
//        ip.clickOnSignInlink();
//        login.enterLoginFormFields("login", 6);
//	     login.clickloginBtn();
//
//	}

	@When("the user clicks the Get Started button in the Graph Panel")
	public void the_user_clicks_the_get_started_button_in_the_graph_panel() throws InterruptedException {
	    
		graphPage.getStartedGraph();
	   
	}

	@Then("the user must be redirected to the Graph data structure page")
	public void the_user_must_be_redirected_to_the_graph_data_structure_page() {

		Assert.assertEquals(ip.getPageTitle(), "Graph");
	    
	}
	//drop down
	
	@Given("the user is in the home page of DS Algo portal after signing in")
	public void the_user_is_in_the_home_page_of_ds_algo_portal_after_signing_in() throws InterruptedException {
	    hp.openHomeURL();
		
	}

	@When("The user selects graph item from the drop down menu")
	public void the_user_selects_graph_item_from_the_drop_down_menu() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ip.clickDropdownToggle();
		ip.clickDropdownItemGraph();
	    
	}

	//topics covered - link1
	
	@Given("the user is on the Graph page after signing in")
	public void the_user_is_on_the_graph_page_after_signing_in() throws InterruptedException {
	    
		hp.openUrlGraph();
	    
	}

	@When("the user clicks the Graph link")
	public void the_user_clicks_the_graph_link() throws InterruptedException {
	    
		graphPage.topicsCoveredGraph();
	  
	}

	@Then("the user should be redirected to the topics covered Graph page")
	public void the_user_should_be_redirected_to_the_topics_covered_graph_page() throws InterruptedException {
	    		
		Assert.assertEquals(ip.getPageTitle(), "Graph");	
	}
		
	//Graph redirect to try here page Scenario
	
		@Given("The user is on the Graph page in the DS Algo portal") //drill down Graph
		public void the_user_is_on_the_graph_page_in_the_ds_algo_portal() {
			Assert.assertEquals(ip.getPageTitle(), "Graph");
		    
		}

		@When("The user clicks Try Here button on the page")
		public void the_user_clicks_try_here_button_on_the_page() throws InterruptedException {
		    
			graphPage.clickTryhere();
			
		    
		}

		@Then("The user is redirected to a page having Editor with run button")
		public void the_user_is_redirected_to_a_page_having_editor_with_run_button() {
			Assert.assertEquals(ip.getPageTitle(), "Assessment");
			Assert.assertTrue(ip.validateElementDisplayed(tryEditor.runButton));
		    
		}
	
		//scenario - Write empty code in try editor
		
		
		@Given("the user is on the tryEditor page of Graph with an empty code editor")
		public void the_user_is_on_the_try_editor_page_of_graph_with_an_empty_code_editor() {
			Assert.assertEquals(ip.getPageTitle(), "Assessment");
			Assert.assertTrue(ip.validateElementDisplayed(tryEditor.runButton));
		}

		@When("the user clicks on the Run button without entering any code")
		public void the_user_clicks_on_the_run_button_without_entering_any_code() {
		    
			tryEditor.clickRunButton();
		   
		}

		@Then("nothing happens and no error message is displayed")
		public void nothing_happens_and_no_error_message_is_displayed() {
		   
			
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
		    
		
		@Then("the user should see an error message in an alert window")
		public void the_user_should_see_an_error_message_in_an_alert_window() throws IOException, InterruptedException {
		 	
			System.out.println("testcase then");
			tryEditor.testInvalidCodeExecution();
			
		}
		
		//secnario - write valid code in the try editor
		
		@When("the user writes valid Python code in the editor and clicks the Run button")
		public void the_user_writes_valid_python_code_in_the_editor_and_clicks_the_run_button() throws IOException, InterruptedException {
		 
			tryEditor.testValidCodeExecution();
		   
		}

		@Then("the user should be able to see output in the console")
		public void the_user_should_be_able_to_see_output_in_the_console() {
		   
			boolean isOutputDisplayed = tryEditor.isConsoleOutputDisplayed();
			 
			 assertTrue(isOutputDisplayed, "Console output is displayed");
		    
		}
		
		
	//link-2 Graph Representations
	
	@When("the user clicks the Graph Representationslink")
	public void the_user_clicks_the_graph_representationslink() throws InterruptedException {
	   
		graphPage.graphRepresentations();
	  
	}

	@Then("the user should be redirected to the Graph Representations page")
	public void the_user_should_be_redirected_to_the_graph_representations_page() {
	    // Write code here that turns the phrase above into concrete actions
		
		String pageTitle = driver.getTitle();
		System.out.println("title is+"+pageTitle);

	    // Validate that the page title contains the expected phrase "Graph Representations"

		Assert.assertTrue(pageTitle.toLowerCase().contains("graph representations".toLowerCase()), 
                "Page title does not contain 'Graph Representations'. Found: " + pageTitle);

	  
	}
	
	// try here for Graph representations
	
	@Given("The user is on the Graph Representations page in the DS Algo portal")
	public void the_user_is_on_the_graph_representations_page_in_the_ds_algo_portal() {
		Assert.assertEquals(ip.getPageTitle(), "Graph Representations");
	    
	}

	//link -3 Practice questions
	
	@Given("The user is on the Graph Representations page")
	public void the_user_is_on_the_graph_representations_page() throws InterruptedException {
	
		hp.openUrlGraph();
		 graphPage.graphRepresentations(); 
	  
	}

	@When("The user clicks Practice Questions link for Graph")
	public void the_user_clicks_practice_questions_link_for_graph() throws InterruptedException {
	    
		graphPage.graphPractice();
		
	}

	@Then("The user is redirected to Practice Questions page for Graph.")
	public void the_user_is_redirected_to_practice_questions_page_for_graph() {
	   
	}

}
