package deivaint.todos;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class todoslandingpage {
	
	WebDriver driver;
	
	public todoslandingpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//pagefactory
	@FindBy(id="todo-input")
	WebElement input1;
	
	@FindBy(id="todo-input")
	WebElement input2;
	
	@FindBy(id="todo-input")
	WebElement input3;
	
	@FindBy(xpath="//li[1]//div[1]")
	WebElement clickaction;
	
	@FindBy(xpath="//li[1]//div[1]/button")
	WebElement deletebutton; 
	
	@FindBy(xpath="//label[text()='test2']")
	WebElement editelem;

	@FindBy(xpath="//input[@class='toggle']")
	WebElement completeditem;
	
	public void goTo()
	{
		driver.get("https://todomvc.com/examples/react/dist/");
	}
	
	public void inputdetails(String item1,String item2, String item3)
	{
		input1.sendKeys(item1 + '\n');
		input2.sendKeys(item2 + '\n');
		input3.sendKeys(item3 + '\n');
	}
	
	public void deleteitem()
	{
		clickaction.click();
		deletebutton.click();
	}
	
	public void editrecord()
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(editelem).sendKeys("editedtester").keyDown(Keys.ENTER).build().perform();
	}
	
	public void completeditem()
	{
		completeditem.click();
	}
	
	
}
