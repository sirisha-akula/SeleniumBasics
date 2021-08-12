package Praticse;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions1Test {
	
	@Test
	public void actionTest() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		  WebDriver driver = new FirefoxDriver();
		  
		  
		  driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		  Actions action = new Actions(driver);
		  
		  
		 action.contextClick(driver.findElement(By.xpath("//span[contains(text(),'right click me')]"))).build().perform();
		 driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[4]")).click();
		 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.alertIsPresent());
		 
		 Alert alt = driver.switchTo().alert();
		String text =  alt.getText();
		alt.accept();
		Assert.assertEquals(text, "clicked: paste");
//		 
//		 

}}
