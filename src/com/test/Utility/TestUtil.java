package com.test.Utility;

import java.util.ArrayList;

import com.excel.utility.xls_Reader;

public class TestUtil {
 static xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		 
		try {
		reader = new xls_Reader("/Users/sirishaakula/eclipse-workspace/SeleniumBasics/src/com/ExcelData/TestData.xlsx");
	}catch(Exception e) {
		e.printStackTrace();
	}
		for(int rowNum = 2; rowNum <= reader.getRowCount("RegData"); rowNum++) {
			
		String fullname =	reader.getCellData("RegData", "fullname", rowNum);
		String email =	reader.getCellData("RegData", "email", rowNum);
		String password =	reader.getCellData("RegData", "password", rowNum);
		String phone =	reader.getCellData("RegData", "phone", rowNum);
		
	//	Object ob[] = new Object[4]; //creating object array
		
		Object ob[] = {fullname, email,password,phone}; //object array
		myData.add(ob); //pass object array into arraylist
					
		}
		
		return myData;
		
}
	}
