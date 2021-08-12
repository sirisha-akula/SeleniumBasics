

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWithJava8 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://www.amazon.ca/");
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
//		System.out.println(linkList.size());
		
//		for(WebElement element : linkList) {
//			System.out.println(element.getText());
//		}
		
		//1. Using Lambda
	//linkList.forEach(ele -> System.out.println(ele.getText()));
		
	//2. Using streams and filter
//	List<String> newLinkList = linkList.stream()
//		        .filter(ele ->!ele.getText().equals(""))
//		        .map(ele -> ele.getText())
//		        .collect(Collectors.toList());
//	newLinkList.forEach(System.out::println);
//	
		//3. 
//	String firstText = linkList.stream()
//	.filter(ele -> !ele.getText().equals(""))
//	.findFirst().get().getText();
//	System.out.println(firstText);
//	
	//4. 
//	String findAnyText =linkList.stream().filter(ele ->!ele.getText().equals("")).findAny().get().getText();
//	System.out.println(findAnyText);
	
	
	//5. exclude blank text and which starts with Amazon
	
//	List<String> amazonText = linkList.stream()
//										.filter(ele -> !ele.getText().equals("") && ele.getText().contains("Amazon"))
//										.map(ele ->ele.getText())
//										.collect(Collectors.toList());
//	
//	amazonText.forEach(System.out::println);
	
	//6.
	 
	List<String> newLinkText =	linkList.stream()
		         .filter(ele -> !ele.getText().equals(""))
		         .filter(ele -> !ele.getText().isEmpty())
		         .map(ele -> ele.getText().trim())
		         .collect(Collectors.toList());
	
	newLinkText.forEach(System.out::println);
	
	
	
	
		driver.quit();
	}

}
