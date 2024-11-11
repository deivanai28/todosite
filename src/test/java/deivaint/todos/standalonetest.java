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
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class standalonetest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://todomvc.com/examples/react/dist/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		
		todoslandingpage Todoslandingpage = new todoslandingpage(driver);
		//insert the record
		driver.findElement(By.id("todo-input")).sendKeys("test1" + "\n");
		driver.findElement(By.id("todo-input")).sendKeys("test2" + "\n");
		driver.findElement(By.id("todo-input")).sendKeys("test3" + "\n");
		
		//delete the entered record
		driver.findElement(By.xpath("//li[1]//div[1]")).click();
		WebElement deletebutton = driver.findElement(By.xpath("//li[1]//div[1]/button"));
		deletebutton.click();
		
		
		
		//Edit the record
		WebElement editelem = driver.findElement(By.xpath("//label[text()='test2']"));
		actions.doubleClick(editelem).sendKeys("editedtester").keyDown(Keys.ENTER).build().perform();
		

		//markcompleteditem
		WebElement completeditem = driver.findElement(By.xpath("//input[@class='toggle']"));
		completeditem.click();
		
		//Verify active,all and completed
		System.out.println("Verify All link");
		driver.findElement(By.linkText("All")).click();
		verifytodolink(driver,2);
		
		System.out.println("Verify Active link");
		driver.findElement(By.linkText("Active")).click();
		verifytodolink(driver,1);
		
		System.out.println("Verify Completed link");
		driver.findElement(By.linkText("Completed")).click();
		verifytodolink(driver,1);
		
		
		driver.close();
		
		

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
