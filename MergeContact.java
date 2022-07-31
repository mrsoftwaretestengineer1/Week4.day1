package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
				//We have to call WDM for the browser driver!!
				WebDriverManager.chromedriver().setup();
				//Launch the browser(chrome)
				ChromeDriver driver=new ChromeDriver();
				//Load the url
				driver.get("http://leaftaps.com/opentaps");
				//Maximize the browser
				driver.manage().window().maximize();
				//implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//inspect user name and send username text
				driver.findElement(By.id("username")).sendKeys("demosalesmanager");
				//inspect password and send password text
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				//click login button
				driver.findElement(By.className("decorativeSubmit")).click();
				//click CRM/SFA
				driver.findElement(By.linkText("CRM/SFA")).click();
				
				//click contacts button
				driver.findElement(By.linkText("Contacts")).click();
				
				// Click on Merge Contacts using Xpath Locator
				driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
				
				//Click on Widget of From Contact
				driver.findElement(By.xpath("//span[text()='From Contact']/following::img[1]")).click();
				Set<String> windowsfrom=driver.getWindowHandles();
				List<String> lstwindowsfrom=new ArrayList<String>(windowsfrom);
				driver.switchTo().window(lstwindowsfrom.get(1));
				
				//Click on First Resulting Contact
				driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]")).click();
				
				//Click on Widget of To Contact
				driver.switchTo().window(lstwindowsfrom.get(0));
				driver.findElement(By.xpath("//span[text()='To Contact']/following::img[1]")).click();
				Set<String> windowsto=driver.getWindowHandles();
				List<String> lstwindowsto=new ArrayList<String>(windowsto);
				driver.switchTo().window(lstwindowsto.get(1));
				
				//Click on Second Resulting Contact
				driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]")).click();
				
				//Click on Merge button using Xpath Locator
				driver.switchTo().window(lstwindowsto.get(0));
				driver.findElement(By.xpath("//a[text()='Merge']")).click();
				
				//Accept the Alert
				Alert alert=driver.switchTo().alert();
				alert.accept();
				
				//Verify the title of the page
				driver.switchTo().window(lstwindowsto.get(0));
				String title=driver.getTitle();
				System.out.println("Page title : "+title);


	}

}