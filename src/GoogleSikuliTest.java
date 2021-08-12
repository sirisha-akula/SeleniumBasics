import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSikuliTest {

	public static void main(String[] args) throws FindFailed {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		//create the object of Screen class -sikuli
				Screen s = new Screen();
				
			//pause icon
			Pattern SearchImg = new Pattern("GoogleSearchbtn.png");
			s.wait(SearchImg,2000);
			s.click();
			
		
	}


}
