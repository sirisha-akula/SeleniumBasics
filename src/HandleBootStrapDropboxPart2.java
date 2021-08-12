import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBootStrapDropboxPart2 {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000)); //pageload
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));  //for webelements on page to load
		
		driver.get("https://www.delta.com/flight-search/book-a-flight");
//		driver.findElement(By.xpath("//a[@id='fromAirportName']/span[1]")).click();
//		
//		driver.findElement(By.xpath("//input[@id='search_input']")).sendKeys("winnipeg");
//	List<WebElement> fromList = driver.findElements(By.xpath("//div[@class='search-result-container']//child::li"));
//	System.out.println(fromList.size());
//	
//	for(WebElement element : fromList) {
//		System.out.println(element.getText());
//		if(element.getText().contains("Winnipeg")) {
//			element.click();
//		}
//	}
//	
//	driver.findElement(By.id("toAirportName")).click();
//	driver.findElement(By.id("search_input")).sendKeys("chicago");
//	
//	List<WebElement> toList = driver.findElements(By.xpath("//div[@class='search-result-container']//child::li"));
//	System.out.println(toList.size());
//	
//	for(WebElement element : toList) {
//		System.out.println(element.getText());
//		if(element.getText().contains("CHI")) {
//			element.click();
//		}
//	}
//	
	driver.findElement(By.xpath("//span[@id='calDepartLabelCont']/span[2]")).click();
	
	String date = "31/July/2021";
	String date1[]= date.split("/");
	String day = date1[0];
	String month = date1[1];
	String year = date1[2];
	
	String todate = "15/August/2021";
	String todate1[]= date.split("/");
	String today = date1[0];
	String tomonth = date1[1];
	String toyear = date1[2];
	
	
	
	// calendar xpath: //div[@class='dl-datepicker-group dl-datepicker-group-0']/div[2]/table/tbody/tr[4]/td[7]

	selectFromDate(day);
	selectToDate(today);
	
	
	
	//driver.quit();
	}
	
	public static void selectFromDate(String day1) {	
	    int totalWeekDays = 7;
		boolean flag = false;
		String dayVal;
		
		String before_xpath = "//div[@class='dl-datepicker-group dl-datepicker-group-0']/div[2]/table/tbody/tr[";
		String after_xpath = "]/td[";
		
		for(int row = 2; row<=6; row++) {
			
			for(int col=1; col<=totalWeekDays; col++) {
				try {
					dayVal = driver.findElement(By.xpath(before_xpath+row+after_xpath+col+"]")).getText();
				}catch(Exception e) {
					System.out.println("please enter valid date:");
					flag = false;
					break;
				}
				//System.out.println(dayVal);
				if(dayVal.equals(day1)) {
					driver.findElement(By.xpath(before_xpath+row+after_xpath+col+"]")).click();
					flag = true;
					break;

				}
				
			}
			if(flag)
			break;
		
		}
		
	}
		public static void selectToDate(String toDate) {	
		    int totalWeekDays = 7;
			boolean flag = false;
			String dayVal;
			
			String before_xpath = "//div[@class='dl-datepicker-group dl-datepicker-group-0']/div[2]/table/tbody/tr[";
			String after_xpath = "]/td[";
			
			for(int row = 2; row<=6; row++) {
				
				for(int col=1; col<=totalWeekDays; col++) {
					try {
						dayVal = driver.findElement(By.xpath(before_xpath+row+after_xpath+col+"]")).getText();
					}catch(Exception e) {
						System.out.println("please enter valid date:");
						flag = false;
						break;
					}
				//	System.out.println(dayVal);
					if(dayVal.equals(toDate)) {
						driver.findElement(By.xpath(before_xpath+row+after_xpath+col+"]")).click();
						flag = true;
						break;
					}
					
				}
				if(flag)
				break;
			}
		}
}
