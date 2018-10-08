package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BrowserConfig {

	public WebDriver driver = null;
	String browserType;
	String driverPath;
	String url;

	@BeforeMethod
	public void BorwserConfig() {

		driver = new ChromeDriver();

		ConfigFileReader config = new ConfigFileReader();

		browserType = config.getBrowserType();
		driverPath = config.getDriverPath();
		url = config.getURL();

		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		}

		else if (browserType.equalsIgnoreCase("firefox")) {
			// System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new FirefoxDriver();
		}

		else if (browserType.equalsIgnoreCase("IE"))

		{
			System.setProperty("webdriver.ie.driver", driverPath);
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}

	// @AfterMethod
	// public void closeBrowser() {
	// driver.quit();
	// }

}
