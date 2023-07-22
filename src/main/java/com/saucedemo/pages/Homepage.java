package com.saucedemo.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.saucedemo.driver.DriverSingleton;

public class Homepage {
	
	private WebDriver driver;
	
	public Homepage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "title")
	private WebElement titlePage;
	
	@FindBy(id = "inventory_container")
	private WebElement itemList;
	
	@FindBy(className = "inventory_item_price")
	private List<WebElement> itemPrice;
	
	@FindBy(className = "product_sort_container")
	private WebElement dropdownSorting;
	
	@FindBy(id = "item_2_title_link")
	private WebElement lowestProductName;
	
	@FindBy(id = "item_5_title_link")
	private WebElement highestProductName;
	
	public void validateListItem(String title) {
		delay(5);
		String actualTitlePage = titlePage.getText();
		assertTrue(itemList.isDisplayed());
		assertEquals(actualTitlePage,title);
	}
	
	public void sorted(String sortby) {
		Select dropdown = new Select(dropdownSorting);
		
		List<Double> itemBeforeSortedList = new ArrayList<>();
		
		for (WebElement x : itemPrice) {
			itemBeforeSortedList.add(Double.valueOf(x.getText().replace("$", "")));
		}
		
		dropdown.selectByVisibleText("Price (low to high)");
		delay(1);
		
		int lowestProductWidth = lowestProductName.getSize().getWidth();
		int lowestProductHeight = lowestProductName.getSize().getHeight();
		
		dropdown.selectByVisibleText(sortby);
		
		List<Double> itemAfterSortedList = new ArrayList<>();
		for (WebElement y : itemPrice) {
			itemAfterSortedList.add(Double.valueOf(y.getText().replace("$", "")));
		}
		
		int highestProductWidth = highestProductName.getSize().getWidth();
		int highestProductHeight = highestProductName.getSize().getHeight();
		
		System.out.println("  " + lowestProductWidth + " ==> Cheapest product width sorted low to high");
		System.out.println("  " + lowestProductHeight + " ==> Cheapest product height sorted low to high");
		System.out.println("  " + highestProductWidth + " ==> Expensive product width sorted high to low");
		System.out.println("  " + highestProductHeight + " ==> Expensive product height sorted high to low");
		
		System.out.println("  " + itemBeforeSortedList + " ==> Before sorted");
		Collections.sort(itemBeforeSortedList);
		Collections.reverse(itemBeforeSortedList);
		
		System.out.println("  " + itemBeforeSortedList + " ==> Expected results");
		System.out.println("  " + itemAfterSortedList + " ==> Actual results");
		
//		assertEquals(lowestProductWidth,highestProductWidth);
//		assertEquals(lowestProductHeight,highestProductHeight);
//		assertEquals(itemBeforeSortedList,itemAfterSortedList);
	}
	
	public boolean isSorted(String sortBy) {
		Select dropdown = new Select(dropdownSorting);
		
		List<Double> itemBeforeSortedList = new ArrayList<>();
		
		for (WebElement x : itemPrice) {
			itemBeforeSortedList.add(Double.valueOf(x.getText().replace("$", "")));
		}
		dropdown.selectByVisibleText(sortBy);
		List<Double> itemAfterSortedList = new ArrayList<>();
		for (WebElement y : itemPrice) {
			itemAfterSortedList.add(Double.valueOf(y.getText().replace("$", "")));
		}
		Collections.sort(itemBeforeSortedList);
		Collections.reverse(itemBeforeSortedList);
		Boolean isTrue = itemBeforeSortedList.equals(itemAfterSortedList);
		return isTrue;
	}
	
	public void openProduct() {
		highestProductName.click();
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
