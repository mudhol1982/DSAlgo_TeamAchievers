package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverManager.Driver_SetUp;

public class QueuePom {
	
public WebDriver driver = Driver_SetUp.getDriver();
	
	By Queue_getStarted = By.xpath("//a[@href='queue']");
	By OperationsinQueue = By.linkText("Implementation of Queue in Python");
	By QueueRepresentations = By.xpath("//a[@href='Queue-representations']");
	By QueuePractice = By.xpath("//a[@href='/Queue/practice']");
    By clickTryhere = By.linkText("Try here>>>");

public void getStartedQueue() throws InterruptedException {
	
	System.out.println("trying to get into Queue page");
	
	driver.findElement(Queue_getStarted).click();

}

public void operationsinQueue() throws InterruptedException {
	
	
	
	driver.findElement(OperationsinQueue).click();

}

public void QueueRepresentations() throws InterruptedException {
	
	
	
	driver.findElement(QueueRepresentations).click();

}
public void QueuePractice() throws InterruptedException {
	
	
	
	driver.findElement(QueuePractice).click();

}

public void clickTryhere() throws InterruptedException {
	
	
	
	driver.findElement(clickTryhere).click();
}

}