package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.TestNGListener.CustomListener;

import io.github.bonigarcia.wdm.WebDriverManager;


public class GoogleRetryTest {

	WebDriver driver;


	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
	}

//	@Test(retryAnalyzer = com.RetryLogic.RetryAnalyzer.class)
	@Test
	public void getTitle() {
		String title  = driver.getTitle();
		Assert.assertEquals("Google1", title);
	}
	
//	@Test(retryAnalyzer = com.RetryLogic.RetryAnalyzer.class)
	@Test
	public void logoTest() {
		boolean b = driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
	Assert.assertFalse(b);
	}
	
	@Test
	public void gmailLinkTest() {
		boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
		Assert.assertTrue(b);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}

//<?xml version="1.0" encoding="UTF-8"?>
//<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
//
//<suite name="TestNG Automation Suite">
//		<listeners>
//				<listener class-name = "com.RetryLogic.MyTransform"/>
//		</listeners>
//
//  <test name="RetryFailedTestCases">
//
//<classes>
//       <class name="com.test.GoogleRetryTest"/>
//     
//    </classes>
//     
//  </test> <!-- Test -->
//</suite> <!-- Suite -->
