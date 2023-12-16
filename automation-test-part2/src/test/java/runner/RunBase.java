package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RunBase {

	static WebDriver driver;

	public static WebDriver getDriver(){
		return driver;
	}

	public static WebDriver getDriver(String browser) {

		if (driver !=  null) {
			driver.quit();
		}

		switch (browser) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				throw new IllegalArgumentException("Firefox browser is not supported!");
			case "edge":
				throw new IllegalArgumentException("Edge browser is not supported!");
			default:
				throw new IllegalArgumentException("Browser not found! Browser supported is: Chrome");
		}

		if(driver != null){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		return driver;
	}

}