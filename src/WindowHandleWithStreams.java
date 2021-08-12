

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleWithStreams {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		
		driver.findElement(By.id("windowButton")).click();
		
		Optional<String> title = switchToWindowTest(driver,"https://demoqa.com/sample");
		System.out.println(title);
		System.out.println("testcase passed");
		driver.quit();
		
	}
	 public static Optional<String> switchToWindowTest(WebDriver driver, String title) {
		 
return driver.getWindowHandles()
		       .stream()
		       		.map(handler ->driver.switchTo().window(handler).getTitle())
		       			.filter(ele ->ele.contains(title))
		       			.findAny();
//		       				.findFirst()
//		       					.orElseThrow(()-> {
//		       						throw new RuntimeException("No Such Window");
//		       });

		 }
		       
		 
	 }
	
	
	
	

	
	
	


