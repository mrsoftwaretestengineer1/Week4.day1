package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		//Load the url
		driver.get("http://www.leafground.com/pages/Window.html");
		//Maximize the browser
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click button to open home page in New Window
		driver.findElement(By.id("home")).click();
		Set<String> windows1=driver.getWindowHandles();
		List<String> list1=new ArrayList<String>(windows1);
		
		driver.switchTo().window(list1.get(1));
		driver.close();
		driver.switchTo().window(list1.get(0));
		
		//Find the number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windows2=driver.getWindowHandles();
		List<String> list2=new ArrayList<String>(windows2);
		
		int windowsize=list2.size();
		System.out.println("The number of opened windows : "+windowsize);
		
		//Close all except this window
		driver.findElement(By.id("color")).click();
		Set<String> windows3=driver.getWindowHandles();
		List<String> list3=new ArrayList<String>(windows3);
		
		for(int i=1;i<list3.size();i++)
		{
			driver.switchTo().window(list3.get(i));
			driver.close();
		}
		driver.switchTo().window(list3.get(0));
		
		//Wait for 2 new Windows to open
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(5000);
		Set<String> windows4=driver.getWindowHandles();
		List<String> list4=new ArrayList<String>(windows4);
		
		int windows=list4.size();
		System.out.println("Total window after 5 seconds : "+windows);
		
		driver.quit();
	}

}