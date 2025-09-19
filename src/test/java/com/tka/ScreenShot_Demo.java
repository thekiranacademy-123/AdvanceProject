package com.tka;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenShot_Demo {

	public WebDriver driver;
	@Test
	void testLoginPage() throws Exception {

		String path = System.getProperty("user.dir") + "/src/main/resources/confiq.properties";
		// System.out.println(path);
		FileInputStream file = new FileInputStream(path);

		Properties pro = new Properties();
		pro.load(file);
		String brName = pro.getProperty("browser");

		
		if (brName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (brName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (brName.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Invalid Browser !!!!");
		}

		String url = pro.getProperty("url");
		driver.get(url);

		driver.findElement(By.id("username")).sendKeys(pro.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(pro.getProperty("password"));
		driver.findElement(By.id("submit")).click();

		
	}

}
