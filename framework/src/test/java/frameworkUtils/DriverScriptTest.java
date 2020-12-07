package frameworkUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DriverScriptTest extends CoreUtils{
  @BeforeTest
  public void setup() throws FileNotFoundException, IOException {
	config = new PropertiesReader(System.getProperty("user.dir")+"/config.properties") ; 
	  
  }
	

  @Test
  public void launchBrowserTest() {
	  WebDriver driver = new DriverScript().launchBrowser();
	  
  }
}
