package Selenium4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindowAndNewTab {

	public static void main(String[] args) {	
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Switch to new tab
		driver.get("https://www.walmart.ca/en");
		
		//driver.switchTo().newWindow(WindowType.TAB);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> handles = driver.getWindowHandles();
		
		 List<String> ls = new ArrayList<String>(handles);  //Set to List Conversion
		
		System.out.println("no of Windows: " +ls.size());
		
		String parentWindowId =  ls.get(0);
		String childWindowId =  ls.get(1);
		 
		System.out.println(parentWindowId);
		System.out.println(childWindowId);
		
		
		driver.get("https://www.amazon.ca/");
		System.out.println(driver.getTitle());
		
		driver.close(); //this will close the new TAB window i.e amazon
		
		//System.out.println(driver.getTitle()); //here we get exception no such window as driver lost control bcoz new tab is closed.
		//so we have to back to first window.
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		driver.quit();
		
		
	}

}
