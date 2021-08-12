import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new HtmlUnitDriver();
		
		//HtmlUnitDriver is not part of selenium 3 version
		//htmlunitdriver- to use this concept, we need to download htmlunit jar files.
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//advantages:
		//1.testing  is happening behind the scenes-- no browser is launched.
		//2.very fast -- execution of test cases --veryfast --performance of script
		//3.not suitable for Actions class --mouse movements, drag and drop, rightclick
		//4.Ghost driver -- Headless Browser
			//HTMLUnitDriver -- Java
			//Phantomjs -- javascript
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		driver.get("https://www.walmart.ca/en");
//		
//		System.out.println("Home page title" + driver.getTitle());
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//div[@class='css-1kxonj9 e1xoeh2i0']/input")).sendKeys("Book");
//		
//		driver.findElement(By.xpath("//div[@class='css-1kxonj9 e1xoeh2i0']/button")).click();
//		
//		System.out.println("Books page title" + driver.getTitle());
		
		driver.get("https://phptravels.com/demo");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		System.out.println(driver.getTitle());
		
	}

}
