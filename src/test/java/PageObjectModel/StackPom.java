package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverManager.Driver_SetUp;

public class StackPom {

	
public WebDriver driver = Driver_SetUp.getDriver();
	
	By Stack_getStarted = By.xpath("//a[@href='stack']");
	
	
	

public void getStartedStack() throws InterruptedException {
	
	System.out.println("trying to get into Stack page");
	
	driver.findElement(Stack_getStarted).click();

}

}
