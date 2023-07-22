package com.saucedemo.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.driver.DriverSingleton;

public class CheckoutPage {

	private WebDriver driver;
	
	public CheckoutPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(className = "title")
	private WebElement titlePage;
	
	@FindBy(id = "first-name")
	private WebElement firstNameField;
	
	@FindBy(id = "last-name")
	private WebElement lastNameField;
	
	@FindBy(id = "postal-code")
	private WebElement zipPostalField;
	
	@FindBy(id = "continue")
	private WebElement continueBtn;
	
	@FindBy(className = "inventory_item_name")
	private WebElement itemNameCheckout;
	
	@FindBy(className = "inventory_item_price")
	private WebElement itemPriceCheckout;
	
	@FindBy(id = "finish")
	private WebElement finishBtn;
	
	@FindBy(id = "checkout_complete_container")
	private WebElement checkoutCompleteInformation;
	
	public void verifyCheckoutInformation(String title) {
		String actualTitlePage = titlePage.getText();
		assertTrue(actualTitlePage.contains(title));
		assertTrue(firstNameField.isDisplayed());
		assertTrue(lastNameField.isDisplayed());
		assertTrue(zipPostalField.isDisplayed());
	}
	
	public void fillField() {
		firstNameField.sendKeys("sample");
		lastNameField.sendKeys("user");
		zipPostalField.sendKeys("14045");
	}
	
	public void clickContinue() {
		continueBtn.click();
	}
	
	public void verifyCheckoutOverview(String productName, String productPrice, String title) {
		String actualProductName = itemNameCheckout.getText();
		String actualProductPrice = itemPriceCheckout.getText();
		String actualTitlePage = titlePage.getText();
		
		assertEquals(actualProductName,productName);
		assertTrue(actualProductPrice.contains(productPrice));
		assertTrue(actualTitlePage.contains(title));
	}
	
	public void clickFinish() {
		finishBtn.click();
	}
	
	public void validationOrder(String name) {
	
		TakesScreenshot ss = (TakesScreenshot)driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File dir = new File(".//screenshot/screen_"+name+".png");
		try {
			FileUtils.copyFile(src, dir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(checkoutCompleteInformation.isDisplayed());
	}
	 
}
