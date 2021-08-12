import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;
/*Automate using Images
 * No API to launch browser and url - need to use selenium
 * can automate flash objects - ex youtube, adobe pdf document
 * Desktop application 
 * we cannot inspect flash objects so we have to do using sikuli by taking screenshot.
 */
public class SikuliTest {

	public static void main(String[] args) throws FindFailed {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/watch?v=B4WmfcjQ9QA&list=PLFGoYjJG_fqoDQHufg7XVk-yb2w6CNpgF");
		
		//create the object of Screen class -sikuli
		Screen s = new Screen();
		
//		//pause icon
		Pattern pauseImg = new Pattern("/Users/sirishaakula/eclipse-workspace/SeleniumBasics/src/YT_Pause.png");
		s.wait(pauseImg,2000);
		s.click();
		s.click();
//		
//		//play icon
//		Pattern playImg =  new Pattern("YT_Play.png");
//		s.wait(playImg, 2000); //wait for object to load
//		s.click();
//		s.click();
		
//		//Settings icon
//				Pattern settingsImg =  new Pattern("YT_Settings.png");
//				s.wait(settingsImg, 2000); //wait for object to load
//				s.click();
//				s.click();
//				
//				//Auto icon
//				Pattern autoImg =  new Pattern("YT_Auto.png");
//				s.wait(autoImg, 2000); //wait for object to load
//				s.click();
//				s.click();
//		
//				//Auto icon
//				Pattern Img144p =  new Pattern("YT_144p.png");
//				s.wait(Img144p, 2000); //wait for object to load
//				s.click();
//				s.click();
				
				
		//driver.quit();
		
		
	}

}
