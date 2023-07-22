package com.saucedemo.driver.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxDocker implements DriverStrategy{

	public WebDriver setStrategy() {
		// TODO Auto-generated method stub
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		RemoteWebDriver driver = new RemoteWebDriver(dc);
		return driver;
	}

}
