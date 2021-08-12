
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitConcept {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //it will maximize window
		driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
		
		//DynamicWait : it means if page is loaded in 5 seconds, rest 35 seconds will be lapsed.
	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));//it will wait 40 seconds for page to fully load
		
		//it will wait 30 seconds for all webelements on the page to be loaded.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.get("https://book.spicejet.com/Search.aspx?op=3");
		
		Actions action = new Actions(driver);
		//WebElement element = driver.findElement(By.id("Login"));
		
		action.moveToElement(driver.findElement(By.id("Login"))).build().perform();
	    action.moveToElement(driver.findElement(By.linkText("SpiceClub Members"))).build().perform();
		
		driver.findElement(By.linkText("Member Login")).click();
		

	}

}
