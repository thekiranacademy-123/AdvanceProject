package com.tka;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Report.Myreport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListerner  implements ITestListener{
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		 test= reports.createTest("Execute Test Cases");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case pass "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case failed "+result.getName());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Case Skipped "+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		 reports= Myreport.getInstance();
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	
}
