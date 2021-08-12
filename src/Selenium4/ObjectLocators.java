package Selenium4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ObjectLocators {

	// to get the object height, width, x and Y coordinates of WebElement.

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.walmart.ca/en");
		
		WebElement logo = driver.findElement(By.xpath("//div[@class='css-cj07k5 e187axim9']/a/div/div[1]"));
		
		System.out.println("Height :" +logo.getRect().getDimension().getHeight());
		System.out.println("Width :" +logo.getRect().getWidth());
		
		System.out.println("X  :" +logo.getRect().getX());
		System.out.println("Y :" +logo.getRect().getY());
		
		driver.quit();

	}

}
