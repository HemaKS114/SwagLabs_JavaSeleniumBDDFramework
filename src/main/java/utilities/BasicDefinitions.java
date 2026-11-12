//Base class to  initiate browser, webdriver and teardown

package utilities;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import dataproviders.ConfigFileReader;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BasicDefinitions
{
	
	public static BasicDefinitions basicDef;
	public static WebDriver driver;
	
	static ConfigFileReader config;
	public static String TC_id = "", TC_Description = "", FeatureName ="";
	public static Scenario scenario = null;
	
	public static HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> jsontestdataHashMap = new HashMap<>();
	
	public static void launchBrowser() throws IOException
	{
		config =  new ConfigFileReader();
		String browser = config.BrowserName();
		
		if(browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();

		    options.addArguments("--headless=new");
		    options.addArguments("--window-size=1920,1080");
		    WebDriverManager.chromedriver().setup();

		    driver = new ChromeDriver(options);
		}
		
		
	}
	
	public static void OpenURL()
	{
		String url = config.appURL();
		driver.get(url);
		driver.manage().window().maximize();	
	}
	
	@AfterAll
	public static void teardown()
	{
		if(driver!=null) {
			driver.close();
		}
	}
	
	
}