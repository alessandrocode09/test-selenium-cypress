package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

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
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("start-maximized");
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-notifications");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(options);
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