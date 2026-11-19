package utilities;

import java.io.File;
import java.util.Date;

import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks
{
	
	@Before(order = 1)
	public static void init(Scenario scenario) {
		
//		BasicDefinitions.TC_id = scenario.getName().split("-")[0].trim();
//		BasicDefinitions.tc_id = BasicDefinitions.TC_id.get();
//		BasicDefinitions.TC_Description = scenario.getName().split("-")[1].trim();
//		BasicDefinitions.tc_Description = BasicDefinitions.TC_Description.get();
//		BasicDefinitions.FeatureName = FileNameUtils.getBaseName(scenario.getUri().toString());
//		BasicDefinitions.featureName = BasicDefinitions.FeatureName.get();
		
		BasicDefinitions.scenario.set(scenario);
		scenario = BasicDefinitions.scenario.get();
		BasicDefinitions.TC_id.set(scenario.getName().split("-")[0].trim());
		BasicDefinitions.TC_Description.set(scenario.getName().split("-")[1].trim());
		BasicDefinitions.FeatureName.set(FileNameUtils.getBaseName(scenario.getUri().toString()));
		BasicDefinitions.getTC_id();
		BasicDefinitions.getTC_Description();
		BasicDefinitions.getFeatureName();
	}
	
	@AfterStep
	public static void appendScreenshot() {
		
		try {
			
			WebDriver driver = BasicDefinitions.driver.get();
	        Scenario scenario = BasicDefinitions.scenario.get();
		byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		scenario.attach(screenshot, "image/png", "Screenshot of this step:");
		}
		catch(Exception e) {
			Assert.fail("Unable to take screenshot"+e);
		}
		
	}
}