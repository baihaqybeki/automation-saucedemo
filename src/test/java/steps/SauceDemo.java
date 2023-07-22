package steps;



import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.Homepage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductDetailPage;
import com.saucedemo.utils.Constants;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemo {
	private static WebDriver driver;
	private LoginPage login = new LoginPage();
	private Homepage home = new Homepage();
	private ProductDetailPage pdp = new ProductDetailPage();
	private CartPage cart = new CartPage();
	private CheckoutPage co = new CheckoutPage();
	
	public SauceDemo() {
		driver = Hook.driver;
	}
	
	@When("open web and navigate URL")
	public void navigate() {
		driver.get(Constants.url);
	}
	
	@And("login with {string} as username and {string} as password")
	public void fillUsername(String username,String password) {
		login.login(username, password);
	}
	
	
	@And("click button login")
	public void clickLoginBtn() {
		login.clickLogin();
	}
	
	@Then("verify the titile of page is {string} and the itemlist is displayed")
	public void validateItemDisplayed(String title) {
		home.validateListItem(title);
	}
	
	@Then("appear error message")
	public void verifyErrorMessage() {
		login.verifyErrorMsg();
	}
	
	@And("sort the products by {string}")
	public void sort(String sortBy) {
		home.sorted(sortBy);
	}
	
	@And("open the highest product")
	public void openProduct() {
		home.openProduct();
	}
	
	@Then("verify is {string} is the highest product with price {string}")
	public void vaildateHighestProduct(String productName, String price) {
		pdp.verifyItem(productName, price);
	}
	
	@Then("verify the product list is sorted")
	public void Sorted() {
		String sortBy = "Price (high to low)";
		assertTrue(home.isSorted(sortBy));
	}
	
	@Then("product list not sorted")
	public void notSorted() {
		String sortBy = "Price (high to low)";
		assertTrue(!(home.isSorted(sortBy)));
	}
	
	@And("add product to cart")
	public void addToCart() {
		pdp.buyProduct();
		cart.validationTitlePage();
	}
	
	@Then("verify that the product {string} with price {string} is the product that appears in the cart")
	public void verifyCheckout(String productName, String productPrice) {
		cart.verifyCheckout(productName, productPrice);
	}
	
	@And("click checkout button")
	public void clickCheckout() {
		cart.clickCheckout();
	}
	
	@Then("verfify {string} page")
	public void verifyCheckoutPage(String title) {
		co.verifyCheckoutInformation(title);
	}
	
	@And("fill the required text field")
	public void fillField() {
		co.fillField();
	}
	
	@And("click continue button")
	public void clickContinue() {
		co.clickContinue();
	}
	
	@Then("verify that the product {string} with price {string} is the product that appears on {string}")
	public void verifyCheckoutOverview(String productName, String productPrice, String title) {
		co.verifyCheckoutOverview(productName, productPrice, title);
	}
	
	@And("click finish button")
	public void clickFinish() {
		co.clickFinish();
	}
	
	@Then ("verify order status and capture screen then rename it with {string}")
	public void validationOrder(String name) {
		co.validationOrder(name);
	}

}
