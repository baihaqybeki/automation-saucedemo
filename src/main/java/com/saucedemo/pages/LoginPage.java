package com.saucedemo.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.driver.DriverSingleton;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='login_logo']")
	private WebElement logoLogin;
	
	@FindBy(id = "user-name")
	private WebElement fieldUsername;
	
	@FindBy(id = "password")
	private WebElement fieldPassword;
	
	@FindBy(id = "login-button")
	private WebElement buttonLogin;
	
	@FindBy(className = "error-message-container")
	private WebElement errorMessage;
	
	public void login(String username, String password) {
		assertTrue(logoLogin.isDisplayed());
		fieldUsername.sendKeys(username);
		fieldPassword.sendKeys(password);
		delay(1);
	}
	
	public void clickLogin() {
		buttonLogin.click();
	}
	
	public void verifyErrorMsg() {
		delay(2);
		assertTrue(errorMessage.isDisplayed());
	}

	static void delay(int second) {
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
