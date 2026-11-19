package dataproviders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import utilities.BasicDefinitions;

public class ConfigFileReader
{
	
	public Properties properties = new Properties();
	
	private String propertyFilePath = "src//main//resources//config//config.properties";
	
	public ConfigFileReader() throws IOException {
		
		BufferedReader reader;
		
		reader = new BufferedReader(new FileReader(propertyFilePath));
		
		properties.load(reader);
		reader.close();
		
	}
	
	
	public String BrowserName() {
		
		String browserName = properties.getProperty("browser");
		return browserName;
	}
	
	public String appURL() {
		String appURL = properties.getProperty("url");
		return appURL;
		
	}
	
	public void maximizeWindow() {
		
		BasicDefinitions.driver.get().manage().window().maximize();
		
	}
}