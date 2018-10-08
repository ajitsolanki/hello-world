package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "Configuration//Configuration.properties";

	public ConfigFileReader() {

		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();

			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getBrowserType() {

		String BrowserType = properties.getProperty("BrowserType");
		if (BrowserType != null)
			return BrowserType;
		else
			throw new RuntimeException("Browser type not specified in Configuration property file");
	}

	public String getDriverPath() {

		String driverPath = properties.getProperty("DriverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("Driver path not specified in Configuration property file");
	}

	public String getURL() {

		String url = properties.getProperty("URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("URL is not specified in Configuration property file");
	}
}
