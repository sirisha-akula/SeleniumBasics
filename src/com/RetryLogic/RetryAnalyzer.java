package com.RetryLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//IRetryAnalyzer = TestNG Listener is used to run failed testcases.
// 1.@Test level
// 2. Runtime


public class RetryAnalyzer implements IRetryAnalyzer {

	int counter  = 0;
	int retryLimit = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		if(counter<retryLimit) {
			counter++;
			return true;
		}
				return false;
			
		}
	}
	
	



