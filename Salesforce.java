package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	1.Launch the browser
		2.Load the url as " https://login.salesforce.com/ "
		3.Enter the username as " ramkumar.ramaiah@testleaf.com "
		4. Enter the password as " Password$123 "
		5.click on the login button
		6.click on the learn more option in the Mobile publisher
		7.Switch to the next window using Windowhandles.
		8.click on the confirm button in the redirecting page
		9.Get the title
		10.Get back to the parent window
		11.close the browser */
		
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		//Load the url
		driver.get("https://login.salesforce.com/");
		//Maximize the browser
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter the username and password,click on login button
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();
		
		//click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		//Switch to the next window using Windowhandle
		Set<String> windows=driver.getWindowHandles();
		List<String> list=new ArrayList<String>(windows);
		driver.switchTo().window(list.get(1));
		
		//click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//Get the title
		System.out.println("Title : "+driver.getTitle());
		
		//Get back to the parent window
		driver.switchTo().window(list.get(0));
		
		//close the browser
		driver.close();
		
	}

}