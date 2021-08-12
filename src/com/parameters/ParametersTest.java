package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametersTest {
WebDriver driver;
	
@Test
@Parameters({"env","browser","url","username"})
public void phpTravelLogin(String env,String browser,String url, String username) {
	
	if(browser.equals("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}else if(browser.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	driver.get(url);
	
	driver.findElement(By.id("inputEmail")).clear();
	driver.findElement(By.id("inputEmail")).sendKeys(username); //enter username
	driver.findElement(By.id("login")).click(); //click on login button
	driver.quit();
	
	
}
}


//<?xml version="1.0" encoding="UTF-8"?>
//<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
//
//<suite name="TestNG Automation Suite">
//  <test name="TestNG Feature Test">
//
//  <parameter name = "env" value= "QA"/> 
//  <parameter name = "browser" value= "chrome"/> 
//  <parameter name = "url" value= "https://phptravels.org/index.php?rp=/login"/> 
//  <parameter name = "username" value= "akulasirisha22@gmail.com"/>
//
//<classes>
//       <class name="com.parameters.ParametersTest"/>
//     
//    </classes>
//     
//  </test> <!-- Test -->
//</suite> <!-- Suite -->
