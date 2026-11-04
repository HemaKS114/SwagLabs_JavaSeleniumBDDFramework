// class will have all the common Methods of framework - for reusability
package utilities;

import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CommonMethods
{
	
	public static JSONObject objRepo;
	//create null object, create a string to store filepath, then create Json parser object, then read the file using filepath and store it into obj then store it as jsonobject
	@SuppressWarnings("unchecked")
	public static void readJsonTestData(){
		Object obj = null;
		
		BasicDefinitions.jsontestdataHashMap.clear();
		try {
		
		String filePath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestData"+File.separator+BasicDefinitions.FeatureName.toLowerCase()+"_testdata.json";
		
		obj = new JSONParser().parse(new FileReader(filePath));
		
		JSONObject objectRepo = (JSONObject) obj;
		BasicDefinitions.jsontestdataHashMap.put("JsonTestData", objectRepo);
		}
		catch(Exception e) {
			Assert.fail("Unable to load test data from file"+e);
		}
		
	}
	
	public static String readTestDatavalues(String fieldTypeName, String testCaseName, String fieldName ) {
		String cellValue = "";
		try {
		readJsonTestData();
		
		/*
		 * if(BasicDefinitions.jsontestdataHashMap.containsKey("JsonTestData") &&
		 * BasicDefinitions.jsontestdataHashMap.get("JsonTestData").containsKey(
		 * fieldTypeName)&&
		 * BasicDefinitions.jsontestdataHashMap.get(fieldTypeName).containsKey(
		 * testCaseName)&&
		 * BasicDefinitions.jsontestdataHashMap.get(testCaseName).containsKey(fieldName)
		 * ) { cellValue =
		 * BasicDefinitions.jsontestdataHashMap.get("JsonTestData").get(fieldTypeName).
		 * get(testCaseName).get(fieldName); }
		 */
			JSONObject jsonData = (JSONObject)
	           BasicDefinitions.jsontestdataHashMap.get("JsonTestData");

				JSONObject fieldType = (JSONObject) jsonData.get(fieldTypeName);

				JSONObject testCase = (JSONObject) fieldType.get(testCaseName);

				cellValue = (String) testCase.get(fieldName);
				
		}
		catch(Exception e) {
			Assert.fail("No test data available"+e);
		}
		return cellValue;
	}
	
	public static void loadObjects(String fileName) {
		try {
		JSONParser parser = new JSONParser();
		
		Object obj = null;
		String filePath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"objects"+File.separator+fileName+".json";
		
		obj = parser.parse(new FileReader(filePath));
		
		objRepo = (JSONObject)obj;
		}
		catch(Exception e) {
			Assert.fail("No objects loaded"+e);
		}
	}
	
	public enum LocatorType{
		
		id, xpath, cssselector, tagname, linktext, partiallinktext, classname;
		
	}
	
	public static By getLocator(String objectReference) {
		
		By locator = null;
		if(objectReference!=null) {
			
			String dataRef = (String)objRepo.get(objectReference);
			
			if(dataRef!=null && dataRef.split(Pattern.quote("|")).length==2) {
				
				LocatorType locatorType = LocatorType.valueOf(dataRef.split(Pattern.quote("|"))[0]);
				switch (locatorType) {
				
				case id:
					locator = By.id(dataRef.split(Pattern.quote("|"))[1]);
					break;
					
				case xpath:
					locator = By.xpath(dataRef.split(Pattern.quote("|"))[1]);
					break;
				default:
					System.out.println("no such locator");
					break;
				}
				
			}
			
			}
		
		return locator;
		
	}
	
	public static WebElement getElement(String objectReference) {
//		return null;
		WebElement locator = null;
		if(objectReference!=null) {
			String dataReference = (String) objRepo.get(objectReference);
			if(dataReference!=null && dataReference.split(Pattern.quote("|")).length == 2) {
				
				LocatorType locatorType = LocatorType.valueOf(dataReference.split(Pattern.quote("|"))[0]);
				switch (locatorType) {
				case id:
					locator = BasicDefinitions.driver.findElement(By.id(dataReference.split(Pattern.quote("|"))[1]));
					break;
				case xpath:
					locator = BasicDefinitions.driver.findElement(By.xpath(dataReference.split(Pattern.quote("|"))[1]));
					break;
				case tagname:
					locator = BasicDefinitions.driver.findElement(By.tagName(dataReference.split(Pattern.quote("|"))[1]));
					break;
				default:
					System.out.println("no such locator");
					break;
				}
				
			}
		}
		return locator;
		
		
	}
	
	public static void enterText(String value, String objRef) 
	{
		try {
		loadObjects(objRef.split(Pattern.quote("_"))[0].toLowerCase());
		By locator = getLocator(objRef);
		value = readTestDatavalues("TestData", BasicDefinitions.TC_id, value);
		BasicDefinitions.driver.findElement(locator).sendKeys(value);
		System.out.println("Value entered is : "+value);

		}
		catch(Exception e) {
			Assert.fail("Unable to enter text"+e);
		}
		
	}
	
	public static void click(String objRef) {
		try {
		
		loadObjects(objRef.split(Pattern.quote("_"))[0].toLowerCase());
		By locator = getLocator(objRef);
		
		BasicDefinitions.driver.findElement(locator).click();

		}
		catch(Exception e) {
			Assert.fail("Unable to click the object"+e);
		}
		
	}
	
	
	
}