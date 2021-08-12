package com.TestNGListener;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//there are two ways of providing listners class one is write"@Listeners(CustomListener.class)" above class 
//other one is providing listners in testng.xml file

@Listeners(CustomListener.class)
public class ScreenshotTest extends Base {

	
	@BeforeMethod
	public void setUp() {
		intilization();
	}
	
	
	@Test
	public void loginTest() {
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void homePageTest() {
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void contactpageTest() {
		Assert.assertEquals(false, true);
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
//				<listener class-name = "com.TestNGListener.CustomListener"/>
//		</listeners>
//
//  <test name="RetryFailedTestCases">
//
//<classes>
//       <class name="com.TestNGListener.ScreenshotTest"/>
//     
//    </classes>
//     
//  </test> <!-- Test -->
//</suite> <!-- Suite -->
