package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunCucumber;
import support.Utils;

public class SearchResultPage extends RunCucumber {

	Utils utils;
	public void HomeAndLoginPage(){
		this.utils = new Utils();
	}

	//Elements

	private By divContentSearchResult = By.xpath("//*[contains(@id, 'Catalog')]");
	private By dataCellFinchSearchResult = By.xpath("//*[contains(@id, 'Catalog')]//td[contains(text(), 'Finch')]");

	//Below locator only work with a single item on the table
	private By clickProductResult = By.xpath("//*[contains(@id, 'Catalog')]//a[contains(text(), 'Great stress reliever')]");
	//Below locator only work with a single item on the table
	private By addToCart = By.xpath("//*[contains(text(), 'Add to Cart')]");

	//Actions

	/**
	 * Validates if the search result displays the expected product.
	 *
	 * @return {@code true} if the search result displays the expected product "Finch",
	 *         otherwise {@code false}.
	 */
	public boolean validateSearchResult(){
		try{
			utils.waitElementBePresent(divContentSearchResult, 5000);
			Assert.assertEquals(getDriver().findElement(dataCellFinchSearchResult).getText(), "Finch");
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate if the expected product is showing" + e.getMessage());
			return false;
		}
	}

	/**
	 * Adds a product to the shopping cart.
	 *
	 * @return {@code true} if the product is successfully added to the cart,
	 *         otherwise {@code false}.
	 */

	public boolean addProductToCart(){
		try{
			utils.waitElementBeClickable(clickProductResult,5000);
			getDriver().findElement(clickProductResult).click();
			utils.waitElementBeClickable(addToCart, 5000);
			getDriver().findElement(addToCart).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't add the product on the cart" + e.getMessage());
			return false;
		}
	}
}
