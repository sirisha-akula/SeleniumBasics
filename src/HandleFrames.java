import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sirishaakula/Documents/BrowserDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		
		driver.manage().window().maximize();
		
		
		
		driver.switchTo().frame("a077aa5e");
		Thread.sleep(10000);
		driver.findElement(By.xpath("html/body/a/img")).click();
		
		//Until you are in frames you can not perform any operation so once we are don with frame then switchTo parent window

		//driver.switchTo().defaultContent(); (or)
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
		
	}

}
