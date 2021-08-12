package com.TestNGListener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends Base implements ITestListener {
	
    @Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }	
    
	 @Override		
	    public void onTestFailure(ITestResult result) {					
		 	System.out.println("FAILED TEST");
		 	failed(result.getMethod().getMethodName());
	    }		

	    @Override		
	    public void onTestSkipped(ITestResult result) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

		

}
