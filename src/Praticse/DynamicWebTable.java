package Praticse;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTable {
	@Test
	public void table() throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
				
				driver.manage().window().maximize(); //it will maximize window
				driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
			
			
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				driver.get("https://www.w3schools.com/html/html_tables.asp");
				Thread.sleep(2000);

			List<WebElement> row =	driver.findElements(By.tagName("tr"));

			List<WebElement> col =	row.get(1).findElements(By.tagName("td"));
			
			System.out.println("rows are: "+ row.size());
			
			System.out.println("cols are: "+ col.size());
			driver.quit();
	
			   //table[@id='customers']/tbody/tr[7]/td[2]
			String before_xpath = "//table[@id='customers']/tbody/tr[";
			String after_xpath = "]/td[2]";
			
			for(int i = 2; i<row.size();i++) {
				String text = driver.findElement(By.xpath(before_xpath + i + after_xpath )).getText();
				if(text.equals("Giovanni Rovelli")) {
					System.out.println(text);
				}
			}
			
			
			
}
	
}