package utilities;

import java.io.File;
import java.util.Date;

import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks
{
	
	@Before(order = 1)
	public static void init(Scenario scenario) {
		
		BasicDefinitions.scenario = scenario;
		BasicDefinitions.TC_id = scenario.getName().split("-")[0].trim();
		BasicDefinitions.TC_Description = scenario.getName().split("-")[1].trim();
		BasicDefinitions.FeatureName = FileNameUtils.getBaseName(scenario.getUri().toString());
	}
	
	@AfterStep
	public static void appendScreenshot() {
		Date date = new Date();
		String scenarioName = BasicDefinitions.scenario.getName().split("-")[0].trim();

		try {
		File srcFile = 	((TakesScreenshot)BasicDefinitions.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+File.separator+"screenshot"+File.separator+scenarioName+"_"+date.getTime()+".png"));
		}
		catch(Exception e) {
			Assert.fail("Unable to  take screenshot"+e);
		}
		
	}
}