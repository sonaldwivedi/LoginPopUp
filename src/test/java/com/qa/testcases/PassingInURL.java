package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PassingInURL {

	WebDriver driver;
	String username;
	String password;
	String domain;
	String url;
	
	

	@BeforeTest
	public void setUp() {
		WebDriverManager.edgedriver().setup();
		// Instantiate the webdriver
		driver = new EdgeDriver();
		username = "admin";
		password = "admin";
		domain = "the-internet.herokuapp.com/basic_auth";
	}

	@Test
	public void launch() {
		url = "https://" + username + ":" + password + "@" + domain;
		driver.get(url);
		String text = driver.findElement(By.cssSelector("div.example p")).getText().trim();
		Assert.assertEquals(text, "Congratulations! You must have the proper credentials.");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
