package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.CartPage;
import pages.HomeAndLoginPage;
import pages.SearchResultPage;
import runner.RunCucumber;
import support.TestBase;

public class AddRemoveItemsCart extends RunCucumber {
	HomeAndLoginPage homeLoginPage;
	SearchResultPage searchResultPage;
	CartPage cartPage;
	TestBase testBase;

	public AddRemoveItemsCart(){
		this.homeLoginPage = new HomeAndLoginPage();
		this.searchResultPage = new SearchResultPage();
		this.cartPage = new CartPage();
		this.testBase = new TestBase();
	}

	@And("User clicks on the product and add it to the cart")
	public void user_clicks_on_the_product_and_add_it_to_the_cart(){
		boolean clicksOnAddProductToCart = searchResultPage.addProductToCart();
		testBase.isTrue(clicksOnAddProductToCart,
		"Add to Cart button was clicked successfully",
		"Fail to click on Add to Cart button");
	}

	@And("On the cart the user remove the item from the cart")
	public void on_the_cart_the_user_remove_the_item_from_the_cart(){
		boolean validateShoppingCartPage = cartPage.validateShoppingCartDisplayed();
		boolean clickToRemoveItemFromCart = cartPage.clickOnTheRemoveButton();
		testBase.isTrue(validateShoppingCartPage,
		"Shopping cart page is displayed successfully",
		"Fail displaying the Shopping cart page");
		testBase.isTrue(clickToRemoveItemFromCart,
		"Remove button was clicked successfully",
		"Fail clicking on Remove button");
	}

	@Then("The application will show the cart empty")
	public void the_application_will_show_the_cart_empty(){
		boolean validateShoppingCartEmpty = cartPage.validateShoppingCartIsEmpty();
		testBase.isTrue(validateShoppingCartEmpty,
		"Shopping cart is empty successfully",
		"Fail to validate if the shopping cart is empty");
	}
}
