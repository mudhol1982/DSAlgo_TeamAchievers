package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverManager.Driver_SetUp;
import PageObjectModel.ArrayPom;
import PageObjectModel.DataStructureIntroPom;
import PageObjectModel.HomePom;
import PageObjectModel.IntroductionPagePom;
import PageObjectModel.TreePom;
import PageObjectModel.TryEditorDsPom;
import Utilities.ExcelReader;
import io.cucumber.java.en.*;

public class Step_ArrayPage {
	
	public WebDriver driver = Driver_SetUp.getDriver();
	ExcelReader excelReader = new ExcelReader();
	
	public DataStructureIntroPom dsIntro = new DataStructureIntroPom();
	public ArrayPom ap = new ArrayPom();
	public IntroductionPagePom ip = new IntroductionPagePom();
	public TryEditorDsPom tp = new TryEditorDsPom();
	public HomePom hp = new HomePom();
	TreePom treePage = new TreePom();

	//TC01
@When("The user clicks the Getting Started button in Array Panel")
public void the_user_clicks_the_getting_started_button_in_array_panel() {
 ap.clickarrayGetStartedBtn();
}

@Then("The user should be redirected to Array page")
public void the_user_should_be_redirected_to_array_page() {
    Assert.assertEquals("Array", dsIntro.validatePageTitle());
}

//TC02
@Given("The user is on the Array page")
public void the_user_is_on_the_array_page() {
	hp.openArray();
}

@When("The user clicks the Arrays in Python link")
public void the_user_clicks_the_arrays_in_python_link() {
   ap.clickarraysInPythonLink();
}

@Then("The user should be redirected to Arrays in Python page")
public void the_user_should_be_redirected_to_arrays_in_python_page() {
	Assert.assertEquals("Arrays in Python", dsIntro.validatePageTitle());
}
//TC03
@Given("The user is in the Arrays in Python page")
public void the_user_is_in_the_arrays_in_python_page() {
	
	hp.openArray();
	ap.clickarraysInPythonLink();

}

@When("The user clicks Try Here button in Arrays in Python page")
public void the_user_clicks_try_here_button_in_arrays_in_python_page() {
   	tp.clickTryHereBtn();
}

//TC04, TC05, TC06 ==> ran through existing methods and step def steps 

//TC07
@When("The user clicks the Arrays Using List link")
public void the_user_clicks_the_arrays_using_list_link() {
  ap.clickarraysUsingListLink();
}

@Then("The user should be redirected to Arrays Using List page")
public void the_user_should_be_redirected_to_arrays_using_list_page() {
	Assert.assertEquals("Arrays Using List", dsIntro.validatePageTitle());
	}

//TC08
@Given("The user is in the Arrays Using List page")
public void the_user_is_in_the_arrays_using_list_page() {
	hp.openArray();
	 ap.clickarraysUsingListLink();
	
}

@When("The user clicks Try Here button in Arrays Using List page")
public void the_user_clicks_try_here_button_in_arrays_using_list_page() {
	tp.clickTryHereBtn();
}


//TC09, TC10,TC11 --> ran through existing methods and step def steps 

//TC12

@When("The user clicks the Basic Operations in Lists link")
public void the_user_clicks_the_basic_operations_in_lists_link() {
ap.clickbasicOperationsInListsLink();
}

@Then("The user should be redirected to Basic Operations in Lists page")
public void the_user_should_be_redirected_to_basic_operations_in_lists_page() {
	Assert.assertEquals("Basic Operations in Lists", dsIntro.validatePageTitle());
}

//TC13


@Given("The user is in the Basic Operations in Lists page")
public void the_user_is_in_the_basic_operations_in_lists_page() {
   hp.openArray();
   ap.clickbasicOperationsInListsLink();
}

@When("The user clicks Try Here button in Basic Operations in Lists page")
public void the_user_clicks_try_here_button_in_basic_operations_in_lists_page() {
	tp.clickTryHereBtn();
}

//TC14 , TC15, TC16 --> ran through existing methods and step def steps

//TC17 
@When("The user clicks the Applications of Array link")
public void the_user_clicks_the_applications_of_array_link() {
	ap.clickapplicationsOfArrayLink();
}

@Then("The user should be redirected to Applications of Array page")
public void the_user_should_be_redirected_to_applications_of_array_page() {
	Assert.assertEquals("Applications of Array", dsIntro.validatePageTitle());
}

//TC18

@Given("The user is in the Applications of Array page")
public void the_user_is_in_the_applications_of_array_page() {
	   hp.openArray();
	   ap.clickapplicationsOfArrayLink();


}
@When("The user clicks Try Here button in Applications of Array page")
public void the_user_clicks_try_here_button_in_applications_of_array_page() {
	tp.clickTryHereBtn();
}

//TC19, TC20, TC21 --> ran through existing methods and step def steps

//Practice Questions page of Array --> Validations 

//TC22
//Given and When -> called from existing methods

@Then("The user should be redirected to page with four Practice Questions of Arrays in Python page")
public void the_user_should_be_redirected_to_page_with_four_practice_questions_of_arrays_in_python_page() {

	Assert.assertEquals(hp.getTextForElement(ap.searchTheArrayLink), "Search the array");
	Assert.assertEquals(hp.getTextForElement(ap.maxConsecutiveOnes), "Max Consecutive Ones");
	Assert.assertEquals(hp.getTextForElement(ap.findNumWithEvenNumOfDigits), "Find Numbers with Even Number of Digits");
	Assert.assertEquals(hp.getTextForElement(ap.squaresOfAsortedArray), "Squares of a Sorted Array");
}

//TC23
	
	@When("The user clicks Search the array page link")
	public void the_user_clicks_search_the_array_page_link() {
	    ap.clickSearchTheArrayLink();
	}
//TC24 , TC25 --> ran through existing methods and step def 
	
	//TC26
	
	@When("The user clicks Max Consecutive Ones link")
	public void the_user_clicks_max_consecutive_ones_link() {
	   ap.clickMaxConsecutiveOnes();
	}
	//TC27 , TC28 --> ran through existing methods and step defs 
	
	//TC29
	@When("The user clicks Find Numbers with Even Number of Digits link")
	public void the_user_clicks_find_numbers_with_even_number_of_digits_link() {
	 ap.clickFindNumWithEvenNumOfDigits();
	}
//TC30 and TC31 ==> ran through existing methods and step def 
	
	//TC32
	
	@When("The user clicks Squares of a Sorted Array link")
	public void the_user_clicks_squares_of_a_sorted_array_link() {
	  ap.clickSquaresOfASortedArray();
	}
}









