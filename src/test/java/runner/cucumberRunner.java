package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features ="src/test/resources/features", glue = "stepdef",
monochrome = true,
plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"pretty","json:target/cucumber-reports/Cucumber.json",
"junit:target/cucumber-reports/Cucumber.xml",
"html:target/cucumber-reports/Cucumber.html"
})


public class cucumberRunner extends AbstractTestNGCucumberTests {
	 
}