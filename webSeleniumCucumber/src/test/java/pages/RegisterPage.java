package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunCucumber;
import support.Utils;

public class RegisterPage extends RunCucumber {

	Utils utils;
	public void HomeAndLoginPage(){
		this.utils = new Utils();
	}

	private By registerFormContent = By.xpath("//form//*[contains(text(), 'User Information')]");
	private By userID = By.name("username");
	private By newPass = By.name("password");
	private By repeatPass = By.name("repeatedPassword");
	private By firstName = By.name("account.firstName");
	private By lastName = By.name("account.lastName");
	private By email = By.name("account.email");
	private By phone = By.name("account.phone");
	private By address1 = By.name("account.address1");
	private By city = By.name("account.city");
	private By state = By.name("account.state");
	private By zip = By.name("account.zip");
	private By country = By.name("account.country");
	private By saveAccountInfoSubmit = By.name("newAccount");

	//Actions

	/**
	 * Validates if the register page is displayed by checking for specific text in the register form content.
	 *
	 * @param text The expected text displayed on the register page.
	 * @return {@code true} if the register page is displayed with the expected text,
	 *         otherwise {@code false}.
	 */
	public boolean validateTheRegisterPageDisplayed(String text){
		try{
			utils.waitElementBePresent(registerFormContent, 5000);
			Assert.assertEquals(getDriver().findElement(registerFormContent).getText(), text);
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate the User Information register form text" + e.getMessage());
			return false;
		}
	}

	/**
	 * Registers a new user with provided details.
	 *
	 * @param userNameId The username or user ID for the new user.
	 * @return {@code true} if the new user is successfully registered with the provided details,
	 *         otherwise {@code false}.
	 */
	public boolean userRegisterNewUser(String userNameId){
		String randomEmail = utils.getRandomEmail();
		try{
			utils.waitElementBePresent(userID, 5000);
			getDriver().findElement(userID).sendKeys(userNameId);
			getDriver().findElement(newPass).sendKeys("tes321t01");
			getDriver().findElement(repeatPass).sendKeys("tes321t01");
			getDriver().findElement(firstName).sendKeys("al3201");
			getDriver().findElement(lastName).sendKeys("al23101");
			getDriver().findElement(email).sendKeys(randomEmail);
			getDriver().findElement(phone).sendKeys("14615134");
			getDriver().findElement(address1).sendKeys("Street 01");
			getDriver().findElement(city).sendKeys("cityy01");
			getDriver().findElement(state).sendKeys("state001");
			getDriver().findElement(zip).sendKeys("zip011");
			getDriver().findElement(country).sendKeys("Port");
			utils.waitElementBePresent(saveAccountInfoSubmit, 5000);
			getDriver().findElement(saveAccountInfoSubmit).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't create a new user registration" + e.getMessage());
			return false;
		}
	}
}
