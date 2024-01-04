package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.HomeAndLoginPage;
import pages.SearchResultPage;
import runner.RunCucumber;
import support.TestBase;

public class SearchProduct extends RunCucumber {
	HomeAndLoginPage homeLoginPage;
	SearchResultPage searchResultPage;
	TestBase testBase;
	public SearchProduct(){
		this.homeLoginPage = new HomeAndLoginPage();
		this.searchResultPage = new SearchResultPage();
		this.testBase = new TestBase();
	}

	@And("User types the product \"([^\"]*)\" on the search input field")
	public void user_types_the_product_on_search_input_field(String product){
		boolean searchProductField = homeLoginPage.typesProductOnSearchField(product);
		testBase.isTrue(searchProductField,
		"Product type on the search field successfully",
		"Fail to type on the search field");
	}

	@And("User clicks on the search button")
	public void user_clicks_on_the_search_button(){
		boolean clicksOnSearchButton = homeLoginPage.clicksOnSearchButton();
		testBase.isTrue(clicksOnSearchButton,
		"Search button clicked successfully",
		"Fail to click on the search button");
	}

	@Then("The application shows the result for the product successfully")
	public void the_application_shows_the_result_for_the_product_successfully(){
		boolean validateTheSearchResult = searchResultPage.validateSearchResult();
		testBase.isTrue(validateTheSearchResult,
		"Search result working as successfully",
		"Search result failed");
	}
}
