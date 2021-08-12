package com.DataProvider;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.Utility.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LambdaRegTest {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://accounts.lambdatest.com/register");
		
	}
	@DataProvider(name = "getTestData")
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider = "getTestData" , priority = 1)
	public void lambdaRegTest(String fullname, String email, String password, String phone) {
		
		//enter data
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys(fullname);
		
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);
		
		driver.findElement(By.id("userpassword")).clear();
		driver.findElement(By.id("userpassword")).sendKeys(password);
		
		driver.findElement(By.name("phone")).clear();
		driver.findElement(By.name("phone")).sendKeys(phone);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
