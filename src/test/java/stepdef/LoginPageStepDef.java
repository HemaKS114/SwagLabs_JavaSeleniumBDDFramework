package stepdef;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BasicDefinitions;
import utilities.CommonMethods;

public class LoginPageStepDef{
	
@Given("I launch the application")
public void i_launch_the_application() {
    
	try {
		BasicDefinitions.launchBrowser();
		BasicDefinitions.OpenURL();
	} catch (IOException e) {
		System.out.println("Unable to launch the browser, check config File");
		e.printStackTrace();
	}
	
}
@When("I enter the {string} in {string} field")
public void i_enter_the_in_field(String value, String objRef) throws FileNotFoundException, IOException, ParseException {
    
	CommonMethods.enterText(value, objRef);
	
	
}
@Then("I click on the {string}")
public void i_click_on_the(String objRef) throws FileNotFoundException, IOException, ParseException {
    
	CommonMethods.click(objRef);
}

}