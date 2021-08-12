package com.RetryLogic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;

public class MyTransform  implements IAnnotationTransformer{
	
	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod ) {
		
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
		
		
	}

}

//
//<?xml version="1.0" encoding="UTF-8"?>
//<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
//
//<suite name="TestNG Automation Suite">
//		<listeners>
//				<listener class-name = "com.RetryLogic.MyTransform"/>
//		</listeners>
//
//  <test name="RetryFailedTestCases">
//
//<classes>
//       <class name="com.test.GoogleRetryTest"/>
//     
//    </classes>
//     
//  </test> <!-- Test -->
//</suite> <!-- Suite -->