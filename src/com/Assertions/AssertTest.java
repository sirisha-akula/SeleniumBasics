package com.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertTest {
SoftAssert softAssert = new SoftAssert();
	
//hard assertion -hard validation, if a hard assertion is getting failed -->immediately  testcase will be marked as failed and test case will be terminated.
//soft assertion -soft validation, if a soft assertion is getting failed -->testcase will not be marked as failed as well next lines will be excuted.
//assertAll(): to mark testcase as failed, if any soft assertion is getting failed.


@Test
	public void loginTest() {
	SoftAssert softAssert1 = new SoftAssert();
		System.out.println("Open Browser");
		Assert.assertEquals(true, true); //hard assert
		
		System.out.println("enter username");
		System.out.println("enter password");
		System.out.println("login into app");
		Assert.assertEquals(true, true); //hard assert
		
		System.out.println("validate home page");
		softAssert1.assertEquals(false, true ,"home page title missing"); //soft assertion
		
		System.out.println("Go to Deals page");
		System.out.println("make a deal");
		softAssert1.assertEquals(false, true, "not able to make a deal"); //soft assertion
		
		
		System.out.println("go to contacts page");
		System.out.println("create a contact");
		softAssert1.assertEquals(false, true,"not able to create a deal"); //soft assertion
		
		softAssert1.assertAll();
		
	}

@Test
public void logout() {
	SoftAssert softAssert2 = new SoftAssert();
	
	System.out.println("click on logout button");
	softAssert2.assertEquals(true, false, "not able click on logout btn"); //soft assertion
	
	System.out.println("logged out");
	softAssert2.assertEquals(true, false,"not able to logout"); //soft assertion
	softAssert2.assertAll();
}

@Test
public void tearDown() {
	System.out.println("close browser");
	softAssert.assertAll();
}
}
