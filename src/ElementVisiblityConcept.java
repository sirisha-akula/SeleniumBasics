import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementVisiblityConcept {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //it will maximize window
		driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
	
	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://phptravels.org/index.php?rp=/login");
		 
		//1.isDisplayed() : it applicable for all webelements
		boolean b1 = driver.findElement(By.id("login")).isDisplayed(); //for login button
		System.out.println(b1); //true
		
		//2.isEnabled() : 
		boolean b2 = driver.findElement(By.id("login")).isEnabled(); //for login button
		System.out.println(b2); //true -- if button is enabled displays true. if button is disabled displays false.
		
		//Select Remember me checkbox
		driver.findElement(By.name("rememberme")).click();
	    boolean b3 = driver.findElement(By.name("rememberme")).isEnabled(); //true
		System.out.println(b3);
		
		//3.isSelected() method only applicable to Radiobuttons, checkbox, dropdowns
	    boolean b4 = driver.findElement(By.name("rememberme")).isSelected(); //true
		System.out.println(b4);
		
		
		//de-select the checkbox
		driver.findElement(By.name("rememberme")).click();
		boolean b5 = driver.findElement(By.name("rememberme")).isSelected(); //false
		System.out.println(b5);
		driver.quit();
	}

}
