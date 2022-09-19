package com.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoIT {

	WebDriver driver;
	String url;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		// Instantiate the webdriver
		driver = new ChromeDriver();
		url = "http://the-internet.herokuapp.com/basic_auth";
	}

	@Test
	public void launch() throws InterruptedException, IOException {
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Runtime.getRuntime().exec("D:\\Auto IT\\Login.exe");
		Thread.sleep(2000);		
		String text = driver.findElement(By.cssSelector("div.example p")).getText().trim();
		Assert.assertEquals(text, "Congratulations! You must have the proper credentials.");
	}

	@AfterTest
	public void tearDown() {
		 driver.quit();
	}

}
