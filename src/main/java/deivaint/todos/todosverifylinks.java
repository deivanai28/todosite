package deivaint.todos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class todosverifylinks {

	WebDriver driver;
	
	public todosverifylinks(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@data-testid='todo-item']")
	List<WebElement> numberofitems;
	
	@FindBy(linkText="All")
	WebElement allbutton;
	
	@FindBy(linkText="Active")
	WebElement activebtn;
	
	@FindBy(linkText="Completed")
	WebElement completebtn;
	
	
	
	public void verifytodolink (WebDriver driver, int value)
	{
			
	  if (numberofitems.size()== value)
	  {
		System.out.println("PASSED: number of items displayed is" + value);  
	  }
	}
	

	public void verifyallbutton()
	{
		allbutton.click();
		verifytodolink(driver,2);
	}
	
	public void verifyactivebtn()
	{
		activebtn.click();
		verifytodolink(driver,1);
	}
	
	public void verifycompletebtn()
	{
		completebtn.click();
		verifytodolink(driver,1);
	}
}
