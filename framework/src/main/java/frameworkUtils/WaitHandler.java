package frameworkUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHandler extends CoreUtils{
	//public WebDriver driver ;
	public WebDriverWait wait;
	
	public WaitHandler() {
		wait = new WebDriverWait(driver, 60);
	}
	
	public void waitForElement(String xpath) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
	public void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElementToBeloaded(String xpath) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
	}
	
	 

}
