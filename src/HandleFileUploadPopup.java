import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopup {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sirishaakula/Documents/BrowserDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://html.com/input-type-file/");
		
		
		//when we have to upload file from our laptop/system, we need to use sendKeys method and give filepath which we want to upload.
		driver.findElement(By.name("fileupload")).sendKeys("/Users/sirishaakula/Documents/SirishaAkula.png"); 
		
	}

}
