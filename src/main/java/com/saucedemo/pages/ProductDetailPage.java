package com.saucedemo.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.driver.DriverSingleton;

public class ProductDetailPage {
	
	private WebDriver driver;
	
	public ProductDetailPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "inventory_details_name")
	private WebElement detailProductName;
	
	@FindBy(className = "inventory_details_price")
	private WebElement detailProductPrice;
	
	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	private WebElement addToCartBtn;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement cartIcon;
	
	public void verifyItem(String productName, String price) {
		String actualProductName = detailProductName.getText();
		String actualProductPrice = detailProductPrice.getText();
		assertEquals(actualProductName, productName);
		assertTrue(actualProductPrice.contains(price));
	}
	
	public void buyProduct() {
		addToCartBtn.click();
		delay(1);
		cartIcon.click();
	}
	
	static void delay(int second) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
