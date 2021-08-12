
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class SafariBrowser {

	public static void main(String[] args) {
		
		WebDriver driver = new SafariDriver();
		driver.get("https://www.walmart.com");
		
		//System.setProperty("webdriver.chrome.driver", "/Users/sirishaakula/Documents/BrowserDrivers/chromedriver");
		//WebDriver driver = new ChromeDriver();
		driver.get("https://login.wordpress.org/register?locale=en_US");
		/* find elements is method in webdriver and "By" is class which has methods like id, name etc
		//By.id --1 priority
		driver.findElement(By.id("user_login")).sendKeys("abacd");
		
		//By name --3  priority
		driver.findElement(By.name("user_email")).sendKeys("1232");
		
		//By xpath-- 2 priority. we have to relative xpath, absolute(hierarchy based) xpath is not recommended
		 
		//By cssSelector --3 priority
		if id is there ---#{id}
		if class is there---.{class}
		driver.findElement(By.cssSelector("#wp-submit")).click();
		
		//By classname --4 priority ---not recommended bcoz classname can be duplicate
		driver.findElement(By.className("input").sendKeys("1232");
		
		//By linkText --it is only for links
		driver.findElement(By.linkText("Already have an account?")).click();
		*/
		
		//By partial linkText --it is only for links--not recommended
		driver.findElement(By.partialLinkText("Already")).click();
		
		//how to handle dropbox/ dropdown--->we have to use "Select" class, we need to create object.

		//Select select = new Select(driver.findElement(By.id("language-switcher-locales")));
		//select.selectByValue("af");
		//select.selectByVisibleText("हिन्दी");
	}

}
