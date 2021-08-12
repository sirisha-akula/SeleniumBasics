package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
WebDriver driver;


//1 4 7
@BeforeMethod
public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.google.com/");
}
//2
@Test(priority=1,groups="Title",enabled = false)
public void getTitle() {
	String title  = driver.getTitle();
	System.out.println("Title is : " +title);
}
//5
@Test(priority=2,groups="Logos")
public void logoTest() {
	boolean b = driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
	System.out.println("logo is displayed : "+b);
}
//8
@Test(priority=3,groups="Links")
public void gmailLinkTest() {
	boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
	System.out.println("Mail text is displayed : "+b);
}
@Test(priority=4,groups="general")
public void test1() {
	System.out.println("test1");
}

@Test(priority=5,groups="general")
public void test2() {
	System.out.println("test2");
}

@Test(priority=6,groups="general")
public void test3() {
	System.out.println("test3");
}
//3 6 9
@AfterMethod
public void tearDown() {
	driver.quit();
}
}
