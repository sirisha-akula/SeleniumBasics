package Selenium4;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;
public class RelativeLocators {
/*  .below()
 *  .above()
 *  .near()
 *  .toLeftOf()
 *  .toRightof()
 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.walmart.ca/en");
	//WebElement img2 = driver.findElement(RelativeLocator.withTagName("img").toLeftOf(By.id("pid3").below(By.id("pid4"));
		
		
	}

}
