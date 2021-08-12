package Selenium4;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeElementScreenshot {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		WebElement userName	 = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement loginBtn = driver.findElement(By.name("login"));
		
		takeElementScreensot(userName, "userNameElement");
		
		takeElementScreensot(password, "passwordElement");
		
		takeElementScreensot(loginBtn, "loginBtnElement");
		
		
		
	}
	
	public static void takeElementScreensot(WebElement element, String fileName) {
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(srcFile, new File("/Users/sirishaakula/eclipse-workspace/SeleniumBasics/src/Selenium4/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
