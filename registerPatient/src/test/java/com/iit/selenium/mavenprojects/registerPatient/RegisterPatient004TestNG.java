package com.iit.selenium.mavenprojects.registerPatient;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RegisterPatient004TestNG {
	
  @BeforeTest
  public void beforeTest() throws InterruptedException {
		  
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				String mmpUrl = "http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/";
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\hidayah\\eclipse-workspace\\registerPatient\\src\\test\\java\\com\\iit\\selenium\\mavenprojects\\registerPatient\\chromedriver.exe");
				driver.get(mmpUrl);
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				Thread.sleep(3000);
				String verifyPage = driver.getCurrentUrl();
				try {
					Assert.assertEquals(verifyPage, mmpUrl);
					System.out.println("The page was successfully opened");
				} catch (AssertionError e) {
					e.printStackTrace();
					System.out.println("The page was not successfully opened");
				}
				
				WebElement patientLogin = driver.findElement(By.xpath("//a[contains(text(),'Patient Login')]"));
				patientLogin.click();
				
				Thread.sleep(3000);
				WebElement registerButton = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
				registerButton.click();
	  }
  @Test
  public void f() throws InterruptedException {
	  
	 
	  try {
		   HashMapRegisterPatient hashMap = new HashMapRegisterPatient();
		   HashMap<String,String> registrationInfo = hashMap.registerPatient();
		   System.out.println(registrationInfo);
		  	  
		   System.out.println("Account successfully created");
	} catch (Exception b) {
			System.out.println("Account was not successfully created");
	}
  }
  
 
  @AfterTest
  public void afterTest() throws InterruptedException {
			System.out.println("The webpage will be closed now");
			Thread.sleep(5000);
			
  }
}
