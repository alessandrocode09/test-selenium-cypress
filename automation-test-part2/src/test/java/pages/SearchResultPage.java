package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
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
	 *
	 * @return
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
	 *
	 * @return
	 */
	public boolean addProductToCart(){
		try{
			utils.waitElementBePresent(clickProductResult,5000);
			getDriver().findElement(clickProductResult).click();
			utils.waitElementBePresent(addToCart, 5000);
			getDriver().findElement(addToCart).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate if the expected product is showing" + e.getMessage());
			return false;
		}
	}
}
