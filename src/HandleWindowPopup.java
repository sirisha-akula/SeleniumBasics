
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindowPopup {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://demoqa.com/browser-windows");
		
	driver.findElement(By.xpath("//button[@id='tabButton']")).click();
	
	Thread.sleep(2000);
	 String parentW= driver.getWindowHandle();
	
	Set<String> handles = driver.getWindowHandles();
	
	
    Iterator<String> it	= handles.iterator();
    while(it.hasNext()) {
	String childWindow1=it.next();
	if(!parentW.equalsIgnoreCase(childWindow1)) {
		driver.switchTo().window(childWindow1);
		   Thread.sleep(2000);
		   WebElement text2 =driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		    System.out.println(text2.getText());
		    driver.close();
		    System.out.println("child window1 is closed");
		
	}
}
  
    driver.switchTo().window(parentW);
	driver.findElement(By.xpath("//button[@id='windowButton']")).click();
	Thread.sleep(2000);
	
	Set<String> window2handle = driver.getWindowHandles();
	   Iterator<String> it1	= window2handle.iterator();
	   
	   while(it1.hasNext()) {
		   String childWindow2= it1.next();
		   if(!parentW.equalsIgnoreCase(childWindow2)){
			   driver.switchTo().window(childWindow2);
			   Thread.sleep(2000);
			   WebElement text2 =driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
			    System.out.println(text2.getText());
			    driver.close();
			    System.out.println("child2 window is closed");
		   }
	   }
	   
	    driver.switchTo().window(parentW);
	    
	    driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
		Thread.sleep(2000);
		
		Set<String> window3Handle =driver.getWindowHandles();
		Iterator<String> it2 = window3Handle.iterator();
	
		
		while(it2.hasNext()) {
			String childWindow3 = it2.next();
			if(!parentW.equalsIgnoreCase(childWindow3)) {
				driver.switchTo().window(childWindow3);
				driver.close();
				  System.out.println("child3 window is closed");
			}
		}
		 
		 driver.switchTo().window(parentW);
		 
		 driver.quit();
	
 
	}

}
