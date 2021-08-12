package com.test;

import org.testng.annotations.Test;

public class TestNGFeatures {

	

	@Test(enabled = true)
	public void login() {
//		int a[] = {1,2,3};
//		System.out.println(a[3]);
		System.out.println("login page");
	}
	
	@Test( dependsOnMethods="login") //here homepage test is depends on login test, if login test fails then homepage test is skipped.
	public void homePage() {
		System.out.println("homePage test");
	}
	
	@Test(dependsOnMethods="login")
	public void searchPage() {
		System.out.println("searchPage test");
	}
	
	@Test(dependsOnMethods="login")
	public void regage() {
		System.out.println("RegistrationPage test");
	}
}
