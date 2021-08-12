package Praticse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ObjRepTest {
	static WebDriver driver;
	
	@Test
	public void loginTest() throws IOException {
		Properties prop = new Properties();
		FileInputStream fip = new FileInputStream("/Users/sirishaakula/eclipse-workspace/SeleniumBasics/src/practice.properties");
		
		prop.load(fip);
		
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("URL");
		System.out.println(url);
		
	
		if(browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			  WebDriver driver = new FirefoxDriver();
			  
			  driver.manage().window().maximize();
			  driver.manage().deleteAllCookies();
			  
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		      
		}else if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			  WebDriver driver = new ChromeDriver();
			  }
		
		driver.get(prop.getProperty("URL"));
		driver.findElement(By.id(prop.getProperty("email_id"))).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(prop.getProperty("pass_xpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.name("loginbutton_name")).click();
		driver.quit();
		}
		
		
	}


