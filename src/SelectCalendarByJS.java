

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectCalendarByJS {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //it will maximize window
		driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
	
	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.delta.com/flight-search/book-a-flight/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@id='calDepartLabelCont']/span[2]")).click();
		WebElement date = driver.findElement(By.xpath("//span[@id='calDepartLabelCont']/span[2]"));

		//driver.findElement(By.id("departure")).click();
	//WebElement date= driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]"));
		
	String dateVal = "31/July/2021";
	selectDateByJS(driver,date,dateVal);

	}
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		
	}
}
