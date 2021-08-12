package Praticse;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {


	@Test
	public void alertsTest() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		  WebDriver driver = new FirefoxDriver();
		  
		  
		   driver.manage().window().maximize(); //it will maximize window
			driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
		
		
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.get("https://classic.crmpro.com/index.html");
			driver.findElement(By.xpath("//input[@type= 'text']")).sendKeys("sirishaak");
			driver.findElement(By.xpath("//input[@type= 'password']")).sendKeys("arjuntest@123");
			
			driver.switchTo().frame("mainpanel");
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			
			List<WebElement> row =	driver.findElements(By.xpath("//form[@id='vContactsForm']/table/tbody/tr"));

			List<WebElement> col =	row.get(1).findElements(By.xpath("//form[@id='vContactsForm']/table/tbody/tr[3]/td"));
			
			System.out.println("rows are: "+ row.size());
			
			System.out.println("cols are: "+ col.size());
			
			////form[@id='vContactsForm']/table/tbody/tr[4]/td[2]
			String before_xpath ="//form[@id='vContactsForm']/table/tbody/tr[";
			String after_xpath ="]/td[2]";
			
			for(int i= 4; i<row.size(); i++) {
				String text = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
				String text1 = text.trim();
				if(text1.contains("ram")) {
					Assert.assertEquals(text1, "ram akula");
				}
			
}}
}
