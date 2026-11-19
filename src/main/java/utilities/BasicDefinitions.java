//Base class to  initiate browser, webdriver and teardown

package utilities;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import dataproviders.ConfigFileReader;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BasicDefinitions
{
	
	public static BasicDefinitions basicDef;
//	public static WebDriver driver;
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static ThreadLocal<Scenario> scenario = new ThreadLocal<>();
	
	
	static ConfigFileReader config;
//	public static String tc_id = "", tc_Description = "", featureName ="";
	
	public static ThreadLocal<String>TC_id = new ThreadLocal<>();
	public static ThreadLocal<String> TC_Description = new ThreadLocal<>();
	public static ThreadLocal<String>FeatureName = new ThreadLocal<>();
//	public static Scenario scenario = null;
	
	public static ThreadLocal<LocalDateTime> startTime = new ThreadLocal<>();
	
	public static HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> jsontestdataHashMap = new HashMap<>();
	
	
	public static String getTC_id() {
	    return TC_id.get();
	}

	public static String getTC_Description() {
	    return TC_Description.get();
	}

	public static String getFeatureName() {
	    return FeatureName.get();
	}
	
	public static void launchBrowser() throws IOException
	{
		config =  new ConfigFileReader();
		String browser = config.BrowserName();
		
//		if(browser.equals("chrome")) {
//			ChromeOptions options = new ChromeOptions();
//
//		    options.addArguments("--headless=new");
//		    options.addArguments("--window-size=1920,1080");
//		    WebDriverManager.chromedriver().setup();
//		    
//		    
//		}
		
		switch(browser.toLowerCase()) {
		
		case "chrome":
			ChromeOptions options = new ChromeOptions();

		    options.addArguments("--headless=new");
		    options.addArguments("--window-size=1920,1080");
		    WebDriverManager.chromedriver().setup();
		    BasicDefinitions.driver.set(new ChromeDriver(options));
//		    driver = new ChromeDriver(options);
		    break;
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--headless=new");
			edgeOptions.addArguments("--window-size=1920,1080");
			WebDriverManager.edgedriver().setup();
			BasicDefinitions.driver.set(new EdgeDriver(edgeOptions));
//			driver = new EdgeDriver();
		
		}
		
		
	}
	
	public static void OpenURL()
	{
		String url = config.appURL();
//		driver.get(url);
//		driver.manage().window().maximize();	
		driver.get().get(url);
		driver.get().manage().window().maximize();	
	}
	
	@AfterAll
	public static void teardown()
	{
		if(driver.get()!=null) {
//			driver.close();
			driver.get().close();
			driver.get().quit();
			
		}
		
	}
	
	
}