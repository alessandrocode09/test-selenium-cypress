package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

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
	 * Validates the presence of the Payment Details page.
	 *
	 * @return {@code true} if the Payment Details page is present with the expected title "Payment Details",
	 *         otherwise {@code false}.
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
	 * Clicks on the "Ship to a Different Address" checkbox and continues.
	 *
	 * @param text The text expected on the checkbox.
	 * @return {@code true} if the checkbox is clicked and the continue button is successfully clicked,
	 *         otherwise {@code false}.
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
	 * Validates the title of the Shipping Address.
	 *
	 * @param text The expected text for the Shipping Address title.
	 * @return {@code true} if the Shipping Address title matches the expected text,
	 *         otherwise {@code false}.
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
	 * Updates the shipping address with a new address.
	 *
	 * @return {@code true} if the new address is successfully entered and the continue button for shipping address is clicked,
	 *         otherwise {@code false}.
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
	 * Clicks on the confirm button for order confirmation details.
	 *
	 * @return {@code true} if the confirm button for order confirmation details is clicked successfully,
	 *         otherwise {@code false}.
	 */
	public boolean clickOnConfirmButton(){
		try{
			utils.waitElementBeClickable(confirmButtonOrderConfirmDetails, 5000);
			getDriver().findElement(confirmButtonOrderConfirmDetails).click();
			return true;
		} catch (Exception e){
			System.out.println("Couldn't clicks on the confirm button" + e.getMessage());
			return false;
		}
	}

	/**
	 * Validates the order submitted message.
	 *
	 * @param text The expected text for the order submission confirmation message.
	 * @return {@code true} if the order confirmation message matches the expected text,
	 *         otherwise {@code false}.
	 */
	public boolean validateOrderSubmittedMessage(String text){
		try{
			utils.waitElementBePresent(orderConfirmationMessage, 5000);
			Assert.assertEquals(getDriver().findElement(orderConfirmationMessage).getText(), text);
			return true;
		} catch (Exception e){
			System.out.println("Couldn't validate the order confirmation message" + e.getMessage());
			return false;
		}
	}

}
