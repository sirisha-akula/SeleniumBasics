package Praticse;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlesTest {

	
	@Test
	public void actionTest() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		  WebDriver driver = new FirefoxDriver();
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			driver.get("https://demoqa.com/browser-windows");
			
		driver.findElement(By.xpath("//button[@id='tabButton']")).click();
		
		
		Thread.sleep(2000);

//		//1. 
//		Set<String> handles = driver.getWindowHandles();
//		List<String> al = new ArrayList<String>(handles);
//	String parentWindow = al.get(0);
//	String childWindow = al.get(1);
//	System.out.println(parentWindow);
//	System.out.println(childWindow);	
//	
//	driver.switchTo().window(parentWindow);
//	System.out.println(driver.getTitle());
	
//	
//	//2. 
//	Set<String> windhandle = driver.getWindowHandles();
//	Iterator<String> it = windhandle.iterator();
//	while(it.hasNext()) {
//		String pWindow =it.next();
//		String cWindow =it.next();
//		driver.switchTo().window(pWindow);
//		System.out.println(driver.getTitle());
//		
//	}
		
		//3.
		String pWin = driver.getWindowHandle();
		
		Set<String> windhandles = driver.getWindowHandles();
		Iterator<String> it1 = windhandles.iterator();
		while(it1.hasNext()) {
			String cWindow =it1.next();
			if(!(cWindow.equals(pWin)))
			{
				driver.switchTo().window(cWindow);
				System.out.println(cWindow);
				   Thread.sleep(2000);
				  WebElement text2 =driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
				   System.out.println(text2.getText());
				
			}
		File src =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("/Users/sirishaakula/eclipse-workspace/SeleniumBasics/Screenshots/header1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		
//		driver.navigate().to("");
//		driver.navigate().forward();
//		driver.navigate().back();
//		driver.navigate().refresh();

		}
	}
}
