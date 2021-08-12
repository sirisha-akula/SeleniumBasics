package com.test;

import org.testng.annotations.Test;

public class InvocationTestCount {
	
@Test(invocationCount =10)
public void test1() {
int a  = 10;
int b = 20;
int c = a+b;
System.out.println("sum is: "+c);
}
}
