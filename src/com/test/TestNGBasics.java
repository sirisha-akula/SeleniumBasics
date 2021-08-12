package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*
	 @BeforeSuite--System setup configuration
	@BeforeTest--launch google browser --1
	@BeforeClass--login to app --2
	
	@BeforeMethod--enter Url --3
	@Test--googleTitleTest 
	@AfterMethod--logout from app 
	
	BeforeMethod--enter Url  
	@Test--logoTest 
	@AfterMethod--logout from app 
	
	@BeforeMethod--enter Url
	@Test--searchTest
	@AfterMethod--logout from app
	
	@AfterClass--deleteAllCookies
	@AfterTest--closeBrowser 
 */
public class TestNGBasics {	
//	pre-condition annotations --starting with @Before
//	@BeforeSuite
//	@BeforeTest
//	@BeforeClass
//	@BeforeMethod
	
	@BeforeSuite  //1
	public void setUp() {
		System.out.println("@BeforeSuite--System setup configuration");
	}
	
	@BeforeTest //2
	public void launchBrowser() {
		System.out.println("@BeforeTest--launch google browser");
	}
	
	@BeforeClass //3
	public void login() {
		System.out.println("@BeforeClass--login to app");
	}
	/*@BeforeMethod--enter Url  these 3 @BeforeMethod,@Test,@AfterMethod will be excuted in pair
	@Test--googleTitleTest
	@AfterMethod--logout from app
	
	@BeforeMethod--enter Url
	@Test--searchTest
	@AfterMethod--logout from app
	
	BeforeMethod--enter Url
	@Test--logoTest
	@AfterMethod--logout from app
	 */
	
	@BeforeMethod //4
	public void enterUrl() {
		System.out.println("@BeforeMethod--enter Url");
	}
	
	//tescase -- starting with @Test
	@Test //5
	public void googleTitleTest() {
		System.out.println("@Test--googleTitleTest");
	}

	@Test 
	public void searchTest() {
		System.out.println("@Test--searchTest");
	}
	
	@Test 
	public void logoTest() {
		System.out.println("@Test--logoTest");
	}
//	post-condition annotations --starting with @After
	@AfterMethod //6
	public void logout() {
		System.out.println("@AfterMethod--logout from app");
	}
	
	@AfterClass //7
	public void deleteAllCookies() {
		System.out.println("@AfterClass--deleteAllCookies");
	}
	
	@AfterTest //8
	public void closeBrowser() {
		System.out.println("@AfterTest--closeBrowser");
	}

//	@AfterSuite 
//	public void generateTestReport() {
//		System.out.println("AfterSuite--generateTestReport");
//	}
}
