package Selenium4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebelementScreenshot {

	public static void main(String[] args) throws IOException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.walmart.ca/en");
		
		WebElement logo = driver.findElement(By.xpath("//div[@class='css-cj07k5 e187axim9']/a/div/div[1]"));
		
		File file = logo.getScreenshotAs(OutputType.FILE);
		
		//FileUtils.copyFile(file, new File("/Users/sirishaakula/eclipse-workspace/SeleniumFirstProject/src/Selenium4/logo.jpeg"));
		
		FileHandler.copy(file, new File("/Users/sirishaakula/eclipse-workspace/SeleniumBasics/src/Selenium4/logo.jpeg"));
	}

}
