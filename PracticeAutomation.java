package testAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeAutomation {
	@Test(priority=1)
	public void positiveLogin()
	{
		
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://practicetestautomation.com/practice-test-login/");
	driver.findElement(By.id("username")).sendKeys("student");
	driver.findElement(By.id("password")).sendKeys("Password123");
	driver.findElement(By.id("submit")).click();
	String currentUrl = driver.getCurrentUrl();
    if (currentUrl.contains("practicetestautomation.com/logged-in-successfully/")) 
     {
         System.out.println("URL verification passed");
     }
    WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log out']"));
    if (logoutButton.isDisplayed()) 
    {
        System.out.println("Logout button is displayed");
    } 
    else 
    {
        System.out.println("Logout button is not displayed");
    }
	}

	
	@Test(dependsOnMethods="positiveLogin",priority=2)
	public void negativeUsername() 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("incorrectUser");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		WebElement errorMessage = driver.findElement(By.id("error"));
		if(errorMessage.isDisplayed())
		{
			System.out.println("Error message is displayed");
			
		}
		else
		{
			System.out.println("Error message is not displayed");	
		}
		
		String errorMessage1 = driver.findElement(By.id("error")).getText();
		System.out.println(errorMessage1.contains("Your username is invalid!"));
			
		}
		
	
	@Test(dependsOnMethods="positiveLogin", priority=3)
	public void negativePassword() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("incorrectPassword");
		driver.findElement(By.id("submit")).click();
		WebElement errorMessage = driver.findElement(By.id("error"));
		if(errorMessage.isDisplayed())
		{
			System.out.println("Error message is displayed");
			
		}
		else
		{
			System.out.println("Error message is not displayed");	
		}
		String errorMessage2 = driver.findElement(By.id("error")).getText();
		System.out.println(errorMessage2.contains("Your password is invalid!"));
		
	}
	

}

