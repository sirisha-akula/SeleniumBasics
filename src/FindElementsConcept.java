import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsConcept {


	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //it will maximize window
		driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
		
		//DynamicWait : it means if page is loaded in 5 seconds, rest 35 seconds will be lapsed.
	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));//it will wait 40 seconds for page to fully load
		
		//it will wait 30 seconds for all webelements on the page to be loaded.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.get("https://www.walmart.ca/en");
		
		//get the link count on the page
		//get text on links
		
		//all the links are represented with <a> tag
	List<WebElement> allLinks = driver.findElements(By.tagName("a")); //with findElements we dont use any click or sendkeys
	   
	//it gives count of all links
	System.out.println(allLinks.size());
	
	/*Foreach loop
	for(WebElement s : allLinks) {
		System.out.println(s.getText());
		
	} */
	
	//forloop
	for(int i = 0; i<allLinks.size();i++) {
		String linkText = allLinks.get(i).getText();
		System.out.println(linkText);
	}
	}

}
