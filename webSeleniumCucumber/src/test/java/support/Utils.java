package support;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

import java.util.Random;

public class Utils extends RunCucumber {


	/**
	 * Waits for an element to be clickable within a specified time.
	 *
	 * @param element The locator of the element to wait for.
	 * @param time    The maximum time to wait for the element to be clickable, in seconds.
	 */
	public static void waitElementBeClickable(By element, Integer time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Waits for an element to be present within a specified time.
	 *
	 * @param element The locator of the element to wait for.
	 * @param time    The maximum time to wait for the element to be present, in seconds.
	 */
	public static void waitElementBePresent(By element, Integer time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	/**
	 * Generates a random email address.
	 *
	 * @return A randomly generated email address in the format: tst_randomNumber@mail.com.
	 */
	public static String getRandomEmail() {
		StringBuilder builder = new StringBuilder();

		Random random = new Random();
		int minimum = 1;
		int maximum = 99999;

		builder.append("tst_");
		builder.append(random.nextInt(maximum-minimum) + minimum);
		builder.append("@mail.com");

		return builder.toString();
	}

	/**
	 * Generates a random username.
	 *
	 * @return A randomly generated username in the format: afs_randomNumber.
	 */
	public static String getRandomUsername() {
		StringBuilder builder = new StringBuilder();

		Random random = new Random();
		int minimum = 1;
		int maximum = 99999;

		builder.append("afs");
		builder.append(random.nextInt(maximum-minimum) + minimum);

		return builder.toString();
	}
}
