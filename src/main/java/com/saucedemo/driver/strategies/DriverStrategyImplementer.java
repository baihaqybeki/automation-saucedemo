package com.saucedemo.driver.strategies;

import com.saucedemo.utils.Constants;

public class DriverStrategyImplementer {
	
	public static DriverStrategy chooseStrategy(String strategy) {
		switch (strategy) {
		case Constants.Chrome :
			return new Chrome();
			
		case Constants.Firefox :
			return new Firefox();
			
		case Constants.Safari :
			return new Safari();
			
		case Constants.ChromeDocker :
			return new ChromeDocker();
			
		case Constants.FirefoxDocker :
			return new FirefoxDocker();
			
		case Constants.EdgeDocker :
			return new EdgeDocker();
			
		default :
			return null;
		}
	}

}
