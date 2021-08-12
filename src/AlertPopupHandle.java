import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopupHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sirishaakula/Documents/Selenium/BrowserDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click(); //click on goto button
		
		Thread.sleep(10000);
		
		Alert alt = driver.switchTo().alert(); //switchTo.alert() methods returns Alert class "alt" object reference.
		
		System.out.println(alt.getText()); //it will return text message on popup.
		
		String text = alt.getText();
		
		//validation point
		if(text.equals("Please enter a valid user name")) {
			System.out.println("correct text msg");
		}else {
			System.out.println("incorrect text msg");
		}
		
		alt.accept();//to click on OK btn
		
		//alt.dismiss();//to click on cancel btn
		
	}

}
