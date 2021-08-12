package com.test;

import org.testng.annotations.Test;

public class ExceptionTimeoutTest {

//	@Test(invocationTimeOut=2,expectedExceptions=NumberFormatException.class)
//	public void infinteLoopTest() {
//		int i =1;
//		while(i==1) {
//			System.out.println(i);
//			//i++;
//		}
//	}
	//here we are telling there will be NumberFormatException.class so the testcase will be passed. 
	@Test(expectedExceptions=NumberFormatException.class)
	public void test1() {
		String a = "100A";
		int i = Integer.parseInt(a);
		System.out.println(i);
	}
}
