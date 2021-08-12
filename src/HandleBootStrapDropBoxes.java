import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBootStrapDropBoxes {
	/*If dropdown is being implemented using the <select> HTML tag, we can use the “Select ” class of Selenium WebDriver 
	 */
	
	//Bootstrap/jquery dropdown boxes doesnot contain select tags so, here we cannot use select class to select the values.

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000)); //pageload
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));  //for webelements on page to load
			
			driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
			
		driver.findElement(By.id("dropdownMenuButton")).click(); //button click
	    List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'dropdown')]//child::div[@aria-labelledby='dropdownMenuButton']/a"));
		
	    System.out.println(options.size());
	    
//	    for(int i = 0; i<options.size();i++) {
//	    	System.out.println(options.get(i).getText()); //to get options text
//	    	if(options.get(i).getText().equals("Another action")) {
//	    		options.get(i).click();
//	    		break; //break the loop
//	    	}
//	    }
	//    
	    for(WebElement element :options) {
	    	System.out.println(element.getText());
	    	if(element.getText().equals("Another action")) {
	    		element.click();
	    		
	    	}
	    }
	   // driver.quit();
		}

}
