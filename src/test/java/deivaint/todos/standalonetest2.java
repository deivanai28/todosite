package deivaint.todos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import deivaint.basetest.basetest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class standalonetest2 extends basetest{

	@Test
	public void standtest() {
		
		//insert the record
        Todoslandingpage.inputdetails("test1", "test2", "test3");
        
		//delete the entered record
        Todoslandingpage.deleteitem();
				
		//Edit the record
		Todoslandingpage.editrecord();
		
		//markcompleteditem
		Todoslandingpage.completeditem();
		
		//Verify active,all and completed
		todosverifylinks verifylink = new todosverifylinks(driver);
		System.out.println("Verify All link");
		verifylink.verifyallbutton();
		
		System.out.println("Verify Active link");
		verifylink.verifyactivebtn();
		
		System.out.println("Verify Completed link");
		verifylink.verifycompletebtn();
		
		
		
	}
public static void verifytodolink (WebDriver driver, int value)
{
	List<WebElement> numberofitems = driver.findElements(By.xpath("//li[@data-testid='todo-item']"));	
  if (numberofitems.size()== value)
  {
	System.out.println("PASSED: number of items displayed is" + value);  
  }
}
}
