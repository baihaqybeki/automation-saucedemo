package com.saucedemo.driver.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Firefox implements DriverStrategy{

	public WebDriver setStrategy() {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		
		return new FirefoxDriver();
	}

}
