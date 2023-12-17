package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import runner.RunCucumber;
import support.Utils;

public class HomeAndLoginPage extends RunCucumber {


	Utils utils;
	public void HomeAndLoginPage(){
		this.utils = new Utils();
	}

	//Elements
	private String URL = "https://petstore.octoperf.com/actions/Catalog.action";
	private By signInLink = By.linkText("Sign In");
	private By loginParagraphText = By.xpath("//*[contains(text(), 'Please enter your username and password.')]");
	private By usernameLoginForm = By.name("username");
	private By passwordLoginForm = By.name("password");
	private By loginButton = By.name("signon");
	private By signOutLink = By.linkText("Sign Out");
	private By registerNowLink = By.linkText("Register Now!");
	private By searchInputField = By.name("keyword");
	private By searchButton = By.name("searchProducts");


	//Actions

	/**
	 *
	 * @return
	 */
	public boolean accessApp(){
		try{
			getDriver("chrome").get(URL);
			return true;
		} catch (Exception e){
			System.out.println("Couldn't open the Chrome browser: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Method is used to click on the "Sign In" link option from the home page.
	 * @return [boolean] : True after be able to click and display the Login page
	 */
	public boolean clickSignInLink(){
		try{
			utils.waitElementBePresent(signInLink, 5000);
			getDriver().findElement(signInLink).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't click on the Sign In link" + e.getMessage());
			return false;
		}
	}

	/**
	 * Method is used to validate if the user is on the Sign In page, using the paragraph text from the Login form.
	 * @return [boolean] : True if the text match and false if the text doesn't match
	 */
	public boolean signInTextDisplayed(String text){
		try{
			utils.waitElementBePresent(loginParagraphText, 5000);
			Assert.assertEquals(getDriver().findElement(loginParagraphText).getText(), text);
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate the Login text" + e.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @return
	 */
	public boolean clickRegisterNowLink(){
		try{
			utils.waitElementBePresent(registerNowLink, 5000);
			getDriver().findElement(registerNowLink).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't click on the Register Now link" + e.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @return
	 */
	public boolean validateNewUserRegistered(){
		try{
			utils.waitElementBePresent(signInLink, 5000);
			Assert.assertEquals(getDriver().findElement(signInLink).getText(), "Sign In");
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate if the user is on Home screen" + e.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean loginRegisteredUser(String username, String password){
		try{
			utils.waitElementBePresent(usernameLoginForm, 5000);
			getDriver().findElement(usernameLoginForm).clear();
			getDriver().findElement(usernameLoginForm).sendKeys(username);
			getDriver().findElement(passwordLoginForm).clear();
			getDriver().findElement(passwordLoginForm).sendKeys(password);
			getDriver().findElement(loginButton).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't click on the Register Now link" + e.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @return
	 */
	public boolean validateLoginSuccessful(){
		try{
			utils.waitElementBePresent(signOutLink, 5000);
			Assert.assertEquals(getDriver().findElement(signOutLink).getText(), "Sign Out");
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate the User Information register form text" + e.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @return
	 */
	public boolean clickOnSignOutButton(){
		try{
			utils.waitElementBePresent(signOutLink, 5000);
			getDriver().findElement(signOutLink).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate the User Information register form text" + e.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @return
	 */
	public boolean typesProductOnSearchField(String text){
		try{
			utils.waitElementBePresent(searchInputField, 5000);
			getDriver().findElement(searchInputField).clear();
			getDriver().findElement(searchInputField).sendKeys(text);
			return true;
		} catch (Exception e){
			System.out.println("Couldn't type on the search field" + e.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @return
	 */
	public boolean clicksOnSearchButton(){
		try{
			utils.waitElementBePresent(searchButton, 5000);
			getDriver().findElement(searchButton).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't click on the search button" + e.getMessage());
			return false;
		}
	}

}
