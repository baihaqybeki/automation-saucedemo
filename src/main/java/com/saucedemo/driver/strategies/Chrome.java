package com.saucedemo.driver.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chrome implements DriverStrategy{

	public WebDriver setStrategy() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		return new ChromeDriver();
	}

}
