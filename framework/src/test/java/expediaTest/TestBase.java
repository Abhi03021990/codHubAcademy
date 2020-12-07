package expediaTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;

import org.testng.annotations.BeforeSuite;

import frameworkUtils.CoreUtils;
import frameworkUtils.DriverScript;
import frameworkUtils.FrameworkParameters;
import frameworkUtils.PropertiesReader;
import frameworkUtils.XlsxReader;

public class TestBase extends CoreUtils{
	@BeforeSuite
	public void initialize() throws FileNotFoundException, IOException {
		loadAllFiles();
		
	DriverScript.launchBrowser();
	FrameworkParameters.currentTestdataSheet="testData";
	FrameworkParameters.currentTestCaseName = "TC_Search_One_way_flight";
		
	}
	public void loadAllFiles() throws FileNotFoundException, IOException {
		config = new PropertiesReader(System.getProperty("user.dir")+"/config.properties");
		String env= config.getData("environment");
		expediaTest = new XlsxReader(System.getProperty("user.dir")+"/src/test/resources/testData/"+env+"/Expedia.xlsx");
	}

}
