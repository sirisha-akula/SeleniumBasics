import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarSelectTest {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "/Users/sirishaakula/Documents/BrowserDrivers/chromedriver");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //it will maximize window
		driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
	
	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	
		
		driver.get("https://jqueryui.com/datepicker/#date-range/");
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		
	String date = "17/July/2021";
	String date1[] = date.split("/"); //10,July,2021
	String day = date1[0];
	String month = date1[1];
	String year = date1[2];
	System.out.println(day);
	
	//div[@id='ui-datepicker-div']/table/tbody/tr[1]/td[5]
	//div[@id='////ui-datepicker-div']/table/tbody/tr[1]/td[6]
	//div[@id='ui-datepicker-div']/table/tbody/tr[1]/td[7]
	
	String before_xpath = "//div[@id='ui-datepicker-div']/table/tbody/tr[";
	String after_xpath = "]/td[";

	
	final int totalWeekDays = 7;
	boolean flag = false;
	String dayVal = null;
	
	//iterate:
	//1-1,1-2,1-3,1-4,1-5,1-6,1-7
	//2-1,2-2,2-3,2-4,2-5,2-6,2-7
	
	
	for(int row =1; row<=6; row++) {
		
		for(int col = 1; col<=totalWeekDays; col++) {
		try {
			 dayVal =	driver.findElement(By.xpath(before_xpath+row+after_xpath+col+"]")).getText();
		}catch(NoSuchElementException e) {
			System.out.println("Please enter a valid date:");
			flag = false;
			break;
		}
		    System.out.println(dayVal);
		    if(dayVal.equals(day)) {
			driver.findElement(By.xpath(before_xpath+row+after_xpath+col+"]")).click();
			flag = true;
			break;
		}
		
		}
		if(flag)//if you write just break statement here,it will iterate 1-1,1-2,1-3,1-4,1-5,1-6,1-7 and if didnt find specific datevalue ,it will comeout of inner for loop and there is just a break statement outside, the outer for loop will also exit without selecting the date. So write if(flag) then it will break the loop only when flag is true.
		break;
	}

	}

}
