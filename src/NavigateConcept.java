
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sirishaakula/Documents/BrowserDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//driver.get and driver .navigate().to()both methods are used to launch urls but navigate().to() is used to switch to another url.
		
		driver.get("https://www.walmart.ca/en");
		
		driver.navigate().to("https://www.amazon.ca/");
		
		driver.navigate().back();
		
		Thread.sleep(10000);
		
		driver.navigate().forward();
		
		driver.navigate().back();
	}
	

}
