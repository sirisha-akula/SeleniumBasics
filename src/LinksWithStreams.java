

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksWithStreams {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		
		driver.manage().window().maximize();
		driver.get("https://www.freshworks.com/");
		
	//List<WebElement> footerLinks =driver.findElements(By.xpath("//ul[@class='footer-nav']/li"));
	
	List<String> newFooterList = new ArrayList<String>();
	driver.findElements(By.xpath("//ul[@class='footer-nav']/li"))
	.stream()
	.forEach(ele -> newFooterList.add(ele.getText()));
	
	//footerLinks.stream().forEach(ele ->newFooterList.add(ele.getText()));
	newFooterList.forEach(System.out::println);
	
	
	}

}
