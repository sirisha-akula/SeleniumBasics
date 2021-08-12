import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {

	
		public static void main(String[] args) throws InterruptedException, IOException {
			System.setProperty("webdriver.chrome.driver", "/Users/sirishaakula/Documents/BrowserDrivers/chromedriver");
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000)); //it is for page load
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000)); //it is for webelements on page to load
			
		
			//for safaridriver we need to install safari driver extension in safari browser and allow Remote automation.
			//WebDriver driver = new SafariDriver();
		
			
			/* 8 locators
			 * ID,name, classname, tagname,linktext, partiallinktext, xpath, css
			 * for frames we can switch through frame(index), frame(name), webelement fname =""; frame(fname)*/
			/*File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileHandler.copy(src, new File("/Users/sirishaakula/eclipse-workspace/SeleniumFirstProject/src/SConcepts/demo.png"));*/
			//no. of rows
			driver.get("https://testuserautomation.github.io/WebTable/");
			
			List<WebElement> row = driver.findElements(By.xpath("html/body/table/tbody/tr"));
			System.out.println(row.size());
			
			List<WebElement> col = driver.findElements(By.xpath("html/body/table/tbody/tr[1]/th"));
			System.out.println(col.size());
			
			String before_xpath ="html/body/table/tbody/tr[";
			String after_xpath ="]/td[";
			boolean flag = false;
			
			for(int i = 2; i<=row.size();i++) {
				for(int j = 1; j<=col.size(); j++) {
				String text = driver.findElement(By.xpath(before_xpath+i+after_xpath+j+"]")).getText();
				System.out.println(text);
				Thread.sleep(2000);
				if(text.contains("Ammy")) {
					driver.findElement(By.xpath("html/body/table/tbody/tr[" +i+ "]/td[1]/input")).click();
					flag = true;
					break;	
				}
				if(flag)	
				break;
				}
			}
			driver.quit();
		

	}

}
