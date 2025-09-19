package com.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Myreport {
	
	public static ExtentReports getInstance() {
		
		String path= System.getProperty("user.dir")+"/target/MyReport.html";
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(path);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Testing");
		sparkReporter.config().setReportName("Sanity Test Cases");
		
		ExtentReports reports= new ExtentReports();
		reports.setSystemInfo("Tester Name", "Sourabh");
		reports.setSystemInfo("Envornment", "QA");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Operating system", "Window");
		
		reports.attachReporter(sparkReporter);
		
		return reports;
	}

}
