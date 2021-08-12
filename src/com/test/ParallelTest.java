package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTest {
WebDriver driver;
	
	@Test
	public void chromeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Thread id of Chrome is : " +Thread.currentThread().getId());
		driver.get("https://www.walmart.ca/en");
		driver.quit();
			
	}
	
	@Test
	public void firefoxTest() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		System.out.println("Thread id of Firefox is : " +Thread.currentThread().getId());
		driver.get("https://www.walmart.ca/en");
		driver.quit();
			
	}
}


//<?xml version="1.0" encoding="UTF-8"?>
//<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
//
//<suite name="TestNG Automation Suite">	
//
//  <test name="ParallelTestCases" parallel = "methods">
//
//<classes>
//       <class name="com.test.ParallelTest"/>
//     
//    </classes>
//     
//  </test> <!-- Test -->
//</suite> <!-- Suite -->
