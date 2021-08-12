package Praticse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	@Test
	public void actionTest() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		  WebDriver driver = new FirefoxDriver();
		  
		  
		  driver.get("https://jqueryui.com/droppable/");
		  driver.switchTo().frame(0);
		  Actions action = new Actions(driver);

		  //   1.dragAndDrop method
	      WebElement source = driver.findElement(By.id("draggable"));
		  WebElement target = driver.findElement(By.id("droppable"));
	  
	  action.dragAndDrop(source,target).build().perform();
//		  
//		  //2.using clickAndHold and moveToElement methods
//		  
//		  action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']")))
//		  	    .moveToElement(driver.findElement(By.xpath("//*[@id='droppable']")))
//		  	    .release()
//		  	    .build()
//		  	    .perform();
		  
		  
		  driver.quit();
		  
		  
		  
		  
		  
}
}