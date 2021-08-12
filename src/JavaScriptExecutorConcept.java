

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;



public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //it will maximize window
		driver.manage().deleteAllCookies(); //it will delete all cookies, cache on the browser page.
	
	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://phptravels.org/index.php?rp=/login");
		 
		//Before entering username hightlight username field.
		//WebElement username = driver.findElement(By.name("username"));
		//flash(username , driver);
		
		//driver.findElement(By.name("username")).sendKeys("akulasirisha22@gmail.com");
		//driver.findElement(By.name("password")).sendKeys("Arjun123");
	//	driver.findElement(By.id("login")).click();
		
		WebElement loginbtn = driver.findElement(By.id("login"));
	    //flash(loginbtn , driver);
		
		//drawborder and TakeScreenshot
		//drawBorder(loginbtn,driver);
		//File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(src1, new File("/Users/sirishaakula/eclipse-workspace/SeleniumFirstProject/src/Sconcepts/drawborder.png"));

		//To generate custom alerts using javascriptexecutor
		//generateAlert(driver, "This is JavaScript Custom Alert");
		//Alert alt = driver.switchTo().alert();
		//System.out.println(alt.getText());
		//alt.accept();
		
		//Clicking element using JS
		//clickElementByJs(loginbtn,driver);
		
		//Can refresh browser 2 ways
		//1.by using selenium
		driver.navigate().refresh();
		
		//2.JS Executor
		refreshBrowserByJs(driver);
		
		//to get Title
		System.out.println(getTitleByJs(driver));
		
		//to get Page InnerText
		System.out.println(getPageInnexText(driver));
		
		//to scroll pageDown
		//scrollPageDown(driver);
		
		WebElement footer = driver.findElement(By.xpath("//section[@id='footer']"));
		scrollIntoView(footer,driver);
	}
	
	
	
	//JavaSriptExecutor is a class and we have to cast driver with JavaSriptExecutor--(JavascriptExecutor) driver;
//executeScript--this method used to execute JavaScript
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0",element,driver);
			changeColor("bgcolor",element,driver);	
			
		}
	}
	public  static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
		try {
			Thread.sleep(20);
		}catch(Exception e) {
			
		}
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	}
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" +message+"')"); 
	}
	
	public static void clickElementByJs(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	public static void refreshBrowserByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}
	
	public static String getTitleByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getPageInnexText(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
       String innerText = js.executeScript("return document.documentElement.innerText;").toString();
       return innerText;
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.srollHeight)");
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	
	
}

