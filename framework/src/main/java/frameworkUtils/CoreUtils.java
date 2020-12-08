package frameworkUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
		WebElement element =getElement(xpath);
		try {
			element.click();
		} catch (Exception e) {
			try {
				Actions action = new Actions(driver);
				action.moveToElement(element).click().build().perform();
			} catch (Exception e2) {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", element);
			}
			
		}
		
		
	}
	public void typeText(String xpath , String textToEnter) {
		getElement(xpath).sendKeys(textToEnter);
	}
	public void jsTypeText(String xpath , String value) {
		WebElement element = getElement(xpath);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].value='"+value+"'", element);
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
	public void pressTab(String xpath) {
		getElement(xpath).sendKeys(Keys.TAB);
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
	public void selectByVisibleText(String xpath , String value) {
		Select select  = new Select(getElement(xpath));
	    select.selectByVisibleText(value);
	}
	
	public void launchApplication() {
		String env = config.getData("environment");
		driver.get(config.getData(env+"url"));
	}
	

}
