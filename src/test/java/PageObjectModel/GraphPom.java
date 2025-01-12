package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverManager.Driver_SetUp;

public class GraphPom {
	
public WebDriver driver = Driver_SetUp.getDriver();
	
	By graph_getStarted = By.xpath("//a[@href='graph']");
	By graph_topicsCovered = By.linkText("Graph");
	By graphRepresentations = By.linkText("Graph Representations");
	By graphPractice = By.xpath("//a[@href='/graph/practice']");
    By clickTryhere = By.linkText("Try here>>>");

public void getStartedGraph() throws InterruptedException {
	
	System.out.println("trying to get into Graph page");
	
	driver.findElement(graph_getStarted).click();

}

public void topicsCoveredGraph() throws InterruptedException {
	
	
	
	driver.findElement(graph_topicsCovered).click();

}

public void graphRepresentations() throws InterruptedException {
	
	
	
	driver.findElement(graphRepresentations).click();

}
public void graphPractice() throws InterruptedException {
	
	
	
	driver.findElement(graphPractice).click();

}

public void clickTryhere() throws InterruptedException {
	
	
	
	driver.findElement(clickTryhere).click();
}

}