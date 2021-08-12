import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
/*HTMLUnit vs HtmlUnitDriver
 * HtmlUnit is seperate, developed by othere community where as HtmlUnitDriver developed by SeleniumHQ community.
 * but HtmlUnitDriver internally uses HtmlUnit
 *he fast and light weight implementataion of webdriver.
 * it also supports javascript
 * */

public class htmlunittest {

	public static void main(String[] args) throws InterruptedException {
	
		//WebDriver driver = new HtmlUnitDriver(); -->javascript disabled
		//WebDriver driver = new HtmlUnitDriver(true); // javascript enabled true
		
		WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME, true); //specific browser with javascript enabled 
		//it supports different browser like crome, firefox, edge, ie. it does not support safari and opera.
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
//		
		driver.findElement(By.name("q")).sendKeys("Winnipeg");
		driver.findElement(By.name("btnK")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

}
