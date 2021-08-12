
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFirstTest {
	
	WebDriver driver;
	public void launchBrowser() {
		
		//chrome browser--install chromedriver
		//FF browser -- install geckodriver & we use setProperty to set geckodriver path.
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.walmart.ca/en");
		String title = driver.getTitle();
		System.out.println(title);
		String exptitle = "Online Shopping Canada Everyday Low Prices at Walmart.ca!";
		
		
		//validation point
		if(title.equals(exptitle)) {
			System.out.println("Correct title");
		}else {
			System.out.println("In-Correct title");
		}
		
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
	}
	
	
	public static void main(String args[]) {
		SeleniumFirstTest obj = new SeleniumFirstTest();
		obj.launchBrowser();
	}
}
