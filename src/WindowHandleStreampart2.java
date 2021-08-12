

import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleStreampart2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		
		driver.findElement(By.id("windowButton")).click();
		
		Set<String> windows = driver.getWindowHandles();
		                      windows.stream()
		                             .map(x -> driver.switchTo().window(x).getTitle())
		                             .filter(ele ->ele.contains("demoqa.com/sample"))
		                             .collect(Collectors.toList());
		                 windows.forEach(ele -> System.out.println(ele));
		                      
		
	}

}
