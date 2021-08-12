package com.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	
	@DataProvider
	public Object[][] dpMethod(){
		return new Object[][] {{"first-value"},{"secon-value"}};
	}
	
	@Test(dataProvider ="dpMethod")
	public void basics(String val) {
		System.out.println("parameter is passed : " + val);
	}
}

//DataProviders are not declared on top of the functions like TestNG parameters but have a method of their own, 
//which in regular speaking terms called a dataprovider method. For example, dpMethod here.
//If the tester has not specified the name of the dataprovider, then the method name becomes the dataprovider name by default.
//TestNG dataprovider returns a 2d list of objects.
//The method then performs a data-driven test for each value that you have specified.
//The dataprovider name calls the dataprovider method, and if there is no name specified by the tester, then the dataprovider method is the default name used in the receiving @Test case.