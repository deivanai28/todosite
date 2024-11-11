package deivaint.basetest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import deivaint.todos.todoslandingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {
	
	public WebDriver driver;
	public todoslandingpage Todoslandingpage;
	
	public WebDriver initializedriver()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	@BeforeMethod
	public todoslandingpage launchapplication()
	{
		driver = initializedriver();
		Todoslandingpage = new todoslandingpage(driver);
		Todoslandingpage.goTo();
		return Todoslandingpage;
	}

	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
