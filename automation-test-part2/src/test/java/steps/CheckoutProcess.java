package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomeAndLoginPage;
import pages.SearchResultPage;
import runner.RunCucumber;
import support.TestBase;

public class CheckoutProcess extends RunCucumber {

	HomeAndLoginPage homeLoginPage;
	SearchResultPage searchResultPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	TestBase testBase;

	public CheckoutProcess(){
		this.homeLoginPage = new HomeAndLoginPage();
		this.searchResultPage = new SearchResultPage();
		this.cartPage = new CartPage();
		this.checkoutPage = new CheckoutPage();
		this.testBase = new TestBase();
	}

	@And("On the cart user clicks on Proceed to Checkout")
	public void on_the_cart_user_clicks_on_proceed_to_checkout(){
		boolean clickProceedCheckout = cartPage.clickOnProceedCheckout();
		testBase.isTrue(clickProceedCheckout,
		"Proceed Checkout button clicked successfully",
		"Fail clicking on the Proceed Checkout button");
	}

	@And("User clicks on the \"([^\"]*)\" checkbox")
	public void user_clicks_on_the_checkbox(String value){
		boolean validatePaymentDetailPage = checkoutPage.validatePaymentDetailsPage();
		boolean clickShipDifferentAddress = checkoutPage.clickShipDifferentAddressCheckbox(value);
		testBase.isTrue(validatePaymentDetailPage,
		"Payment Detail page displayed successfully",
		"Fail to validate the Payment Detail page");
		testBase.isTrue(clickShipDifferentAddress,
		"Ship to different address was clicked successfully",
		"Fail to click on Ship to different address checkbox");
	}

	@Then("The application shows the \"([^\"]*)\" page form successfully")
	public void the_application_shows_the_page_form_successfully(String value){
		boolean validateShippingAddressTitle = checkoutPage.validateShippingAddressTitle(value);
		testBase.isTrue(validateShippingAddressTitle,
		"Shipping Address page displayed successfully",
		"Fail validating Shipping Address page title");
	}

	@And("The user change the address")
	public void the_user_change_the_address(){
		boolean newAddressChange = checkoutPage.newAddressChange();
		testBase.isTrue(newAddressChange,
		"New Address changed successfully",
		"Fail changing new Address");
	}

	@And("User clicks on the Confirm button")
	public void user_clicks_on_the_confirm_button(){
		boolean clickOnConfirmButton = checkoutPage.clickOnConfirmButton();
		testBase.isTrue(clickOnConfirmButton,
		"Confirm button was clicked successfully",
		"Fail clicking on Confirm button");
	}

	@Then("The application will show the \"([^\"]*)\" message confirmation successfully")
	public void the_application_will_show_the_confirmation_order_successfully(String value){
		boolean validateOrderSubmitted = checkoutPage.validateOrderSubmittedMessage(value);
		testBase.isTrue(validateOrderSubmitted,
		"Order confirmation message is displayed successfully",
		"Fail displaying the Order confirmation message");
	}

}
