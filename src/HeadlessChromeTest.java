import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size-1400,800"); //window size is not provided it takes mobile view.
		options.addArguments("headless");
		
		/*here it directly interacts with google DOM and excute in headless mode.
		 * if we dont provide 'options.addArguments("window-size-1400,800");' it gives element not found exception as some websites are not compatible for mobile version.
		 */
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize(); //it will maximize window
		driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
	
	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.get("https://phptravels.com/demo");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		System.out.println(driver.getTitle());
		
//		driver.findElement(By.name("username")).sendKeys("akulasirisha22@gmail.com");
//		driver.findElement(By.name("password")).sendKeys("Arjun123");
//		
//		driver.findElement(By.xpath("//span[contains(@id,'recaptcha-anchor')]")).click();
//
//		driver.findElement(By.id("login")).click();
//		System.out.println(driver.getTitle());
	}

}
