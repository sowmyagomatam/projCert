package webapp_seleniumtest.phpwebapp_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhpWebsiteTest {
ChromeDriver driver;
	
	@BeforeMethod
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver","/home/edureka/chromedriver.exe");
		ChromeOptions chromoptions = new ChromeOptions();
		chromoptions.addArguments("--headless");
		chromoptions.addArguments("--no-sandbox");
		driver = new ChromeDriver(chromoptions);
		driver.get("http://ec2-18-216-113-254.us-east-2.compute.amazonaws.com:3001/");		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
	}
	
  @Test
  public void verifyAboutLink() {
	  
	// TODO Auto-generated method stub
			
			WebElement aboutLink = driver.findElement(By.id("About Us"));
			aboutLink.click();

			 String test = driver.findElement(By.id("PID-ab2-pg")).getText(); 
			 Assert.assertEquals(test, "This is about page. Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."); 
			                         

  }
  
  @AfterMethod
  public void close()
  {
	  driver.close();
  }
}
