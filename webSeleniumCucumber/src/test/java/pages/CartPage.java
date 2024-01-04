package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunCucumber;
import support.Utils;

public class CartPage extends RunCucumber {

	Utils utils;
	public void CartPage(){
		this.utils = new Utils();
	}


	//Elements

	private By shoppingCartTitle = By.xpath("//div[contains(@id, 'Cart')]//h2[contains(text(), 'Shopping Cart')]");

	private By removeFirstItem = By.xpath("//a[contains(text(), 'Remove')]");

	private By cartEmptyText = By.xpath("//div[contains(@id, 'Cart')]//b[contains(text(), 'Your cart is empty.')]");

	private By proceedToCheckoutButton = By.xpath("//a[contains(text(), 'Proceed to Checkout')]");


	//Actions

	/**
	 * Validates if the shopping cart is displayed.
	 *
	 * @return {@code true} if the shopping cart is displayed with the expected title "Shopping Cart",
	 *         otherwise {@code false}.
	 */
	public boolean validateShoppingCartDisplayed(){
		try{
			utils.waitElementBePresent(shoppingCartTitle, 5000);
			Assert.assertEquals(getDriver().findElement(shoppingCartTitle).getText(), "Shopping Cart");
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate if the expected shopping is displayed as expected" + e.getMessage());
			return false;
		}
	}

	/**
	 * Clicks on the remove button for the first item in the cart.
	 *
	 * @return {@code true} if the remove button for the first item is clicked successfully,
	 *         otherwise {@code false}.
	 */
	public boolean clickOnTheRemoveButton(){
		try{
			utils.waitElementBePresent(removeFirstItem, 5000);
			Assert.assertEquals(getDriver().findElement(removeFirstItem).getText(), "Remove");
			getDriver().findElement(removeFirstItem).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't click to remove the item from the cart" + e.getMessage());
			return false;
		}
	}

	/**
	 * Validates if the shopping cart is empty.
	 *
	 * @return {@code true} if the shopping cart is empty and displays the message "Your cart is empty.",
	 *         otherwise {@code false}.
	 */
	public boolean validateShoppingCartIsEmpty(){
		try{
			utils.waitElementBePresent(cartEmptyText, 5000);
			Assert.assertEquals(getDriver().findElement(cartEmptyText).getText(), "Your cart is empty.");
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate if the shopping cart is empty" + e.getMessage());
			return false;
		}
	}

	/**
	 * Clicks on the "Proceed to Checkout" button.
	 *
	 * @return {@code true} if the "Proceed to Checkout" button is clicked successfully,
	 *         otherwise {@code false}.
	 */
	public boolean clickOnProceedCheckout(){
		try{
			utils.waitElementBeClickable(proceedToCheckoutButton, 5000);
			Assert.assertEquals(getDriver().findElement(proceedToCheckoutButton).getText(), "Proceed to Checkout");
			getDriver().findElement(proceedToCheckoutButton).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't click on the Proceed Checkout button" + e.getMessage());
			return false;
		}
	}
}
