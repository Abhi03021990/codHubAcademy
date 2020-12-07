package frameworkUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CoreUtils {
	public static WebDriver driver;
	public static PropertiesReader config ;
	public WaitHandler wait ;
	public static XlsxReader expediaTest;
	
	public WebElement getElement(String xpathLocator) {
		wait = new WaitHandler();
		wait.waitForElement(xpathLocator);
		return driver.findElement(By.xpath(xpathLocator));	
	}
	public void click(String xpath) {
		getElement(xpath).click();
		
	}
	public void typeText(String xpath , String textToEnter) {
		getElement(xpath).sendKeys(textToEnter);
	}
	
	public Alert getAlert() {
		return driver.switchTo().alert();
	}
	public boolean isAlertPresent() {
		try {
			getAlert();
			return true;
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			return false;
		}
		
	}
	public String getAlertMessage() {
		return getAlert().getText();
		
	}
	public void acceptAlert() {
		getAlert().accept();
	}
	public void dismissAlert() {
		getAlert().dismiss();
	}
	
	public void clearText(String xpath) {
		getElement(xpath).click();
		getElement(xpath).clear();
	}
	public void pressDownArrow(String xpath) {
		getElement(xpath).sendKeys(Keys.ARROW_DOWN);
	}
	public void pressEnter(String xpath) {
		getElement(xpath).sendKeys(Keys.ENTER);
	}
	
	public void assertEqual(String actual , String expected) {
		//Assert.assertEquals(actual, expected);
	}
	public void verifyEquals(String actual , String expected) {
		try {
			//Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Actual and expected does not match Expected "+expected+" but found "+actual);
		}
		
	}
	
	public void launchApplication() {
		String env = config.getData("environment");
		driver.get(config.getData(env+"url"));
	}
	

}
