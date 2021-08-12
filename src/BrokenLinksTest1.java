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

public class BrokenLinksTest1 {

	@Test
	public void brokenLinks() {
		
		WebDriverManager.firefoxdriver().setup();
		  WebDriver driver = new FirefoxDriver();
		  
		  
		   driver.manage().window().maximize(); //it will maximize window
			driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
		
		
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.get("https://www.walmart.ca/en");
			
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("no. of links are " +Links.size());
		
		
		List<String> urlList = new ArrayList<String>(); //adding all urls into "urllist"
		for(WebElement e : Links) {
			String url = e.getAttribute("href");
			urlList.add(url);
			//checkBrokenLink(url);
			}
		
		long sttime = System.currentTimeMillis();
		//urlList.parallelStream().forEach(e -> checkBrokenLink(e));  //parallel stream total time take: 36.4 secs
		urlList.stream().forEach(e ->checkBrokenLink(e));  //sequential stream: total time taken: 181.7secs-- 3 minutes
		long endtime = System.currentTimeMillis();
		
		System.out.println("total time taken: " + (endtime-sttime));
		driver.quit();
	}

	public static void checkBrokenLink(String linkurl) {
		
		try {
			URL url = new URL(linkurl);
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
		
			if(httpURLConnection.getResponseCode() >= 400) {
				System.out.println(linkurl + " ----> " +  httpURLConnection.getResponseMessage() + " is a broken link");
				
			}else {
				System.out.println(linkurl + " ----> " +  httpURLConnection.getResponseMessage());

			}
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
		
		
		
		
		
		
		
		
	
}
