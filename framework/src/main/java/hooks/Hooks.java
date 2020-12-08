package hooks;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import frameworkUtils.CoreUtils;
import frameworkUtils.DriverScript;
import frameworkUtils.FrameworkParameters;
import frameworkUtils.PropertiesReader;
import frameworkUtils.XlsxReader;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	//private TakesScreenshot webDriver;
   // private Scenario scenario;
	@Before
	public void setup() throws FileNotFoundException, IOException {
		//this.scenario = scenario;
		loadAllFiles();
		
		DriverScript.launchBrowser();
		//webDriver = ((TakesScreenshot)CoreUtils.driver);
		FrameworkParameters.currentTestdataSheet="testData";
		FrameworkParameters.currentTestCaseName = "TC_Search_One_way_flight";
		//FrameworkParameters.reportConfigPath = System.getProperty("user.dir")+"/extent-config.xml";
	}
	public void loadAllFiles() throws FileNotFoundException, IOException {
		CoreUtils.config = new PropertiesReader(System.getProperty("user.dir")+"/config.properties");
		String env= CoreUtils.config.getData("environment");
		CoreUtils.expediaTest = new XlsxReader(System.getProperty("user.dir")+"/src/test/resources/testData/"+env+"/Expedia.xlsx");
	}
	

	/*
	 * @AfterStep public void afterStep() {
	 * 
	 * this.scenario.attach(webDriver.getScreenshotAs(OutputType.BYTES),
	 * "image/png", "screenshot"); }
	 */
	@After
	public void after(Scenario scenario ) {
		
		//if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot)(DriverScript.driver)).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", " step");
		//}
		
	}
	

}
