package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import runner.RunCucumber;
import support.Utils;

public class CheckoutPage extends RunCucumber {

	Utils utils;
	public void HomeAndLoginPage(){
		this.utils = new Utils();
	}

	//Elements
	private By paymentDetailsTitle = By.xpath("//*[contains(text(), 'Payment Details')]");
	private By checkboxShipDifferentAddress = By.name("shippingAddressRequired");
	private By textCheckboxShipDifferentAddress = By.xpath("//*[@id='Catalog']/form/table/tbody/tr[14]/td");
	private By continueButton= By.xpath("//*[contains(@value, 'Continue')]");
	private By shippingAddressTitle = By.xpath("//*[@id='Catalog']/form/table/tbody/tr[1]/th");
	private By newAddress1 = By.name("order.shipAddress1");
	private By continueButtonShippingAdd = By.name("newOrder");
	private By confirmButtonOrderConfirmDetails = By.xpath("//*[contains(text(), 'Confirm')]");
	private By orderConfirmationMessage = By.xpath("//*[contains(text(), 'Thank you, your order has been submitted.')]");

	//Actions


	/**
	 *
	 * @return
	 */
	public boolean validatePaymentDetailsPage(){
		try{
			utils.waitElementBePresent(paymentDetailsTitle, 5000);
			Assert.assertEquals(getDriver().findElement(paymentDetailsTitle).getText(), "Payment Details");
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate if the user Payment Details page" + e.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @param text
	 * @return
	 */
	public boolean clickShipDifferentAddressCheckbox(String text){
		try{
			utils.waitElementBePresent(textCheckboxShipDifferentAddress, 5000);
			Assert.assertEquals(getDriver().findElement(textCheckboxShipDifferentAddress).getText(), text);
			utils.waitElementBeClickable(checkboxShipDifferentAddress, 5000);
			getDriver().findElement(checkboxShipDifferentAddress).click();
			utils.waitElementBeClickable(continueButton,5000);
			getDriver().findElement(continueButton).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't click on ship to a different address checkbox or continue button" + e.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @param text
	 * @return
	 */
	public boolean validateShippingAddressTitle(String text){
		try{
			utils.waitElementBePresent(shippingAddressTitle, 5000);
			Assert.assertEquals(getDriver().findElement(shippingAddressTitle).getText(), text);
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate the Shipping Address title" + e.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @return
	 */
	public boolean newAddressChange(){
		try{
			utils.waitElementBePresent(newAddress1, 5000);
			getDriver().findElement(newAddress1).clear();
			getDriver().findElement(newAddress1).sendKeys("NewAdd007");
			utils.waitElementBeClickable(continueButtonShippingAdd, 5000);
			getDriver().findElement(continueButtonShippingAdd).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't type a new address" + e.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @return
	 */
	public boolean clickOnConfirmButton(){
		try{
			utils.waitElementBeClickable(confirmButtonOrderConfirmDetails, 5000);
			getDriver().findElement(confirmButtonOrderConfirmDetails).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't type a new address" + e.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @param text
	 * @return
	 */
	public boolean validateOrderSubmittedMessage(String text){
		try{
			utils.waitElementBePresent(orderConfirmationMessage, 5000);
			Assert.assertEquals(getDriver().findElement(orderConfirmationMessage).getText(), text);
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate the confirmation message" + e.getMessage());
			return false;
		}
	}

}
