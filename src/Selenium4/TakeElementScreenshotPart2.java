package Selenium4;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeElementScreenshotPart2 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		WebElement userName	 = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("passContainer"));
		WebElement loginBtn = driver.findElement(By.name("login"));
		
		takeScreenshot(userName, "userName1");
		takeScreenshot(password, "password1");
		takeScreenshot(loginBtn, "loginBtn1");
		
		driver.quit();
		

	}

	public static void takeScreenshot(WebElement element, String fileName) {
		
		File src =((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("/Users/sirishaakula/eclipse-workspace/SeleniumBasics/src/Selenium4/"+ fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
