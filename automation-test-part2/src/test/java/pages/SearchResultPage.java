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

	//Actions

	/**
	 *
	 * @return
	 */
	public boolean validateSearchResult(){
		try{
			utils.waitElementBePresent(divContentSearchResult, 5000);
			Assert.assertEquals(getDriver().findElement(dataCellFinchSearchResult).getText(), "Finch");
			Thread.sleep(8000);
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate if the expected product is showing" + e.getMessage());
			return false;
		}
	}
}
