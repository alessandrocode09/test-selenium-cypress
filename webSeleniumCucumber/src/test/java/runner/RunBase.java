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

	/**
	 * Initializes and returns a WebDriver instance based on the specified browser.
	 *
	 * @param browser The browser type (e.g., "chrome", "firefox", "edge").
	 * @return A WebDriver instance configured for the specified browser,
	 *         or throws an IllegalArgumentException for unsupported browsers.
	 */
	public static WebDriver getDriver(String browser) {

		if (driver !=  null) {
			driver.quit();
		}

		String os = System.getProperty("os.name").toLowerCase();
		String driverPath = "";

		switch (os) {
			case "windows 10":
				driverPath = "../webSeleniumCucumber/src/test/java/drivers/chromedriver.exe";
				break;
			case "mac os x":
				driverPath = "../webSeleniumCucumber/src/test/java/drivers/chromedriver_macArm64";
				break;
			case "linux":
				driverPath = "../webSeleniumCucumber/src/test/java/drivers/chromedriver_linux64";
				break;
			default:
				throw new IllegalArgumentException("Unsupported operating system!");
		}

		switch (browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", driverPath);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				options.addArguments("--headless");
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