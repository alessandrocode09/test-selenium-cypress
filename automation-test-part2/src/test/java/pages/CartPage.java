package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
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


	//Actions

	/**
	 *
	 * @return
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
	 *
	 * @return
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
	 *
	 * @return
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
}
