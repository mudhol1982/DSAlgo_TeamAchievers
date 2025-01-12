package PageObjectModel;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.Driver_SetUp;

public class TreePom {
	
	
	public WebDriver driver = Driver_SetUp.getDriver();
	
	By tree_getStarted = By.xpath("//a[@href='tree']");

	// Tree Page general elements

	By overviewofTrees = By.xpath("//a[@href='overview-of-trees']");
	By terminologies = By.linkText("Terminologies");
	By typesofTrees = By.xpath("//a[@href='types-of-trees']");
	By treeTraversals = By.xpath("//a[@href='tree-traversals']");
	By traversalsIllustration = By.xpath("//a[@href='traversals-illustration']");
	By binaryTrees=By.xpath("//a[@href='binary-trees']");
	By typesofBinaryTrees=By.xpath("//a[@href='types-of-binary-trees']");
	By implementationInPython=By.xpath("//a[@href='implementation-in-python']");
	By binaryTreeTraversals=By.xpath("//a[@href='binary-tree-traversals']");
	By implementationofBinaryTrees=By.xpath("//a[@href='implementation-of-binary-trees']");
	By applicationsofBinaryTrees=By.xpath("//a[@href='applications-of-binary-trees']");
	By binarySearchTrees=By.xpath("//a[@href='binary-search-trees']");
	By implementationOfbst=By.xpath("//a[@href='implementation-of-bst']");
	By practiceQuestions = By.linkText("Practice Questions");
	
	public void getStartedTree() throws InterruptedException {
		
		System.out.println("trying to get into tree page");
		
		driver.findElement(tree_getStarted).click();
	
	}
	
	public void overviewofTreesLink() throws InterruptedException {
		System.out.println("trying overview of trees");
		

		// Create WebDriverWait to wait for up to 10 seconds
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    
	    // Wait until the "Overview of Trees" link is clickable
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(overviewofTrees));
	    
	    // Once clickable, click the element
	    element.click();
	    

	    System.out.println("clicked");


	}
	
	public void terminologiesLink() {
		driver.findElement(terminologies).click();
	}
	public void typesofTrees() {
		driver.findElement(typesofTrees).click();
	}
	
	public void treeTraversals() {
		driver.findElement(treeTraversals).click();
	}
	public void traversalsIllustration() {
		driver.findElement(traversalsIllustration).click();
	}
	
	public void binaryTrees() {
		driver.findElement(binaryTrees).click();
	}
	public void typesofBinaryTrees() {
		driver.findElement(typesofBinaryTrees).click();
	}
	public void implementationInPython() {
		driver.findElement(implementationInPython).click();
	}
	public void binaryTreeTraversals() {
		driver.findElement(binaryTreeTraversals).click();
	}
	public void implementationofBinaryTrees() {
		driver.findElement(implementationofBinaryTrees).click();
	}
	public void applicationsofBinaryTrees() {
		driver.findElement(applicationsofBinaryTrees).click();
	}
	public void binarySearchTrees() {
		driver.findElement(binarySearchTrees).click();
	}
	public void implementationOfbst() {
		driver.findElement(implementationOfbst).click();
	}
	public void practiceQuestions() {
		driver.findElement(practiceQuestions).click();
	}
}



