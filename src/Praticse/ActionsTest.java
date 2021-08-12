package Praticse;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsTest {

	@Test
	public void alertsTest() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		  WebDriver driver = new FirefoxDriver();
		  
		  
		   driver.manage().window().maximize(); //it will maximize window
			driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
		
		
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.get("https://phptravels.com/");
			Actions action = new Actions(driver);
			
//			//to click on webelement
//			action.click(driver.findElement(By.xpath("//a[contains(text(),'Demo')]"))).build().perform();
//			System.out.println(driver.getCurrentUrl());
//			
//			//to doubleclick on webelement
//			action.doubleClick(driver.findElement(By.xpath("//a[contains(text(),'Demo')]"))).build().perform();
//			System.out.println(driver.getCurrentUrl());
			
			//to moveToElement on webelement ie highlights or focus on that particular webelement
			action.moveToElement(driver.findElement(By.xpath("//div[@class='lvl-0 dropdown'][1]"))).build().perform();
			
		

			
		
	}
}
