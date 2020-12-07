package frameworkUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class DriverScript extends CoreUtils{
	public static WebDriver launchBrowser(){
	 if(config.getData("browser").equalsIgnoreCase("chrome")){
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver.exe");
		 driver = new ChromeDriver();
	 }else if(config.getData("browser").equalsIgnoreCase("ie")) {
		 System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/IEDriverServer.exe");
		 InternetExplorerOptions options = new InternetExplorerOptions().ignoreZoomSettings().disableNativeEvents().introduceFlakinessByIgnoringSecurityDomains(); 
		 driver = new InternetExplorerDriver();
	 }
	 driver.manage().window().maximize();
	return driver;	
		
	}

}
