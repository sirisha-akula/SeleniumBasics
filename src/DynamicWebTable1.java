import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTable1 {

	
		public static void main(String[] args) throws InterruptedException  {
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize(); //it will maximize window
			driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
		
		
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.get("http://demo.guru99.com/test/web-table-element.php");
			Thread.sleep(2000);
			
			
	//fetching total number of rows and columns for handling web table in Selenium:
	//List<WebElement> row= driver.findElements(By.xpath("//div[@id='leftcontainer']/table/tbody/tr"));
	List<WebElement> row = driver.findElements(By.tagName("tr"));
	int rowCount = row.size();
	System.out.println("No. of rows are" + rowCount);

	//List<WebElement> column = driver.findElements(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[1]/td"));
	List<WebElement> column = row.get(1).findElements(By.tagName("td"));
	int colCount = column.size();
	System.out.println("No. of cols are" +colCount);


			
			//div[@id='leftcontainer']/table/tbody/tr[1]/td[3]
			//div[@id='leftcontainer']/table/tbody/tr[2]/td[3]
			//div[@id='leftcontainer']/table/tbody/tr[3]/td[3]
			//div[@id='leftcontainer']/table/tbody/tr[4]/td[3]
			//div[@id='leftcontainer']/table/tbody/tr[5]/td[3]
			
			//Method1 
			String before_xpath = "//div[@id='leftcontainer']/table/tbody/tr[";
			String after_xpath =  "]/td[1]";
			
			for(int i = 1; i<=rowCount; i++) {
			String name =driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
		   if(name.contains("ICICI Pru Life")) {
			   System.out.println(name);
		   }
			
				
			}
			
			//Method 2: CustomXpath
	       // String sharevalue = driver.findElement(By.xpath("//a[contains(text(), 'Sun Pharma.')]/parent::td/following-sibling::td[2]")).getText();
	       // System.out.println(sharevalue);

	}

}
