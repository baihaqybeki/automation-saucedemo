package com.saucedemo.driver.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Safari implements DriverStrategy{

	public WebDriver setStrategy() {
		// TODO Auto-generated method stub
		WebDriverManager.safaridriver().setup();
		
		return new SafariDriver();
	}
}
