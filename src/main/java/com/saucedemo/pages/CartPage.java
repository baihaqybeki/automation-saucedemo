package com.saucedemo.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.driver.DriverSingleton;

public class CartPage {

	private WebDriver driver;
	
	public CartPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(className = "title")
	private WebElement titlePage;
	
	@FindBy(className = "inventory_item_name")
	private WebElement itemNameCheckout;
	
	@FindBy(className = "inventory_item_price")
	private WebElement itemPriceCheckout;	
	
	@FindBy(id = "checkout")
	private WebElement checkoutBtn;
	
	public void validationTitlePage() {
		String actualTitlePage = titlePage.getText();
		assertEquals(actualTitlePage,"Your Cart");
	}
	
	public void verifyCheckout(String productName,String productPrice) {
		String actualProductName = itemNameCheckout.getText();
		String actualProductPrice = itemPriceCheckout.getText();
		assertEquals(actualProductName, productName);
		assertTrue(actualProductPrice.contains(productPrice));
	}
	
	public void clickCheckout() {
		checkoutBtn.click();
	}
}
