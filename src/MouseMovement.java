
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sirishaakula/Documents/BrowserDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //it will maxmize window
		driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
		
		
		driver.get("https://book.spicejet.com/Search.aspx?op=3");
		Thread.sleep(5000);
		
		//We use Actions class for mouse movements.
		Actions action = new Actions(driver); 
		
		action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform(); //moveToElement to highlight or focus on element
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Priority Check-in")).click();
		
	}

}
