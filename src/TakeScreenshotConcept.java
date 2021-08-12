import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshotConcept {

public static void main(String[] args) throws IOException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	
	driver.get("https://www.walmart.ca/en");
	
	//Take screenshot and store as a  File format.
	File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(src,new File("/Users/sirishaakula/eclipse-workspace/SeleniumFirstProject/src/walmart.png"));
	
	//FileUtils is not working in latest selenium version, we have to update pom.xml to include commons-io directly instead of getting it transitively through Selenium.
	//ref site: https://www.seleniumeasy.com/selenium-tutorials/take-screenshot-using-FileHandler-class
	FileHandler.copy(src1, new File("/Users/sirishaakula/eclipse-workspace/SeleniumBasics/src/walmart.png"));

}
}