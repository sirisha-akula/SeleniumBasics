import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksTest {
	
	@Test
	public void brokenTest() throws MalformedURLException, IOException {

	  WebDriverManager.firefoxdriver().setup();
	  WebDriver driver = new FirefoxDriver();
	  
	  
	   driver.manage().window().maximize(); //it will maximize window
		driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
	
	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://phptravels.com/");
		
		//links --//a href<http://www.google.com>
		//img --//img href<http://www.test.com>
		
		//1.get list of all links on webpage
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("size of All links: "+linksList.size());
		//linksList.forEach(ele -> System.out.println(ele));
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//2.iterate links : exclude all links/images  - doesnt have any href
		for(int i = 0 ; i<linksList.size();i++) {
			if(linksList.get(i).getAttribute("href") != null && (!linksList.get(i).getAttribute("href").contains("javascript"))){
				activeLinks.add(linksList.get(i));
			}
		}
		System.out.println("size of active link: "+activeLinks.size());
		
		//3.check the href URl with http connection api
		//200 --ok
		//404 --not found
		//500 -- internal error
		//400 -- bad request
		for(int j = 0; j<activeLinks.size(); j++) {
			HttpURLConnection connection =	(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")  +"--->" +response);
			
			
		}	
		
		
}
	
	  
  
}
