package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Map {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mapz.com/map");
		driver.findElement(By.xpath("//a[@class='show-modal-dialog']")).click();
		WebElement email = driver.findElement(By.name("email"));
		Actions action = new Actions(driver);
	    action.moveToElement(email).perform();
	    email.submit();
        String msg = email.getAttribute("validationMessage");
        System.out.println(msg);

        
	}

	
		
	}


