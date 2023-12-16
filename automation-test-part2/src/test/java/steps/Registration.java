package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.HomeAndLoginPage;
import pages.RegisterPage;
import runner.RunCucumber;
import support.TestBase;
import support.Utils;

public class Registration extends RunCucumber {

	HomeAndLoginPage homeLoginPage;
	TestBase testBase;
	RegisterPage registerPage;

	String usernameID;
	String passwordUser;

	public Registration(){
		this.homeLoginPage = new HomeAndLoginPage();
		this.testBase = new TestBase();
		this.registerPage = new RegisterPage();
		this.usernameID = Utils.getRandomUsername();
		this.passwordUser = "tes321t01";
	}

	@Given("User goes to the home page")
	public void user_goes_to_the_home_page(){
		boolean accessApplication = homeLoginPage.accessApp();
		testBase.isTrue(accessApplication,
		"The application access the web application successfully",
		"Fail to access the web application");
	}

	@Then("User navigates to the Sign In page and validate the text \"([^\"]*)\" match")
	public void user_navigates_to_the_sign_in_page_and_validate_the_text(String msg){
		boolean clickedOnSignInLink = homeLoginPage.clickSignInLink();
		boolean signInPageTextDisplayed = homeLoginPage.signInTextDisplayed(msg);
		testBase.isTrue(clickedOnSignInLink,
		"The Sign In link was clicked successfully",
		"Fail to click on the Sign In link");
		testBase.isTrue(signInPageTextDisplayed,
		"The application navigates to the Sign In page and the title text is displayed successfully",
		"Fail to navigate to the Sign In page");
	}

	@And("User navigates to the Register Now page")
	public void user_navigates_to_the_register_now_page(){
		boolean clickedOnRegisterNowLink = homeLoginPage.clickRegisterNowLink();
		testBase.isTrue(clickedOnRegisterNowLink,
		"The Register Now link was clicked successfully",
		"Fail to click on the Register Now link");
	}

	@Then("User validate if the Register page is displayed by the text \"([^\"]*)\"")
	public void user_validate_if_the_register_page_is_displayed_by_the_text(String msg){
		boolean validateTheRegisterPageText = registerPage.validateTheRegisterPageDisplayed(msg);
		testBase.isTrue(validateTheRegisterPageText,
		"The user validate the text on the Register page successfully",
		"Fail to validate the text on the Register page");
	}

	@And("The user registers a new user")
	public void the_user_register_a_new_user(){
		boolean userRegisterNewUser = registerPage.userRegisterNewUser(usernameID);
		boolean validateHomePageDisplayed = homeLoginPage.validateNewUserRegistered();
		testBase.isTrue(userRegisterNewUser,
		"The user is able to register a new user successfully",
		"Fail to register a new user on the Register page");
		testBase.isTrue(validateHomePageDisplayed,
		"The new user was registered with success",
		"Fail to validate if the new user was registered on the Home page");
	}

	@And("The user logs into the application with the registered user")
	public void the_user_logs_into_the_application_with_the_registered_user(){
		boolean clickedOnSignInLink = homeLoginPage.clickSignInLink();
		boolean loginWithRegisteredUser = homeLoginPage.loginRegisteredUser(usernameID, passwordUser);
		testBase.isTrue(clickedOnSignInLink,
		"The Sign In link was clicked successfully",
		"Fail to click on the Sign In link");
		testBase.isTrue(loginWithRegisteredUser,
		"The user log into the application with registered user successfully",
		"Fail to log into the application with registered user");
	}

	@Then("The application shows the registered user logged")
	public void the_application_shows_the_registered_user_logged(){
		boolean validateLoginSuccessful = homeLoginPage.validateLoginSuccessful();
		boolean clicksOnSignOutButton = homeLoginPage.clickOnSignOutButton();
		testBase.isTrue(validateLoginSuccessful,
		"The application shows the user registered inside the application successfully",
		"Fail to show the user registered inside the application");
		testBase.isTrue(clicksOnSignOutButton,
		"The user logs out successfully",
		"Fail to log the user out");
	}

}
