package com.Parallel;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.*;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class ChromeTest {
		public WebDriver driver;
	 
		@BeforeTest
		public void beforeTest() {
			System.out.println("Initilizing the Google Chrome Driver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			 System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());

		}
	 @Test
	 	public void ChromeTestMethod()
	 	{ 

		  //Initialize the chrome driver
		 System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
		  driver.get("https://www.demoqa.com"); 
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
	 
	}
	 
	 @AfterTest
	 public void afterTest() {
		 System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
		 System.out.println("Closing the browser ");
		 driver.close();
	 }

}

	
//	<?xml version="1.0" encoding="UTF-8"?>
//	<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
//
//	<suite name="TestNG Automation Suite">
//
//	  <test name="ParallelTestCases" parallel = "classes" thread-count = "2">
//
//	<classes>
//	       <class name="com.Parallel.ChromeTest"/>
//	       <class name="com.Parallel.FireFoxTest"/>
//	     
//	    </classes>
//	     
//	  </test> <!-- Test -->
//	</suite> <!-- Suite -->