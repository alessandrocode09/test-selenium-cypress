package support;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

import java.util.Random;

public class Utils extends RunCucumber {


	public static void waitElementBePresent(By element, Integer time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

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
