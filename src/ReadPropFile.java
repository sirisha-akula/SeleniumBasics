

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadPropFile {
static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Properties prop = new Properties();
		
		FileInputStream ip = new FileInputStream("/Users/sirishaakula/eclipse-workspace/SeleniumBasics/src/config.properties");
		
		prop.load(ip);
		
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		
		String url = prop.getProperty("URL");
		System.out.println(url);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browserName.equals("safari")) {
			 driver = new SafariDriver();
			
		}else if(browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		
	}
	
		System.out.println("driver:" +driver);
	driver.get(prop.getProperty("URL"));
	driver.findElement(By.xpath(prop.getProperty("signin-btn_xpath"))).click();
	Thread.sleep(3000);
	
	
	driver.findElement(By.name(prop.getProperty("firstname_name"))).sendKeys(prop.getProperty("firstname"));
	driver.findElement(By.name(prop.getProperty("lastname_name"))).sendKeys(prop.getProperty("lastname"));
	driver.findElement(By.name(prop.getProperty("mobile-email_name"))).sendKeys(prop.getProperty("mobile"));
	
	Select select = new Select(driver.findElement(By.id(prop.getProperty("month_id"))));
	select.selectByVisibleText(prop.getProperty("month"));
	
	Select select1 = new Select(driver.findElement(By.id(prop.getProperty("day_id"))));
	select1.selectByVisibleText(prop.getProperty("day"));
	
	Select select2 = new Select(driver.findElement(By.id(prop.getProperty("year_id"))));
	select2.selectByVisibleText(prop.getProperty("year"));
	
	driver.findElement(By.xpath(prop.getProperty("submit-btn_xpath"))).click();
	System.out.println("Your TestCase is Passed Hurry");
	driver.quit();

}}
