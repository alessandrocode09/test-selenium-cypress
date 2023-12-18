package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
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
	 * Accesses the application by opening it in the Chrome browser.
	 *
	 * @return {@code true} if the application is accessed successfully in the Chrome browser,
	 *         otherwise {@code false}.
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
	 * Clicks on the Sign In link.
	 *
	 * @return {@code true} if the Sign In link is clicked successfully,
	 *         otherwise {@code false}.
	 */
	public boolean clickSignInLink(){
		try{
			utils.waitElementBeClickable(signInLink, 5000);
			getDriver().findElement(signInLink).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't click on the Sign In link" + e.getMessage());
			return false;
		}
	}

	/**
	 * Validates if the sign-in text is displayed.
	 *
	 * @param text The expected text for the sign-in paragraph.
	 * @return {@code true} if the sign-in paragraph text matches the expected text,
	 *         otherwise {@code false}.
	 */
	public boolean signInTextDisplayed(String text){
		try{
			utils.waitElementBePresent(loginParagraphText, 5000);
			Assert.assertEquals(getDriver().findElement(loginParagraphText).getText(), text);
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate the Sign In text" + e.getMessage());
			return false;
		}
	}

	/**
	 * Clicks on the "Register Now" link.
	 *
	 * @return {@code true} if the "Register Now" link is clicked successfully,
	 *         otherwise {@code false}.
	 */
	public boolean clickRegisterNowLink(){
		try{
			utils.waitElementBeClickable(registerNowLink, 5000);
			getDriver().findElement(registerNowLink).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't click on the Register Now link" + e.getMessage());
			return false;
		}
	}

	/**
	 * Validates if a new user is successfully registered and on the Home screen.
	 *
	 * @return {@code true} if the user is on the Home screen with the "Sign In" link displayed,
	 *         otherwise {@code false}.
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
	 * Logs in a registered user with the provided username and password.
	 *
	 * @param username The username of the registered user.
	 * @param password The password of the registered user.
	 * @return {@code true} if the registered user is logged in successfully using the provided credentials,
	 *         otherwise {@code false}.
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
			System.out.println("Couldn't login the registered user on the application" + e.getMessage());
			return false;
		}
	}

	/**
	 * Validates if the login is successful by checking for the presence of the "Sign Out" link.
	 *
	 * @return {@code true} if the login is successful and the "Sign Out" link is present,
	 *         otherwise {@code false}.
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
	 * Enters text in the product search field.
	 *
	 * @param text The text to be entered in the product search field.
	 * @return {@code true} if the text is successfully entered in the search field,
	 *         otherwise {@code false}.
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
	 * Clicks on the search button.
	 *
	 * @return {@code true} if the search button is clicked successfully,
	 *         otherwise {@code false}.
	 */
	public boolean clicksOnSearchButton(){
		try{
			utils.waitElementBeClickable(searchButton, 5000);
			getDriver().findElement(searchButton).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't click on the search button" + e.getMessage());
			return false;
		}
	}

}
