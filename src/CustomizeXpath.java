import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CustomizeXpath {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //it will maximize window
		driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
		
		//DynamicWait : it means if page is loaded in 5 seconds, rest 35 seconds will be lapsed.
	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));//it will wait 40 seconds for page to fully load
		
		//it will wait 30 seconds for all webelements on the page to be loaded.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.get("https://www.walmart.ca/en");
		
		//Actions action = new Actions(driver);
	//action.moveToElement(driver.findElement(By.xpath("//a[contains(@id,'departments-button')]"))).build().perform();
		
	//driver.findElement(By.xpath("//input[@class='e1xoeh2i1 css-ymj5ct eesbt950']")).sendKeys("Bicycle");
	
		//Absolute xpath: not recommended
		///html/body/div[2]/div[1]/div/h4[1]/b/html[1]/body[1]/div[2]/div[1]/div[1]/h4[1]/b[1]
		//1. performance issue
		//2. not reliable
		//3. can change at any time in future
		
		//driver.findElement(By.xpath("//input[contains(@class,'e1xoeh2i1 css-ymj5ct eesbt950')]")).sendKeys("Shirts");
		driver.findElement(By.xpath("//a[@href='/en/grocery/N-117']")).sendKeys("Books");
		
		//dynamic id: input
		//id = test_123
		//By.id("test_123")
		
		//starts-with
		//id = test_123
		//id = test_345
		//id = test-789-09
		
		
		//ends-with
		//id = 123_test_t
		//id = 789_test_t
		//id = 445s-99_test_t
		
		//driver.findElement(By.xpath("//input[contians(@id,'test_')]")).sendKeys("Shirts");
		//driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("Shirts");
		//driver.findElement(By.xpath("//input[ends-with(@id,'test_t')]")).sendKeys("Shirts");
		
		//for links: custom-xpath
		//all links are represented with <a> html tag
		driver.findElement(By.xpath("//a[contians(text(),'Rollbacks')]")).click();

	}

}
