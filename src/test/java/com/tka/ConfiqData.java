package com.tka;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ConfiqData {
	public static void main(String[] args) throws Exception {
		
		//                            C:\Users\JBK\Desktop\BatchNo268\Advance_Selenium\src\main\resources\confiq.properties
		String path=System.getProperty("user.dir")+"/src/main/resources/confiq.properties";
		System.out.println(path);
         FileInputStream file = new FileInputStream(path);
         
         
         Properties pro= new Properties();
         pro.load(file);
        String brName= pro.getProperty("browser");
        
        WebDriver driver=null;
        if(brName.equalsIgnoreCase("chrome"))
        {
        	 driver= new ChromeDriver();
        }else if(brName.equalsIgnoreCase("firefox"))
        {
        	 driver= new FirefoxDriver();
        }else if(brName.equalsIgnoreCase("ie"))
        {
        	 driver= new InternetExplorerDriver();
        }else
        {
        	System.out.println("Invalid Browser !!!!");
        }
        
           String url= pro.getProperty("url");
           driver.get(url);
           
           driver.findElement(By.id("username")).sendKeys(pro.getProperty("username"));
           driver.findElement(By.id("password")).sendKeys(pro.getProperty("password"));
           driver.findElement(By.id("submit")).click();
	}
}
